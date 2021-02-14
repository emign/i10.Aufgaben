import com.soywiz.korge.view.SolidRect

object SelectionSort : Sortieralgorithmus() {
    override var name: String = "SelectionSort"

    override suspend fun sortieren(array: Array<SolidRect>) {
        // Blauer Zeigefinger
        for (i in array.indices) {
            var min = array[i].height.toInt()
            var minPos = i
            var j = i + 1
            // orangener Zeigefinger
            while (j < array.size) {
                SortierRoboter.countVergleich()
                if (array[j].height.toInt() < min) {
                    // Neues Minimum gefunden
                    min = array[j].height.toInt()
                    minPos = j
                }
                j++
            }
            val tmp = array[i]
            array[i] = array[minPos]
            array[minPos] = tmp
            SortierRoboter.positionenAktualisieren()
        }
    }
}
