package io.whoz.dojokt.enough

import io.whoz.dojokt.EnoughIsEnough
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class EnoughIsEnoughTest {
    @Test
    @Throws(Exception::class)
    fun deleteNth() {
        assertArrayEquals(
            intArrayOf(20, 37, 21),
            EnoughIsEnough.deleteNth(intArrayOf(20, 37, 20, 21), 1)
        )
        assertArrayEquals(
            intArrayOf(1, 1, 3, 3, 7, 2, 2, 2),
            EnoughIsEnough.deleteNth(intArrayOf(1, 1, 3, 3, 7, 2, 2, 2, 2), 3)
        )
        assertArrayEquals(
            intArrayOf(1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5),
            EnoughIsEnough.deleteNth(intArrayOf(1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1), 3)
        )
        assertArrayEquals(
            intArrayOf(1, 1, 1, 1, 1),
            EnoughIsEnough.deleteNth(intArrayOf(1, 1, 1, 1, 1), 5)
        )
        assertArrayEquals(
            intArrayOf(),
            EnoughIsEnough.deleteNth(intArrayOf(), 5)
        )
    }
}