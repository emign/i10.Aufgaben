import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Image
import com.soywiz.korge.view.ViewDslMarker
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs


suspend inline fun Container.verschmutzen(callback: @ViewDslMarker Image.() -> Unit = {}) {
     val dreckBild = Image(resourcesVfs["staub.png"].readBitmap())
        this.addChild(dreckBild)

    }


