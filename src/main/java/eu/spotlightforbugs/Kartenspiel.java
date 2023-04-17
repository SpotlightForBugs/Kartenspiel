package eu.spotlightforbugs;

/**
 * Ein Kartenspiel mit 32 Karten.
 * Die Karten werden in einem Array gespeichert. (Kartendeck)
 */
public class Kartenspiel {
    private Karte[] Kartendeck;
    /**
     * Erzeugt ein neues Kartenspiel mit 32 Karten.
     * Die Karten werden in einem Array gespeichert. (Kartendeck)
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
    /**
     * Prüft, ob sich eine Karte mit der gesuchten Farbe und dem gesuchten Bild im Kartendeck befindet.
     * @param pFarbe Die gesuchte Farbe.
     * @param pBild Das gesuchte Bild.
     * @return true, wenn die Karte im Kartendeck vorhanden ist, sonst false.
     */
    boolean vorhanden(String pFarbe, String pBild)
    {
        for (Karte karte : Kartendeck) {
            if (karte.gibFarbe().equals(pFarbe) && karte.gibBild().equals(pBild)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Entnimmt alle Karten der Farbe pFarbe aus dem Kartendeck.
     * @param pFarbe Die Farbe, der die Karten entnommen werden sollen.
     */
    public void aussortieren(String pFarbe){
        for (int i = 0; i < Kartendeck.length; i++) {
            if (Kartendeck[i].gibFarbe().equals(pFarbe)) {
                Kartendeck[i] = null;
            }
        }
    }

    /**
     * Gibt die Karten zurück.
     * @param output bestimmt, ob ein output in der Konsole erfolgen soll.
     * @return
     */

    /**
     * Gibt die Karten zurück.
     * @param output bestimmt, ob ein output in der Konsole erfolgen soll.
     * @return liste als String.
     */
    public String kartenAusgeben(boolean output){
        StringBuilder liste = new StringBuilder();
        for (Karte karte : Kartendeck) {
            if (output) {
                System.out.println(karte.gibFarbe() + " " + karte.gibBild());
            }
            liste.append(karte.gibFarbe()).append(" ").append(karte.gibBild()).append("\n");

        }
        return liste.toString();

    }

    /**
     * Führt einen QuickSort auf dem Kartendeck durch.
     * @param links Der linke Index des Kartendecks.
     * @param rechts Der rechte Index des Kartendecks.
     * @param output bestimmt, ob ein output in der Konsole erfolgen soll.
     * @return temp Das Kartendeck.
     * @see <a href="https://www.baeldung.com/java-quicksort">Quicksort</a>
     */
    public Karte[] quickSort(int links, int rechts, boolean output) {
        Karte[] temp = Kartendeck;
        int i = links;
        int j = rechts;
        int pivot = (links + rechts) / 2;
        while (i <= j) {
            while (temp[i].gibFarbe().compareTo(temp[pivot].gibFarbe()) < 0) {
                i++;
            }
            while (temp[j].gibFarbe().compareTo(temp[pivot].gibFarbe()) > 0) {
                j--;
            }
            if (i <= j) {
                Karte tempKarte = temp[i];
                temp[i] = temp[j];
                temp[j] = tempKarte;
                i++;
                j--;
            }
        }
        if (links < j) {
            quickSort(links, j, output);
        }
        if (i < rechts) {
            quickSort(i, rechts, output);
        }
        if (output) {
            kartenAusgeben(true);
        }
        return temp;
    }




}
