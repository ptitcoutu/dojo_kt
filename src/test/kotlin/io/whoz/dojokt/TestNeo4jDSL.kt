package io.whoz.dojokt

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.neo4j.cypherdsl.core.Cypher
import org.neo4j.cypherdsl.core.Cypher.create
import org.neo4j.cypherdsl.core.Cypher.match
import org.neo4j.cypherdsl.core.Statement
import org.neo4j.cypherdsl.core.StatementBuilder
import org.neo4j.cypherdsl.core.renderer.Renderer
import org.neo4j.driver.GraphDatabase
import org.testcontainers.containers.Neo4jContainer

class KNeo4jContainer(imageName: String) : Neo4jContainer<KNeo4jContainer>(imageName)

class TestNeo4jDSL {


    companion object {
        val cypherRenderer: Renderer = Renderer.getDefaultRenderer()
        val neo4jContainer: KNeo4jContainer = KNeo4jContainer("neo4j:3.5.12").withoutAuthentication()
        init {
            neo4jContainer.start()
        }
    }

    @Test
    fun testSimple() {
        val m = Cypher.node("Movie").named("m")
        val statement = match(m)
            .returning(m)
            .build()

        assertEquals("MATCH (m:`Movie`) RETURN m", cypherRenderer.render(statement))

        val driver = GraphDatabase.driver(neo4jContainer.boltUrl)
        driver.session().use { session ->
            session.beginTransaction().use { transaction ->
                assertEquals(transaction.run(cypherRenderer.render(statement)).list { record ->
                    record.asMap()
                }, emptyList<Map<String,Any>>())
                val createStmt : StatementBuilder.BuildableStatement = create(m)
                val createStatement: Statement = createStmt.build()
                transaction.run(
                    cypherRenderer.render(createStatement)
                )
                assertEquals(transaction.run(cypherRenderer.render(statement)).list { record ->
                    record.asMap().toString()
                }, listOf("{m=node<0>}"))
                transaction.commit()
            }
        }
    }
}