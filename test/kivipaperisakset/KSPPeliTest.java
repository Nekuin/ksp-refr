package kivipaperisakset;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;



public class KSPPeliTest {
	
	private KSPPeli p;
	
	@Test
	public void testWinLogic() {
		p = new KSPPeli(null, null);
		int c1 = p.chooseWinner("kivi", "sakset");
		assertEquals(1, c1, "Sakset voitti kiven");
		
		int c2 = p.chooseWinner("kivi", "paperi");
		assertEquals(2, c2, "Kivi voitti paperin");
		
		int c3 = p.chooseWinner("paperi", "sakset");
		assertEquals(2, c3, "Paperi voitti sakset");
		
		int c4 = p.chooseWinner("paperi", "kivi");
		assertEquals(1, c4, "Kivi voitti paperin");
		
		int c5 = p.chooseWinner("sakset", "kivi");
		assertEquals(2, c5, "Sakset voitti kiven");
		
		int c6 = p.chooseWinner("sakset", "paperi");
		assertEquals(1, c6, "Paperi voitti sakset");
	}
	
	@Test
	public void testDraw() {
		p = new KSPPeli(null, null);
		int c1 = p.chooseWinner("kivi", "kivi");
		assertEquals(0, c1, "ei tasapeliä");
		
		int c2 = p.chooseWinner("sakset", "sakset");
		assertEquals(0, c2, "ei tasapeliä");
		
		int c3 = p.chooseWinner("paperi", "paperi");
		assertEquals(0, c3, "ei tasapeliä");
	}
	
}