package kivipaperisakset;

public class KSPPeli {
	
	private Pelaaja p1;
	private Pelaaja p2;
	
	public KSPPeli(Pelaaja p1, Pelaaja p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/**
	 * Play x rounds of KSP
	 * @param rounds number of rounds to play
	 */
	public void startGame(int rounds) {
		String p1valinta = "";
		String p2valinta = "";
		//reset previous wins
		p1.setVoitot(0);
		p2.setVoitot(0);
		int draws = 0;
		boolean win = false;
		for(int i = 0; i < rounds; i++) {
			System.out.println("=====");
			System.out.println("Erä " + (i+1));
			p1valinta = p1.pelaajanValinta();
			p2valinta = p2.pelaajanValinta();
			System.out.println("Pelaaja 1: " + p1valinta);
			System.out.println("Pelaaja 2: " + p2valinta);
			int winner = chooseWinner(p1valinta, p2valinta);
			if(winner == 0) {
				System.out.println("Tasapeli");
				draws++;
			} else if(winner == 1) {
				System.out.println("Pelaaja 1 voitti");
				p1.increaseVoitot();
			} else if(winner == 2) {
				System.out.println("Pelaaja 2 voitti");
				p2.increaseVoitot();
			}
			printStatistics(draws);
			if(checkIf3Wins()) {
				i = rounds;
				win = true;
			}
		}
		System.out.println("=====");
		if(!win) {
			System.out.println(rounds + " kierrosta pelattu.");
			if(p1.getVoitot() > p2.getVoitot()) {
				System.out.println("Voittaja: Pelaaja 1, " + p1.getVoitot() + " pisteellä.");
			} else {
				System.out.println("Voittaja: Pelaaja 2, " + p2.getVoitot() + " pisteellä.");
			}
			System.out.println("Tasapelejä: " + draws);
		}
	}
	
	private void printStatistics(int draws) {
		System.out.println("Tilanne: ");
		System.out.println("Tasapelejä yhteensä: " + draws);
		System.out.println("Pelaaja 1 voitot: " + p1.getVoitot());
		System.out.println("Pelaaja 2 voitot: " + p2.getVoitot());
	}
	
	private boolean checkIf3Wins() {
		boolean bool = false;
		if(p1.getVoitot() >= 3) {
			System.out.println("Pelaaja 1 voitti.");
			bool =  true;
		} else if(p2.getVoitot() >= 3) {
			System.out.println("Pelaaja 2 voitti.");
			bool = true;
		}
		return bool;
	}
	
	/**
	 * 0 = draw
	 * 1 = player 1 wins
	 * 2 = player 2 wins
	 * @param val1 Player 1 choice
	 * @param val2 Player 2 choice
	 * @return int representing the winner
	 * package visibility for testability
	 */
	int chooseWinner(String val1, String val2) {
		int winner = 0;
		if(val1.equals("kivi") && val2.equals("paperi")) {
			winner = 2;
		} else if(val1.equals("kivi") && val2.equals("sakset")) {
			winner = 1;
		} else if(val1.equals("sakset") && val2.equals("paperi")) {
			winner = 1;
		} else if(val1.equals("sakset") && val2.equals("kivi")) {
			winner = 2;
		} else if(val1.equals("paperi") && val2.equals("kivi")) {
			winner = 1;
		} else if(val1.equals("paperi") && val2.equals("sakset")) {
			winner = 2;
		}
		return winner;
	}
}