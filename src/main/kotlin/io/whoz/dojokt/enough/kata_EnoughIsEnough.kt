package io.whoz.dojokt

// https://www.codewars.com/kata/554ca54ffa7d91b236000023/train/kotlin
object EnoughIsEnough {
    fun deleteNth(elements: IntArray, maxOccurrences: Int): IntArray {
        val itemsCount = mutableMapOf<Int, Long>()
        return if (maxOccurrences <= 0)
            IntArray(0)
        else
            elements.distinctBy { element ->
            val itemCount = (itemsCount[element] ?: 0) + 1
            itemsCount[element] = itemCount
            if (itemCount < maxOccurrences) "$element $itemCount" else "$element $maxOccurrences"
        }.toIntArray()
    }
}