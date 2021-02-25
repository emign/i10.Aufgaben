import com.soywiz.korge.view.SolidRect

object BogoSort : Sortieralgorithmus(){
    override var name: String = "BogoSort"

    override suspend fun sortieren(array: Array<SolidRect>) {

        while (unsortiert(array)){
            array.shuffle()
            SortierRoboter.positionenAktualisieren()
            SortierRoboter.countVergleich()
        }
    }

    private fun unsortiert(array: Array<SolidRect>) : Boolean {
        var sortiert = true
        for (i in 0 until array.indices.last){
            if (array[i].height > array[i+1].height){
                sortiert = false
            }
        }
        return !sortiert
    }
}