package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperadorAritmeticoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	int a;
	int b;
	int c;
	Exception e;

	@BeforeEach
	public void init() {
		a = 10;
		b = 2;
		c = 0;

	}

	@Test
	void testSuma() {

		assertEquals(12, OperadorAritmetico.suma(a, b));

	}

	@Test
	public void division() {

		try {

			assertEquals(5, OperadorAritmetico.division(a, b));
		} catch (Exception e) {
			fail("No debería fallar");
		}

	}

	public void divisionException() {
		try {

			assertEquals(0, OperadorAritmetico.division(a, c));
			fail("No existe la división por 0");
		} catch (Exception e) {

			assertEquals(true, e.getMessage());
		}

	}

}
