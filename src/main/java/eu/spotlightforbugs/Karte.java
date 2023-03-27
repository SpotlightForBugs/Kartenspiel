package eu.spotlightforbugs;

public class Karte {
    private String farbe;
    private String bild;

    /**
     * Erzeugt eine neue Karte mit der angegebenen Farbe und dem angegebenen Bild.
     * @param farbe Die Farbe der Karte.
     * @param bild Das Bild der Karte.
     */
    public Karte(String farbe, String bild) {
        this.farbe = farbe;
        this.bild = bild;
    }

    /**
     * Gibt die Farbe der Karte zurück.
     * @return Die Farbe der Karte.
     */
    public String gibFarbe() {
        return farbe;
    }

    /**
     * Gibt das Bild der Karte zurück.
     * @return Das Bild der Karte.
     * 
     */
    public String gibBild() {
        return bild;
    }
}
