import com.soywiz.klock.milliseconds
import com.soywiz.korge.Korge
import com.soywiz.korge.view.Image
import com.soywiz.korge.view.addUpdater
import com.soywiz.korge.view.image
import com.soywiz.korge.view.scale
import com.soywiz.korge.view.tiles.TileMap
import com.soywiz.korge.view.tiles.TileSet
import com.soywiz.korge.view.tiles.tileMap
import com.soywiz.korim.bitmap.Bitmap32
import com.soywiz.korim.bitmap.slice
import com.soywiz.korim.color.Colors
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs

suspend fun main() = Korge(width = 800, height = 600, bgcolor = Colors["#2b2b2b"], title = "Staubsauger") {
    val texturen = arrayOf(
        resourcesVfs["boden/holz1.jpg"].readBitmap(),
        resourcesVfs["boden/holz2.jpg"].readBitmap(),
        resourcesVfs["boden/holz3.jpg"].readBitmap(),
        resourcesVfs["boden/holz4.jpg"].readBitmap()
    )

    val boden = texturen[1]

    bodenlegen(boden)

    val staubsaugerBild = resourcesVfs["staubsauger.png"].readBitmap()
    val staubsauger = Staubsauger(staubsaugerBild)
    addChild(staubsauger)


    val breiteStage = this.width
    val hoeheStage = this.height

    val wandLinks = Wand(-100.0, hoeheStage).apply {
        x = 0.0
        y = 0.0
    }
    val wandRechts = Wand(100.0, hoeheStage).apply {
        x = breiteStage
        y = 0.0
    }
    val wandOben = Wand(breiteStage, -100.0).apply {
        x = 0.0
        y = 0.0
    }
    val wandUnten = Wand(breiteStage, 100.0).apply {
        x = 0.0
        y = hoeheStage
    }

    //addChild(wandLinks)
    //addChild(wandRechts)
    addChild(wandOben)
    //addChild(wandUnten)

    addUpdater {
        staubsauger.entscheiden()
    }

}

