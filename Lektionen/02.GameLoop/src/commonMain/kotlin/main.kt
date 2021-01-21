import com.soywiz.klock.seconds
import com.soywiz.korge.*
import com.soywiz.korge.tween.*
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import com.soywiz.korim.format.*
import com.soywiz.korio.file.std.*
import com.soywiz.korma.geom.degrees
import com.soywiz.korma.interpolation.Easing

suspend fun main() = Korge(width = 800, height = 800, bgcolor = Colors.DARKGRAY) {
    val kreis = Kreis()

    kreis.radius = 100.0
    kreis.fill = Colors.GREENYELLOW

    val breiteStage = this.stage.width
    val hoeheStage = this.stage.height

    kreis.x = breiteStage/2 - kreis.radius
    kreis.y = hoeheStage/2 - kreis.radius

    val farbArray = arrayOf(Colors.GREEN, Colors.DEEPPINK, Colors.AZURE, Colors.BISQUE,
                            Colors.BLUE, Colors.RED, Colors.FUCHSIA, Colors.MEDIUMSPRINGGREEN)


    kreis.addUpdater {
        fill = farbArray.random()

        if (y == hoeheStage - radius*2 || y == 0.0){
            deltaY = deltaY * -1
        }

        if (x == breiteStage - radius*2 || x == 0.0){
            deltaX = deltaX * -1
        }

        x = x + deltaX
        y = y + deltaY

    }

    addChild(kreis)

}

