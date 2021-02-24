# Der Staubsaugerroboter

## Vorbereitungen

### Boden legen

Im Ordner `resources/boden/` finden sich einige vorbereitete Bodentexturen als .jpg Bilddateien. Eine Textur können Sie sich wie eine
Kachel vorstellen. Eine einzelne Texturkachel ist zu klein, um in unserem Fall den ganzen Boden auszulegen.
Also müssen wir sie in x- und y-Richtung wiederholt auslegen; ganz wie Fliesenkacheln.
Hierzu gibt es eine vorgefertigte Funktion, die `bodenlegen(Bitmap)` heißt. Diese legt eine einzelne Kachel so oft auf den Boden, 
dass der Boden in XY Richtung komplett gekachelt ist. Die Bodentextur bitte auch automatisch der Stage zugefügt

1. Laden Sie ein Bitmap aus den vorgefertigten Bildern und übergeben Sie das PDF an die `bodenlegen(Bitmap)` Funktion.
LPT: Mein schnellen Wechsel zwischen den Texturen zu ermöglichen können Sie diese mit der `arrayOf` Funktion in ein `Array<Bitmap>` laden.
   Beispielcode:
   ```
    val boden = texturen[1] // texturen ist ein Array<Bitmap>
    bodenlegen(boden)
   ```

### Staubsauger hinzufügen

Im Resources Ordner findet sich auch ein Staubsauger Bild. 
2. Erstellen Sie eine Klasse `Staubsauger.kt`  und lassen Sie diese von `BaselImage` erben. Der Konstruktor der Klasse
`BaseImage` möchte ein `Bitmap` als Parameter. Deklarieren Sie ihren Konstruktor in der Klasse `Staubsauger` so,
   dass er dieses `Bitmap` entgegen nimmt und an den Konstruktor der Superklasse weiter gibt:
   
```
class Staubsauger(bitmap: Bitmap) : BaseImage(bitmap) {
}
```
Erstellen Sie anschließend ein Staubsauger-Objekt und fügen Sie ist der `Stage` zu.
Der Staubsauger wird viel zu groß sein:
![](Bilder/StaubsaugerZuGross.png)
Verkleinern Sie es indem, sie seine Property `scale` auf eine sinnvolle Größe ändern.
Dies soll unbedingt im `init`-Block in der Klasse `Staubsauger` geschehen. Das Attribut `scale` setzt im Übrigen
die `scaleX` und die `scaleY` auf den angegebenen Wert.
Diese Abbildung entsteht etwa bei einem Attributwert von `scale = 0.06`
![Fenster](Bilder/scale.png)
Kontrollieren Sie das Ergebnis.

### Anker senken
Derzeit verwenden die meisten Positionierungsfunktionen als Referenzpunkt den linken oberen Pixel eines `Views` (z.B. einem
`Image`). Wenn Sie also die x- und y-Positionen setzen, wird das in Relation zu diesem Pixel geschehen. Man nennt das einen Anker.
Später wollen wir den Staubsauger rotieren. Diese Rotation setzt auch am Anker an. Wir wollen aber den Staubsauger nicht um den
Standardanker rotieren, sondern um das Zentrum des Bildes.
![Fenster](Bilder/anker.png)
Hierzu müssen wir den Anker auf die halbe Höhe und die halbe Breite setzen. Dies machen wir im `init`-Block mit
```
anchor(0.5, 0.5)
```
Dieser Aufruf muss unbedingt nach der Veränderung der `scale` geschehen.
Wenn Sie das Ergebnis kontrollieren sehen sie, dass der Roboter nun nur zu einem Viertel sichtbar ist.
Die x- und y-Positionierung greift jetzt an dem neuen Anker. Da wir keine x- und y-Koordinaten bisher gesetzt haben, sind diese
einfach `x=0` und `y=0`. Setzen Sie ihren Roboter nun ungefährt in die Mitte des Raumes.

