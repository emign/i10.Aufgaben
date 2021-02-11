import com.soywiz.korge.view.BaseImage
import com.soywiz.korim.bitmap.Bitmap
import kotlin.math.cos
import kotlin.math.sin

class Mond (
        val bild : Bitmap,
        var groesse : Double,
        var bahnradius : Double = 10.0,
        drehtSichUm: Planet,
        mitGeschwindigkeit: Double = 0.0) :
        BaseImage(bild) {

    var umlaufbahn = Umlaufbahn(drehtSichUm, bahnradius, mitGeschwindigkeit)

    init {
        width = groesse
        height = groesse

        x = umlaufbahn.centerX + bahnradius
        y = umlaufbahn.centerY - groesse/2

        println("$x,$y")
    }

    fun animate(){

        // Das as Planet nennt man einen sog. Cast. Dies ist erforderlich, da dass Attribut groesse nur in Planet bekannt ist
        // Die Referenz umlaufbahn.umZentralKoerper ist aber ein View
        x = cos(umlaufbahn.winkel) * bahnradius + umlaufbahn.umZentralKoerper.x + (umlaufbahn.umZentralKoerper as Planet).groesse/2
        y = sin(umlaufbahn.winkel) * bahnradius + umlaufbahn.umZentralKoerper.y + (umlaufbahn.umZentralKoerper as Planet).groesse/2
        umlaufbahn.winkelAktualisieren()



    }
}