package oblig2Oppgave2;
import static javax.swing.JOptionPane.*;
class Tallspill
{
    public int nyttTall() { //Nytt tall klassen lager et nytt tall
        int slumpeTall = (int) (Math.random() * 201) ;
        return slumpeTall;
    }
    public void visMelding(String melding){
        showMessageDialog(null, melding);
    }
    private void forLite(int tall){
        String melding = tall + " er for lite, prøv igjen!";
        visMelding(melding);
    }
    private void forStort(int tall) {
        String melding = tall + " er for stort, prøv igjen!";
        visMelding(melding);
    }
    public void avsluttRunde(int antall, int gjetning) {
        String melding = gjetning + " er riktig!\n";
        melding += "Du gjettet riktig på "+antall+" forsøk";
        visMelding(melding);
    }
    public void kjørSpill() {
        int random = nyttTall();
        int tall1 = -1;
        int antall = 0;

        while (tall1 != random){
            try{
                tall1 = Integer.parseInt(showInputDialog("Jeg tenker på et tall mellom 0 og 200.\n" +
                        "Prøv å gjette på tallet:"));
            } catch (Exception e){
                showMessageDialog(null, "Du har ikke skrevet et tall. Vennligst prøv igjen!");
                tall1 = 0;
            }
            if (tall1 > random){
                forStort(tall1);
                antall++;
            }
            else if (tall1 < random){
                forLite(tall1);
                antall++;
            }
            else if (tall1 == random) {
                antall++;
                avsluttRunde(antall,random);
            }
        }
    }
}
public class main{
    public static void main(String [] args){
        Tallspill spill = new Tallspill();
        spill.kjørSpill();
    }
}