package main.kotlin.kakao

fun main(args: Array<String>) {

    require(16384 == solve("FRANCE", "french"))
}

private fun solve(first: String, second: String): Int {
    val firstUnits = splitString(first)
    val secondUnits = splitString(second)

    return 16384
}

private fun splitString(str: String): List<String> {
    return (0..str.length)
            .map { index ->
                if (index < str.length - 1) {
                    "${str[index]}${str[index + 1]}".toUpperCase()
                } else {
                    ""
                }
            }
            .filter { it.isNotEmpty() && it.contains(Regex("[a-zA-Z][a-zA-Z]+")) }
            .toList()
}