### Staubsauger KI
Unser Staubsauger soll natürlich autonom arbeiten und eine Art künstliche Intelligenz besitzen, dass er etwa
seine Richtung ändert, wenn er an Hindernisse stößt. Er muss also auf verschiedene Ereignisse reagieren können.
Fügen Sie eine Funktion `entscheiden()` zur Klasse Staubsauger hinzu. Diese Funktion soll jetzt in den Gameloop
eingebaut werden. Füge also einen Updater zur Stage (`addUpdater{}`) hinzu. In diesem Updater soll die Funktion `entscheiden()` des 
Staubsaugers aufgerufen werden.

#### Fahren
Die meiste Zeit soll der Staubsauger ja einfach fahren. Wie wir so etwas erreichen, wurde bereits in den Lektionen zum
GameLoop und zum PlanetenSystem erklärt. Hier werden wir allerdings noch etwas eleganter vorgehen. 
Wir geben einfach nur einen Winkel an, in welche Richtung sich der Roboter fortbewegen soll und eine Geschwindigkeit.
Fügen Sie die Property `velocity` vom Typ `Int ein. 
Als Startwert erzeugen wir einen zufälligen Werte für die Geschwindigkeit, indem wir einen Zufallsgenertor über das Interval von 1 bis 3 laufen lassen:
```
... = (1..3).random()
```

##### Drehrichtung
Die Bewegung soll automatisch aus der Geschwindigkeit (genauer: aus der x- und y-Komponenente der Geschwindigkeit, s.o.) und dem Drehwinkel 
generiert werden. Fügen Sie eine Property `drehwinkel` ein. Unser Roboter soll in eine zufällige Richtung losfahren.
Dies kann man wieder mit einem Zufallsgenerator erreichen:
```
var drehwinkel = (0..359).random().degrees
```
In der Funktion `fahren()` können wir den Roboter nun einfach mit der Funktion `rotation()` um den Drehwinkel drehen.
Die Richtung der Drehung können Sie auf dem folgenden Bild ablesen

![Fenster](Bilder/drehwinkel.png)

Testen Sie anschließend das Ergebnis

##### Bewegung
Jetzt können wir ausrechnen, um wieviele Pixel der Roboter sich in x- und y-Richtung bewegen soll:
Delta-X (also der Wert um den die x-Koordinate verändert werden soll, kurz `dx` und `dy`) ist das Produkt aus der Geschwindigkeit
und dem Cosinus des Drehwinkels (`dy` analog mit Sinus). Genau genommen muss man den Drehwinkel noch um `90.degrees` verringern, dass die Ausrichtung 
Berechnung der Koordinaten passt. Unser Roboter schaut bei 0° nämlich nach oben und nicht nach rechts.
Fügen Sie hinter der Rotationsanweisung in der `fahren()` Funktion die Berechnung für `dx` und `dy` aus.
Hinweis: Um vom `drehwinkel` (Typ `Angle`) `90.degrees` subtrahieren zu können benötigen sie einen Minus-Operator, der dies beherrscht.
Darüber hinaus sind `cos`, `sin` und `.degrees` Sonderfunktionalitäten. Diese können Sie nutzen, wenn Sie folgende Imports am Anfang
der Datei hinzufügen:
```
import com.soywiz.korma.geom.cos
import com.soywiz.korma.geom.degrees
import com.soywiz.korma.geom.minus
import com.soywiz.korma.geom.sin
```
Alternativ können Sie die Imports auch [automatisch hinzufügen lassen](https://www.jetbrains.com/help/idea/creating-and-optimizing-imports.html)

Testen Sie nun Ihr Projekt. Der Staubsauger sollte nun in die Richtung "schauen", in die er auch fährt.
Leider fährt er noch aus dem Bildschirm heraus. Dies wollen wir ändern, indem der Staubsauger nun
Kollisionen erkennt.

## Kollisionserkennung
Unser Staubsauger soll nun erkennen können, wenn er gegen ein Hindernis fährt und dann umdrehen und eine andere Richtung einschlagen.
Hierzu müssen wir erstmal Hindernisse platzieren. Da wir später auch den Kontakt mit aufzusaugendem Schmutz als Kollision handhaben wollen,
implementieren wir die Hindernisse wie folgt:
