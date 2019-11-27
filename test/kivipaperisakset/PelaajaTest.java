package kivipaperisakset;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PelaajaTest {
	
	private static Pelaaja player;
	
	@BeforeAll
	public static void init() {
		player = new Pelaaja();
	}
	
	/**
	 * test random kivi, paperi & sakset selection
	 */
	@Test
	public void testPelaajaValinta() {
		List<String> results = new ArrayList<>();
		// I guess it's theoretically possible not to get 1 (or even 2) of the possibilities
		// in 1k rolls, but it's very unlikely
		for(int i = 0; i < 1000; i++) {
			results.add(player.pelaajanValinta());
		}
		assertEquals(true, results.contains("kivi"), "kiveä ei löytynyt");
		assertEquals(true, results.contains("paperi"), "paperia ei löytynyt");
		assertEquals(true, results.contains("sakset"), "saksia ei löytynyt");
	}
	
	/**
	 * get, set and increase voitot tests
	 */
	@Test
	public void testVoitot() {
		assertEquals(0, player.getVoitot());
		player.increaseVoitot();
		assertEquals(1, player.getVoitot());
		player.setVoitot(5);
		assertEquals(5, player.getVoitot());
	}
}