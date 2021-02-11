import com.soywiz.korge.view.Image
import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korim.color.RGBA

class Gesteinsplanet(
        bild : Bitmap,
        groesse : Double,
        bahnradius : Double,
        drehtSichUm : Stern,
        mitGeschwindigkeit : Double
) : Planet(
        bild = bild,
        groesse = groesse,
        bahnradius = bahnradius,
        drehtSichUm = drehtSichUm,
        mitGeschwindigkeit = mitGeschwindigkeit
)