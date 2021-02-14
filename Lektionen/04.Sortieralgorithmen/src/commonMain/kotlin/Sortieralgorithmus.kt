import com.soywiz.korge.view.SolidRect

abstract class Sortieralgorithmus {
    abstract var name : String
    abstract suspend fun sortieren(array: Array<SolidRect>)
}