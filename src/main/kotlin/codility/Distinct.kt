package codility

fun main(args: Array<String>) {

    require(3 == solve(arrayOf(2, 1, 1, 2, 3, 1)))
    require(4 == solve(arrayOf(3, 4, 1, 2, 3)))
}

private fun solve(values: Array<Int>) = values.toSet().size