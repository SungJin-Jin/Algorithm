fun main(args: Array<String>) {
    require(
            listOf(1, 2, 4, 5, 7, 10, 20, 40, 100) ==
                    quickSort(listOf(1, 5, 10, 2, 4, 7, 100, 20, 40))
    )
}

fun quickSort(list: List<Int>): List<Int> = when {
    list.size <= 1 -> list
    else -> {
        val pivot = list.first()
        val (left, right) = list.filter { it != pivot }.partition { it < pivot }

        quickSort(left) + pivot + quickSort(right)
    }
}
