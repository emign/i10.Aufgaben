import com.soywiz.korge.view.Circle
import com.soywiz.korim.color.Colors
import com.soywiz.korim.color.RGBA
import kotlin.math.cos
import kotlin.math.sin

abstract class Planet (var planetenRadius: Double = 100.0,
                       var bahnradius : Double = 100.0,
                       var farbe: RGBA = Colors.GREEN,
                       var farbeHuelle: RGBA = farbe,
                       var dickeHuelle: Double = 0.0,
                       drehtSichUm: Stern,
                       mitGeschwindigkeit: Double = 0.0) :
        Circle(radius = planetenRadius, fill = farbe, stroke = farbeHuelle, strokeThickness = dickeHuelle){

    var umlaufbahn = Umlaufbahn(drehtSichUm, bahnradius, mitGeschwindigkeit)

    init {
        x = umlaufbahn.centerX + bahnradius
        y = umlaufbahn.centerY - radius
    }

    fun animate(){
        x = cos(umlaufbahn.winkel) * bahnradius + umlaufbahn.centerX
        y = sin(umlaufbahn.winkel) * bahnradius + umlaufbahn.centerY
        umlaufbahn.winkelAktualisieren()

    }
}