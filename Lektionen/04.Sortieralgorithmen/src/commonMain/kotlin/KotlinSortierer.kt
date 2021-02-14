import com.soywiz.korge.view.SolidRect

object KotlinSortierer : Sortieralgorithmus() {
    override var name: String = "Kotlinsortierer"

    override suspend fun sortieren(array: Array<SolidRect>) {
        array.sortBy { it.height.toInt() }
        }
    }

