package kakao

fun main(args: Array<String>) {

    require("[\"######\", \"###  #\", \"##  ##\", \" #### \", \" #####\", \"### # \"]" == solve(6, arrayOf(46, 33, 33, 22, 31, 50), arrayOf(27, 56, 19, 14, 14, 10)))
    require("[\"#####\", \"# # #\", \"### #\", \"#  ##\", \"#####\"]" == solve(5, arrayOf(9, 20, 28, 18, 11), arrayOf(30, 1, 21, 17, 28)))
}

fun solve(size: Int, firstMap: Array<Int>, secondMap: Array<Int>): String =
        (0 until size).joinToString(prefix = "[", postfix = "]", separator = ", ") { createLine(size, firstMap[it] or secondMap[it]) }

tailrec fun createLine(size: Int, value: Int, acc: String = ""): String = when (size) {
    0 -> "\"$acc\""
    else -> createLine(size - 1, value / 2, createPoint(value) + acc)
}

private fun createPoint(value: Int): String = when {
    value % 2 == 0 -> " "
    else -> "#"
}
