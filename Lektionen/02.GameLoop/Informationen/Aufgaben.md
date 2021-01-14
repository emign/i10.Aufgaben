# 2. Gameloop
## Aufgabe 1
Erstellen Sie einen `Circle` und zentrieren Sie ihn genau in der Mitte der `Stage`

## Aufgabe 2
Animieren Sie den Kreis, indem Sie seine Properties (`x`, `y`, `radius`, ...) in der `addUpdater` Funktion verändern.

## Aufgabe 3
Implementieren Sie, dass der Kreis seine Farbe in eine Zufallsfarbe ändert. Speichern Sie hierfür die Referenzen auf einige Farben (im `Colors` Singleton) in einem Array
und wählen Sie jeden Aufruf von `addUpdater` eine zufällige mit `.random()` aus.

## Aufgabe 4
Implementieren Sie, dass ihr Kreis am Rand der Stage/des Fensters stehen bleibt und sich nicht hinaus bewegt

## Aufgabe 5
Implementieren Sie, dass ihr Kreis am Rand der Stage/des Fensters abprallt und sich zurück bewegt.
Hinweis: Erzeugen Sie hierfür eine Subklasse von `Circle` und fügen Sie die Properties `deltaX` und `deltaY` hinzu.
Diese Properties sollen jedes Frame auf `x` und `y` aufaddiert werden. Wenn der Kreis dann an den Rand stößt, müssen
`deltaX` und `deltaY` entsprechend angepasst werden.
