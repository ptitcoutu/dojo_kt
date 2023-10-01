package io.whoz.dojokt


    fun StringChallenge(str: String): String {
        val strSplitted = str.split(" ")
        val pattern = strSplitted[0]
        val inputText = strSplitted[1]
        val regex = stringChallengeToClassicalRegexp(pattern)
        println(regex)
        return inputText.matches(stringChallengeToClassicalRegexp(pattern)).toString()
    }

    fun stringChallengeToClassicalRegexp(pattern: String) = Regex(
        pattern
            .replace("2","1").replace("3","2")
            .replace("+", "[a-zA-Z]")
            .replace("$", "[1-9]")
            .replace(Regex("\\*\\{([1-9]+)}")) { matchResult: MatchResult ->
                "(.)\\1{${(matchResult.groups[1]?.value?.toInt()?:1) - 1}}"
            }
            .replace("*", "(.)\\1{2}")
    )



fun main() {
    println(StringChallenge("*{4} zzzz"))
}