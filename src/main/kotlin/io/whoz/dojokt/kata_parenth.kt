package io.whoz.dojokt

fun nbParenthesisCombination(nbPairs: Int): Long =
    when (nbPairs) {
        0 -> 0
        1 -> 1
        2 -> 2
        else -> (nbPairs - 1) * nbParenthesisCombination(nbPairs - 1) + 1
    }

fun parenthCombination(nbPairs: Int): Set<String> =
    when (nbPairs) {
        0 -> emptySet()
        1 -> setOf("()")
        2 -> setOf("()()","(())")
        else ->
            parenthCombination(nbPairs-1).map { combinationPrev -> "()$combinationPrev" }.toSet() +
            parenthCombination(nbPairs-1).map { combinationPrev -> "($combinationPrev)" }.toSet() +
            parenthCombination(nbPairs-1).map { combinationPrev -> "$combinationPrev()" }.toSet()
    }