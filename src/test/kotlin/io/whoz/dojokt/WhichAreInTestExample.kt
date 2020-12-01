package io.whoz.dojokt

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class WhichAreInTestExample {
    @Test
    fun testFixed1() {
        val a2 = arrayOf<String>("lively", "alive", "harp", "sharp", "armstrong")
        assertArrayEquals(arrayOf<String>("live", "strong"), inArray(arrayOf<String>("xyz", "live", "strong"), a2))

    }
    @Test
    fun testFixed2() {
        val a2 = arrayOf<String>("lively", "alive", "harp", "sharp", "armstrong")
        assertArrayEquals(arrayOf<String>("arp", "live", "strong"), inArray(arrayOf<String>("live", "strong", "arp"), a2))
    }

    @Test
    fun testFixed3() {
        val a2 = arrayOf<String>("lively", "alive", "harp", "sharp", "armstrong")
        assertArrayEquals(arrayOf<String>(), inArray(arrayOf<String>("tarp", "mice", "bull"), a2))
    }
    @Test
    fun testFixed4() {
        val a2 = arrayOf<String>("lively", "alive", "harp", "sharp", "armstrong","micely")
        assertArrayEquals(arrayOf<String>("mice"), inArray(arrayOf<String>("tarp", "mice", "mice", "bull"), a2))
    }

}