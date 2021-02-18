# Der Staubsaugerroboter

Wir wollen einen Sortierroboter bauen, welcher unterschiedliche Sortieralgorithmen verwenden kann.

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
![Fenster](Bilder/StaubsaugerZuGross.png)
Verkleinern Sie es indem, sie seine Property `scale` auf eine sinnvolle Größe ändern.
Diese Abbildung entsteht etwa bei einem Attributwert von `scale = 0.06`
![Fenster](Bilder/scale.png)