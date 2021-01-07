/**
 * @Author Carelle Djuffo Nzangue
 * @version 1.0
 * */
package pis.hue1;
/**
 * Die Schnitte Stelle Codec wird von den Klassen Caesar und Wuerfel implementiert.
 * Codec besitzt vier Methoden
 * */

public interface Codec {
    /**
     * @param klartext als String Objekt
     * @return String Objekt als Geheimtext
     * */
    public String kodiere(String klartext);
    /**
     * @param geheimtext als String Objekt
     * @return String Objekt als Klartext
     * */
    public String dekodiere(String geheimtext);
    /**
     * @return String Objekt
     * */
    public String gibLosung();
    /**
     * @param schluessel als String Objekt
     * @throws InterruptedException bei ungeeignetem Schlüssel
     * */
    public void setzeLosung(String schluessel)throws
            IllegalArgumentException; // bei ungeeignetem Schlüssel!

}
