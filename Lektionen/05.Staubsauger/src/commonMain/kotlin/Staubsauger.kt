import com.soywiz.korge.view.BaseImage
import com.soywiz.korge.view.Image
import com.soywiz.korge.view.rotation
import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korma.geom.Angle
import com.soywiz.korma.geom.degrees
import kotlin.math.atan2

class Staubsauger(bitmap: Bitmap) : BaseImage(bitmap) {
    var vx : Int = (0..3).random()
    var vy : Int = (0..3).random()

    var dx : Int = vx
    var dy : Int = vy

    var drehwinkel = 0.degrees

    fun entscheiden(){
        fahren()
    }

    fun fahren(){

        drehwinkel = Angle(atan2(dx.toDouble(), dy.toDouble()))

        rotation(drehwinkel)
        x += dx
        y += dy


    }
}