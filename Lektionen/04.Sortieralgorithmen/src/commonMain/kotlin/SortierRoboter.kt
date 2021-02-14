import com.soywiz.klock.milliseconds
import com.soywiz.korau.sound.AudioTone
import com.soywiz.korau.sound.toSound
import com.soywiz.korge.input.onClick
import com.soywiz.korge.ui.*
import com.soywiz.korge.view.SolidRect
import com.soywiz.korge.view.Stage
import com.soywiz.korge.view.Text
import com.soywiz.korge.view.position
import com.soywiz.korim.bitmap.sliceWithSize
import com.soywiz.korim.color.ColorTransform
import com.soywiz.korim.color.Colors
import com.soywiz.korim.color.RGBA
import com.soywiz.korim.color.transform
import com.soywiz.korim.font.readBitmapFont
import com.soywiz.korim.format.readNativeImage
import com.soywiz.korim.text.TextAlignment
import com.soywiz.korio.async.delay
import com.soywiz.korio.async.launch
import com.soywiz.korio.file.std.resourcesVfs
import com.soywiz.korio.util.AsyncOnce
import com.soywiz.korma.geom.Angle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

object SortierRoboter {
    var algorithmus : Sortieralgorithmus = KotlinSortierer
    lateinit var array: Array<SolidRect>

    // Konfiguration für die Anzeige des Arrays
    var wartezeit = 10.milliseconds
    private val breite = 5
    private val startX = 50.0
    private val startY = 200.0
    private val abstand = 0.0
    private val randomSubColor: Int
        get() = (0..255).random()

    private val runs = Text( "0", 50.0)
    private var clicked = false

    /**
     * Sollte vom Sortieralgorithmus zu relevanten Zeitpunkten (etwa nach dem Tausch von Array-Positionen)
     * aufgerufen werden. Dann wird die Anzeige aktualisiert.
     */
    suspend fun positionenAktualisieren(){
        array.forEachIndexed { index, rechteck ->
            rechteck.x = startX + (index * (breite + abstand))
        }
        delay(wartezeit)
    }

    /**
     * Wird durch den Button-Click gestartet und ruft die sortieren() Funktion des Sortieralgorithmus auf
     */
    suspend fun sortieren(){
        if (!clicked){
            clicked = true
            CoroutineScope(Dispatchers.Default).launch {
                algorithmus.sortieren(array)
                positionenAktualisieren()
            }
        }

    }

    /**
     * Spielt einen Ton mit einer Tonhöhe proportional zur Höhe des übergebenen SolidRects ab
     */
    suspend fun playSound(rect : SolidRect) {
        AudioTone.generate(wartezeit, rect.height*80).toSound().playAndWait()
    }

    suspend fun initialisieren(stage : Stage){
        stage.addChildren(array.toList())
        stage.addChild(runs)
        stage.defaultUISkin = OtherUISkin()
        stage.defaultUIFont = resourcesVfs["uifont.fnt"].readBitmapFont()
        stage.addChild(
                Text(algorithmus.name).apply {
                    position(10.0, stage.height-15.0)
                    onClick {
                        sortieren()

                    }
                }
        )
    }

    fun countVergleich() {
        runs.text = (runs.text.toInt() + 1).toString()
    }

    fun arrayErzeugen(laenge: Int, untereZufallsGrenze: Int = 10, obereZufallsGrenze: Int = 100) {
        array = Array<SolidRect>(laenge) { i ->
            SolidRect(
                    width = breite,
                    height = (untereZufallsGrenze..obereZufallsGrenze).random(),
                    color = RGBA(randomSubColor, randomSubColor, randomSubColor))
                    .apply {
                x = startX + (i * (breite + abstand))
                y = startY
                rotation = Angle(3.14159) }
        }
    }
}

private val otherColorTransform = ColorTransform(0.7, 0.9, 1.0)
private val OTHER_UI_SKIN_IMG by lazy {
    DEFAULT_UI_SKIN_IMG.withColorTransform(otherColorTransform)
}

private val OtherUISkinOnce = AsyncOnce<UISkin>()

suspend fun OtherUISkin(): UISkin = OtherUISkinOnce {
    //val ui = resourcesVfs["korge-ui.png"].readNativeImage().toBMP32().withColorTransform(otherColorTransform)
    val ui = resourcesVfs["korge-ui.png"].readNativeImage()

    DefaultUISkin.copy(
            normal = ui.sliceWithSize(0, 0, 64, 64),
            over = ui.sliceWithSize(64, 0, 64, 64),
            down = ui.sliceWithSize(127, 0, 64, 64),
            backColor = DefaultUISkin.backColor.transform(otherColorTransform)
            //,
            //font = Html.FontFace.Bitmap(getDebugBmpFontOnce())
            //font = Html.FontFace.Bitmap(resourcesVfs["uifont.fnt"].readBitmapFontWithMipmaps())
    )
}