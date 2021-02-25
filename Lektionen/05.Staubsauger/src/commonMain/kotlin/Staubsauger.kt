import com.soywiz.klock.DateTime
import com.soywiz.klock.TimeSpan
import com.soywiz.klock.milliseconds
import com.soywiz.korge.time.delay
import com.soywiz.korge.time.delayFrame
import com.soywiz.korge.view.*

import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korio.async.launch
import com.soywiz.korio.lang.cancel
import com.soywiz.korma.geom.cos
import com.soywiz.korma.geom.degrees
import com.soywiz.korma.geom.minus
import com.soywiz.korma.geom.plus
import com.soywiz.korma.geom.sin
import com.soywiz.korma.geom.vector.VectorPath
import com.soywiz.korma.geom.vector.circle


class Staubsauger(bitmap: Bitmap) : BaseImage(bitmap) {
    var velocity : Int = (30..50).random()

    var drehwinkel = (0..359).random().degrees

    var letzeKollisionMit : View? = null

    init {
        scale = 0.06
        anchor(0.5, 0.5)
        x = 300.0
        y = 200.0
        onCollision   (filter = {
            it is Kollisionsrelevant && it != letzeKollisionMit} ) {
            zuruecksetzen()
        }
    }

   fun aktion(){
        fahren()
    }

    private fun fahren(){
        rotation(drehwinkel)
        val dx = velocity * cos(drehwinkel-90.degrees)
        val dy  = velocity * sin(drehwinkel-90.degrees)
        x += dx
        y += dy
    }

    private fun zuruecksetzen(){
        drehwinkel += 180.degrees
        fahren()
        drehwinkel += (-50..50).random().degrees
    }
}

