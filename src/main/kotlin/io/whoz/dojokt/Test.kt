package io.whoz.dojokt

fun main(args: Array<String>) {
    val srcArray = arrayOf(5, 10, 3, 1, 4, 8)
    val max = max(srcArray)
    val oddArray = odd(srcArray)
    if (max == 10 && oddArray.contentEquals(arrayOf(1, 3, 5))) {
        println("GOOD")
    } else {
        throw IllegalStateException("ERROR")
    }
}
fun max(array: Array<Int>): Int = array.maxOrNull()
fun odd(array: Array<Int>): Array<Int> = array.filter {
    it % 2 == 1
}.sort()