package eu.spotlightforbugs;

public class Kartenspiel {
    private Karte[] Kartendeck;
    /**
     * Erzeugt ein neues Kartenspiel mit 32 Karten.
     */
    public Kartenspiel() {
        // erzeugen eines Karten-Arrays mit den 32 Skat-Karten
        Kartendeck = new Karte[32];
        String[] kartenwerte = {
                "Sieben", "Acht", "Neun", "Zehn", "Bube", "Dame", "König", "Ass"};

        String[] farben = {"Kreuz", "Pik", "Herz", "Karo"};

        for (int i = 0; i < farben.length; i++) {
            for (int j = 0; j < kartenwerte.length; j++) {
                Karte karte = new Karte(farben[i], kartenwerte[j]);
                Kartendeck[i * kartenwerte.length + j] = karte;
            }
        }
    }

    /**
     * Zwei zufällige Karten tauschen ihren Platz im Deck.
     * Dies wird 32-mal durchgeführt.
     */
    public void mischen() {
        for (int i = 0; i < 32; i++) {
            int zufallszahl1 = (int) (Math.random() * 32);
            int zufallszahl2 = (int) (Math.random() * 32);
            Karte temp = Kartendeck[zufallszahl1];
            Kartendeck[zufallszahl1] = Kartendeck[zufallszahl2];
            Kartendeck[zufallszahl2] = temp;
        }
    }
}
