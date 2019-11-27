package kivipaperisakset;

public class Pelaaja {

	//voittojen lukum‰‰r‰
    private int voitot;
    
    public Pelaaja() {
    	this.voitot = 0;
    }

    /**
     * Valitse randomilla kivi, paperi tai sakset
     */
    public String pelaajanValinta() {
        String valinta = "";
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0:
                valinta = ("kivi");
                break;
            case 1:
                valinta = ("paperi");
                break;
            case 2:
                valinta = ("sakset");
                break;
        }
        return valinta;
    }

    public void setVoitot(int n) {
        this.voitot = n;
    }
    
    public void increaseVoitot() {
    	this.voitot++;
    }

    public int getVoitot() {
        return voitot;
    }
}
