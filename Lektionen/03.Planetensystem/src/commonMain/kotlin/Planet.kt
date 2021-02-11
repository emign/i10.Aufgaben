import com.soywiz.korge.view.BaseImage
import com.soywiz.korge.view.Circle
import com.soywiz.korge.view.Image
import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korim.color.Colors
import com.soywiz.korim.color.RGBA
import com.soywiz.korio.file.std.resourcesVfs
import kotlin.math.cos
import kotlin.math.sin

abstract class Planet (
        val bild : Bitmap ,
        var groesse : Double,
        var bahnradius : Double = 100.0,
        drehtSichUm: Stern,
        mitGeschwindigkeit: Double = 0.0) :
  BaseImage(bild) {

    var umlaufbahn = Umlaufbahn(drehtSichUm, bahnradius, mitGeschwindigkeit)

    init {
        width = groesse
        height = groesse


        x = umlaufbahn.centerX + bahnradius
        y = umlaufbahn.centerY - groesse/2
    }

    fun animate(){
        x = cos(umlaufbahn.winkel) * bahnradius + umlaufbahn.centerX - groesse/2
        y = sin(umlaufbahn.winkel) * bahnradius + umlaufbahn.centerY - groesse/2
        umlaufbahn.winkelAktualisieren()

    }
}