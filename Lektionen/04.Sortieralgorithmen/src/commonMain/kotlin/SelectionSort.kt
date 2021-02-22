import com.soywiz.korge.view.SolidRect

object SelectionSort : Sortieralgorithmus() {
    override var name: String = "SelectionSort"
    override suspend fun sortieren(array: Array<SolidRect>) {
        for(i in array.indices){
            var min = i
            var j = i + 1
            while (j < array.size) {
                SortierRoboter.countVergleich()
                if (array[min].height > array[j].height) {
                    min = j
                }
                j++
            }

            var a = array[min]
            array[min] = array[i]
            array[i] = a
            SortierRoboter.positionenAktualisieren()
        }
    }
}