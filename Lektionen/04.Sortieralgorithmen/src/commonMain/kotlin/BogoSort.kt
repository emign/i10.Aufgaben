import com.soywiz.korge.view.SolidRect

object BogoSort : Sortieralgorithmus(){
    override var name: String = "BogoSort"

    override suspend fun sortieren(array: Array<SolidRect>) {
        while (!isSorted(array)){
            array.shuffle()
            SortierRoboter.countVergleich()
            SortierRoboter.positionenAktualisieren()
        }
    }

    private fun isSorted(array: Array<SolidRect>) : Boolean {
        var sortiert = true
        for (i in 0 until array.indices.last){
            if (array[i].height > array[i+1].height){
                sortiert = false
            }
        }
        return sortiert
    }
}