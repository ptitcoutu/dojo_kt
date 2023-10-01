package io.whoz.dojokt

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ParenthesisCombinationsExample {
    @Test
    fun testSimple() {
        assertEquals(0, nbParenthesisCombination(0)) // Nothing
        assertEquals(setOf("()"), parenthCombination(1))
        assertEquals(1, nbParenthesisCombination(1)) // 1 ()
        assertEquals(setOf("()()", "(())"), parenthCombination(2))
        assertEquals(2, nbParenthesisCombination(2)) // 1 () (), 2 (())
        assertEquals(setOf("()()()", "(())()","(()())", "()(())", "((()))"), parenthCombination(3))
        assertEquals(5, nbParenthesisCombination(3)) // 1 () () (), 2 () (()), 3 (() ()), 4 ((())), 1bis () () () 5 (()) ()
        assertEquals(
            setOf(
                "()()()()", "(())()()","(()()())", "()(())()", "((()))",
                "()()()", "(())()","(()())", "()(())", "((()))",
                "()()()", "(())()","(()())", "()(())", "((()))",
                "()()()", "(())()","(()())", "()(())", "((()))"
            ),
            parenthCombination(4)
        )
        // 1 () x 5 combinations, 2 ( x 5 combinations ), 3 x 5 combinations () - 1 = 14
        assertEquals(14, nbParenthesisCombination(4))

    }

}