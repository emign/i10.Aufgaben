import com.soywiz.korge.view.SolidRect

object BubbleSortSchlau : Sortieralgorithmus() {
    override var name: String = "Schlaur BubbleSort"

    override suspend fun sortieren(array: Array<SolidRect>) {
        // Blauer Zeigefinger

            var i = 0
            do {
                var getauscht = false
                for (j in 0 until array.indices.last - i) {
                    SortierRoboter.countVergleich()
                    if (array[j].height.toInt() > array[j + 1].height.toInt()) {
                        val tmp = array[j]
                        array[j] = array[j + 1]
                        array[j + 1] = tmp
                        getauscht = true
                    }
                    SortierRoboter.positionenAktualisieren()
                }
                i++
            } while (getauscht)
    }
}
