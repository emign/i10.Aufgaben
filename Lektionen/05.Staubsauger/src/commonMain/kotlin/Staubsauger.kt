import com.soywiz.korge.view.BaseImage
import com.soywiz.korge.view.Image
import com.soywiz.korim.bitmap.Bitmap

class Staubsauger(bitmap: Bitmap) : BaseImage(bitmap) {
    var dx : Int = (0..3).random()
    var dy : Int = (0..3).random()

    fun entscheiden(){
        fahren()
    }

    fun fahren(){
        x += dx
        y += dy
    }
}