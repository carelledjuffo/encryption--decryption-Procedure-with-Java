package pis.hue1;
/**
 * Implementiert die Schnittestelle Codec
 * */
public class Caesar implements Codec {
    /**
     * Klasseninvariant schluessel fuer das Schlusselwort
     * */
    private   String schluessel="THM";
    /**
     * Das Schlusselwort muss nicht null sein
     * */
    public  Caesar(){

    }

    public String kodiere(String klartext){
        StringBuilder geheim_text=new StringBuilder();
        char letter;
        for(int i=0;i<klartext.length();i++){
            letter= klartext.charAt(i);

        inner:  for(int count=0; count< schluessel.length();count++){
                if(Character.isLetter(letter)) {
                    if (letter == 'Z') {
                        letter = 'A';
                        continue inner;
                    }
                    if (letter == 'z') {
                        letter = 'a';
                        continue inner;
                    }
                     letter++;
                }
            }
            geheim_text.append(letter);
        }

        return geheim_text.toString();
    }
    public String dekodiere(String geheimtext){
        StringBuilder klar_text=new StringBuilder();

        char letter;
        for(int i=0;i<geheimtext.length();i++){
            letter= geheimtext.charAt(i);

            inner:  for(int count=0; count< schluessel.length();count++){
                if(Character.isLetter(letter)) {
                    if (letter == 'A') {
                        letter = 'Z';
                        continue inner;
                    }
                    if (letter == 'a') {
                        letter = 'z';
                        continue inner;
                    }
                    letter--;

                }

            }
            klar_text.append(letter);
        }

        return klar_text.toString();

    }

    @Override
    public String gibLosung() {
        return this.schluessel;
    }
    public void setzeLosung(String schluessel) throws IllegalArgumentException{
        try {
            this.schluessel = schluessel;
        }catch (IllegalArgumentException e){
            System.out.println("Der Parameter muss ein String Objekt sein");
        }
    }


}
