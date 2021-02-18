import com.soywiz.korge.view.SolidRect

object InsertionSort : Sortieralgorithmus(){
    override var name: String = "InsertionSort"

    override suspend fun sortieren(array: Array<SolidRect>) {
        for (i in array.indices){
            val einzusortierenderWert = array[i]
            var j = i
            while(j > 0 && array[j-1].height > einzusortierenderWert.height){
                array[j] = array[j-1]
                j--
                SortierRoboter.countVergleich()
            }
            array[j] = einzusortierenderWert
            SortierRoboter.positionenAktualisieren()
        }
    }
}