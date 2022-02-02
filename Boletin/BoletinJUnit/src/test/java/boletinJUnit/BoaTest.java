package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoaTest {

	Boa bicha;
	Boa bicha2;

	@BeforeEach
	void setUp() throws Exception {
		bicha = new Boa("Ser", 3, "Ratones");
		bicha2 = new Boa("Piente", 8, "Peces");
	}

	@Test
	void testIsHealthy() {
		assertEquals(true, bicha.isHealthy());
		assertEquals(false, bicha2.isHealthy());
	}

	@Test
	void testFitsInCage() {
		assertEquals(true, bicha.fitsInCage(4));
		assertEquals(false, bicha2.fitsInCage(3));
	}

}
