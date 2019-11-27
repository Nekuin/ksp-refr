package kivipaperisakset;

/**
 *
 * @author Ira Dook
 */
public class Peli {

    public static void main(String args[]) {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        KSPPeli peli = new KSPPeli(p1, p2);
        peli.startGame(5);
    }
}
