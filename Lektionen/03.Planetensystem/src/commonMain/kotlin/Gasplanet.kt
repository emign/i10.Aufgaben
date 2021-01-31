import com.soywiz.korim.color.RGBA

class Gasplanet(
    groesse : Double,
    bahnradius : Double,
    farbe : RGBA,
    farbeHuelle : RGBA,
    dickeHuelle : Double,
    drehtSichUm : Stern,
    mitGeschwindigkeit : Double
) : Planet(
    planetenRadius = groesse,
    bahnradius = bahnradius,
    farbe = farbe,
    farbeHuelle = farbeHuelle,
    dickeHuelle = dickeHuelle,
    drehtSichUm = drehtSichUm,
    mitGeschwindigkeit = mitGeschwindigkeit
)