package eu.spotlightforbugs;

public class Karte {
    private String farbe;
    private String bild;

    public Karte(String farbe, String bild) {
        this.farbe = farbe;
        this.bild = bild;
    }

    public String gibFarbe() {
        return farbe;
    }

    public String gibBild() {
        return bild;
    }
}
