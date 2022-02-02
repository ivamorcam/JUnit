package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FridgeTest {

	Fridge nevera;
	private Collection<String> food = new HashSet<String>();

	@BeforeEach
	void setUp() throws Exception {
		nevera = new Fridge();
		food.add("Papas");
		food.add("Redbull");
		food.add("Tortilla");
		food.add("Macarrones");
	}

	@Test
	void testPut() {
		nevera.put("Papas");
		assertEquals(true, nevera.contains("Papas"));
	}

	@Test
	void testContains() {
		nevera.put("Papas");
		assertEquals(true, nevera.contains("Papas"));
		assertEquals(false, nevera.contains("Tortilla"));
	}

	@Test
	void testTake() {
		try {
			nevera.put("Redbull");
			assertEquals(true, nevera.contains("Redbull"));
			nevera.take("Redbull");
			assertEquals(false, nevera.contains("Redbull"));
		} catch (Exception e) {
			fail("No falla");
		}
	}
	
	@Test
	void testTakeException() {
		try {
			nevera.take("Macarrones");
			fail("No hay en el frigorífico");
		} catch (Exception e) {
			assertEquals(true, e.getMessage().contains("Macarrones"));
		}
	}

}
