import com.soywiz.klock.milliseconds
import com.soywiz.korge.view.*
import com.soywiz.korge.view.tiles.TileMap
import com.soywiz.korge.view.tiles.TileSet
import com.soywiz.korge.view.tiles.*
import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korim.bitmap.Bitmap32
import com.soywiz.korim.bitmap.BmpSlice
import com.soywiz.korim.bitmap.slice
import com.soywiz.korio.resources.Resourceable


inline fun Container.bodenlegen(boden: Bitmap
   , callback: @ViewDslMarker Image.() -> Unit = {}
): TileMap = tileMap(Bitmap32(1,1), repeatX = TileMap.Repeat.REPEAT, repeatY = TileMap.Repeat.REPEAT,tileset = TileSet(mapOf(0 to boden.toBMP32().scaleLinear(0.5, 0.5).slice())))
