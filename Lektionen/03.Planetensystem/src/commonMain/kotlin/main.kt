import com.soywiz.korge.Korge
import com.soywiz.korge.view.addUpdater
import com.soywiz.korim.color.Colors

suspend fun main() = Korge(width = 1600, height = 1000, bgcolor = Colors["#2b2b2b"]) {
    val sonne = Stern()
    sonne.x = this.width/2 - sonne.radius
    sonne.y = this.height/2 - sonne.radius
    addChild(sonne)

    val merkur = Gesteinsplanet(groesse = 10.0,
        bahnradius = 130.0,
        farbe = Colors.MEDIUMAQUAMARINE,
        drehtSichUm = sonne,
        mitGeschwindigkeit = 0.005 )

    val venus = Gesteinsplanet(groesse = 15.0,
        bahnradius = 170.0,
        farbe = Colors.VIOLET,
        drehtSichUm = sonne,
        mitGeschwindigkeit = 0.002 )

    val erde = Gesteinsplanet(groesse = 18.0,
        bahnradius = 210.0,
        farbe = Colors.BLUE,
        drehtSichUm = sonne,
        mitGeschwindigkeit = 0.006 )

    val mars = Gesteinsplanet(groesse = 19.0,
        bahnradius = 260.0,
        farbe = Colors.RED,
        drehtSichUm = sonne,
        mitGeschwindigkeit = 0.009 )

    val jupiter = Gasplanet(groesse = 40.0,
        bahnradius = 320.0,
        farbe = Colors.CORAL,
        farbeHuelle = Colors.WHITE,
        dickeHuelle = 10.0,
        drehtSichUm = sonne,
        mitGeschwindigkeit = 0.0065  )

    val saturn = Gasplanet(groesse = 30.0,
        bahnradius = 420.0,
        farbe = Colors.DARKSLATEGRAY,
        farbeHuelle = Colors.WHITE,
        dickeHuelle = 10.0,
        drehtSichUm = sonne,
        mitGeschwindigkeit = 0.0072  )

    val uranus = Gesteinsplanet(groesse = 25.0,
        bahnradius = 520.0,
        farbe = Colors.MAROON,
        drehtSichUm = sonne,
        mitGeschwindigkeit = 0.0052 )

    val neptun = Gesteinsplanet(groesse = 15.0,
        bahnradius = 620.0,
        farbe = Colors.ORANGERED,
        drehtSichUm = sonne,
        mitGeschwindigkeit = 0.005 )

    val planeten = listOf(
        merkur, venus, erde, mars, jupiter, saturn, uranus, neptun
    )
    addChildren(planeten)

    addUpdater {
        planeten.map {
            it.animate()
        }
    }


}

