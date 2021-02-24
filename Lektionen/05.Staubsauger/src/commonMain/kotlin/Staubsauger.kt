import com.soywiz.korge.view.*
import com.soywiz.korge.view.tween.rotateBy
import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korma.geom.cos
import com.soywiz.korma.geom.degrees
import com.soywiz.korma.geom.minus
import com.soywiz.korma.geom.plus
import com.soywiz.korma.geom.sin


class Staubsauger(bitmap: Bitmap) : BaseImage(bitmap) {
    var velocity : Int = (1..3).random()


    var drehwinkel = (0..359).random().degrees

    init {
        scale = 0.06
        anchor(0.5, 0.5)
        x = 300.0
        y = 200.0

        println(drehwinkel)
    }

    fun entscheiden(){

        onCollision {
            drehwinkel += (150..210).random().degrees
        }

        fahren()
    }

    fun fahren(){
        rotation(drehwinkel)

        val dx = velocity * cos(drehwinkel-90.degrees)
        val dy  = velocity * sin(drehwinkel-90.degrees)
        x += dx
        y += dy
    }
}