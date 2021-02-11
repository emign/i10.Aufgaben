import com.soywiz.korge.Korge
import com.soywiz.korge.view.addUpdater
import com.soywiz.korim.color.Colors
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs

suspend fun main() = Korge(width = 1600, height = 1000, bgcolor = Colors["#2b2b2b"]) {
    val sonne = Stern()
    sonne.x = this.width/2 - sonne.radius
    sonne.y = this.height/2 - sonne.radius
    addChild(sonne)

    val merkurBitmap = resourcesVfs["merkur.png"].readBitmap()
    val venusBitmap = resourcesVfs["venus.png"].readBitmap()
    val erdeBitmap = resourcesVfs["erde.png"].readBitmap()
    val marsBitmap = resourcesVfs["mars.png"].readBitmap()
    val jupiterBitmap = resourcesVfs["jupiter.png"].readBitmap()
    val saturnBitmap = resourcesVfs["saturn.png"].readBitmap()
    val uranusBitmap = resourcesVfs["uranus.png"].readBitmap()
    val neptunBitmap = resourcesVfs["neptun.png"].readBitmap()
    val mondBitmap = resourcesVfs["mond.png"].readBitmap()



    val merkur = Gesteinsplanet(
            bild = merkurBitmap,
            groesse = 20.0,
            bahnradius = 130.0,
            drehtSichUm = sonne,
            mitGeschwindigkeit = 0.005 )

    val venus = Gesteinsplanet(
            bild = venusBitmap,
            groesse = 22.0,
            bahnradius = 170.0,
            drehtSichUm = sonne,
            mitGeschwindigkeit = 0.002 )



    val erde = Gesteinsplanet(
            bild = erdeBitmap,
            groesse = 40.0,
            bahnradius = 210.0,
            drehtSichUm = sonne,
            mitGeschwindigkeit = 0.006 )

    val erdenMond = Mond(
            bild = mondBitmap,
            groesse = 5.0,
            bahnradius = 30.0,
            drehtSichUm = erde,
            mitGeschwindigkeit = 0.002 )

    val mars = Gesteinsplanet(
            bild = marsBitmap,
            groesse = 40.0,
            bahnradius = 260.0,
            drehtSichUm = sonne,
            mitGeschwindigkeit = 0.009 )

    val jupiter = Gasplanet(
            bild = jupiterBitmap,
            groesse = 80.0,
            bahnradius = 320.0,
            drehtSichUm = sonne,
            mitGeschwindigkeit = 0.0065  )

    val saturn = Gasplanet(
            bild = saturnBitmap,
            groesse = 90.0,
            bahnradius = 420.0,
            drehtSichUm = sonne,
            mitGeschwindigkeit = 0.0072  )

    val uranus = Gesteinsplanet(
            bild = uranusBitmap,
            groesse = 30.0,
            bahnradius = 520.0,
            drehtSichUm = sonne,
            mitGeschwindigkeit = 0.0052 )

    val neptun = Gesteinsplanet(
            bild = neptunBitmap,
            groesse = 20.0,
            bahnradius = 620.0,
            drehtSichUm = sonne,
            mitGeschwindigkeit = 0.005 )

    val planeten = listOf(
        merkur, venus, erde, mars, jupiter, saturn, uranus, neptun
    )
    addChildren(planeten)
    addChild(erdenMond)

    addUpdater {
        planeten.map {
            it.animate()
        }
        erdenMond.animate()
    }


}

