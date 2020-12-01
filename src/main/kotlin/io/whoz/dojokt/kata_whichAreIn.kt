package io.whoz.dojokt

fun inArray(array1: Array<String>, array2: Array<String>): Array<String> {
    return array1.filter { array2.find { mainText -> mainText.contains(it) } != null }.toSortedSet().toTypedArray()
}