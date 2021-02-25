import com.soywiz.klock.milliseconds
import com.soywiz.korge.Korge
import com.soywiz.korge.view.addUpdater
import com.soywiz.korim.color.Colors

suspend fun main() = Korge(width = 600, height = 250, bgcolor = Colors["#2b2b2b"], title = "Sortieralgorithmen") {

    // Erzeugt ein Array mit [[laenge]] Zufallszahlen
    SortierRoboter.arrayErzeugen(3)

    // Weist dem Sortierroboter einen Sortieralgorithmus zu
    SortierRoboter.algorithmus = BogoSort

    // Wartezeit zwischen den einzelnen Sortierschritten
    // Diesen Wert kann man anpassen, falls das Programm zu schnell oder zu langsam sortiert.
    SortierRoboter.wartezeit = 1.milliseconds

    // Initialisiert den Sortierroboter
    SortierRoboter.initialisieren(this)
}

