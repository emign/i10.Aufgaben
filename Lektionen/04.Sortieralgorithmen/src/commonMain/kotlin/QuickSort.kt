import com.soywiz.korge.view.SolidRect

object QuickSort : Sortieralgorithmus() {
    override var name: String = "QuickSort"

    override suspend fun sortieren(array: Array<SolidRect>) {
        quickSort(array, 0, array.lastIndex)
    }

    suspend fun quickSort(array: Array<SolidRect>, left: Int, right: Int) {
        val index = partition(array, left, right)
        if (left < index - 1) { // 2) Sorting left half
            quickSort(array, left, index - 1)
        }
        if (index < right) { // 3) Sorting right half
            quickSort(array, index, right)
        }
    }

    suspend fun partition(array: Array<SolidRect>, l: Int, r: Int): Int {
        var left = l
        var right = r
        val pivot = array[(left + right) / 2].height.toInt() // 4) Pivot Point
        while (left <= right) {
            SortierRoboter.positionenAktualisieren()
            SortierRoboter.countVergleich()
            while (array[left].height.toInt() < pivot) left++ // 5) Find the elements on left that should be on right

            while (array[right].height.toInt() > pivot) right-- // 6) Find the elements on right that should be on left

            // 7) Swap elements, and move left and right indices
            if (left <= right) {
                val tmp = array[left]
                array[left] = array[right]
                array[right] = tmp
                left++
                right--
            }
        }
        return left
    }
}
