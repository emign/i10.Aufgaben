import com.soywiz.korge.view.SolidRect

object BubbleSort : Sortieralgorithmus() {
    override var name: String = "BubbleSort"

    override suspend fun sortieren(array: Array<SolidRect>) {
        for (i in array.indices) {
            for (j in 0 until array.indices.last) {
                SortierRoboter.countVergleich()
                if (array[j].height.toInt() > array[j + 1].height.toInt()) {
                    val tmp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = tmp
                  //  SortierRoboter.playSound(array[j])
                }
                SortierRoboter.positionenAktualisieren()

            }
        }
    }
}