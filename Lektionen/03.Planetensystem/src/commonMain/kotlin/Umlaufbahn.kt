import com.soywiz.korge.view.View

class Umlaufbahn(
        var umZentralKoerper: View,
        var radius : Double = 100.0,
        var umlaufGeschwindigkeit : Double,
        var winkel : Double = 0.0,
        var centerX : Double = umZentralKoerper.x + umZentralKoerper.width/2,
        var centerY : Double = umZentralKoerper.y + umZentralKoerper.width/2
) {

    fun winkelAktualisieren(){
        winkel += umlaufGeschwindigkeit

    }


}