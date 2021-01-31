import com.soywiz.korim.color.RGBA

class Gesteinsplanet(
    groesse : Double,
    bahnradius : Double,
    farbe : RGBA,
    drehtSichUm : Stern,
    mitGeschwindigkeit : Double
) : Planet(
    planetenRadius = groesse,
    bahnradius = bahnradius,
    farbe = farbe,
    drehtSichUm = drehtSichUm,
    mitGeschwindigkeit = mitGeschwindigkeit
)