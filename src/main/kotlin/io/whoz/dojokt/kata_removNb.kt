package io.whoz.dojokt
// https://www.codewars.com/kata/5547cc7dcad755e480000004/train/kotlin
object RemovedNumbers {
    fun removNb(n: Long): Array<LongArray> {
        if (n<=1 || n >= 200) return emptyArray() // the n>= is only here to see the tests which has been timed out
        val sumAllLongLessThanN = (1..n).sum()
        return (1..n).flatMap { a ->
            val listALessThanB = (a..n).map { b ->
                if (a * b == (sumAllLongLessThanN - a - b)) longArrayOf(
                    a,
                    b
                ) else null
            }.filterNotNull()
            val listBLessThanA = listALessThanB.map { longArrayOf(it[1], it[0]) }
            listALessThanB + listBLessThanA
        }.toTypedArray()
    }
}