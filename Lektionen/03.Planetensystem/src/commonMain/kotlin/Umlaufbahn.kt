class Umlaufbahn(
        var umSonne: Stern,
        var radius : Double = 100.0,
        var umlaufGeschwindigkeit : Double,
        var winkel : Double = 0.0,
        var centerX : Double = umSonne.x + umSonne.radius,
        var centerY : Double = umSonne.y + umSonne.radius
) {

    fun winkelAktualisieren(){
        winkel += umlaufGeschwindigkeit
    }
}