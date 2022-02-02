package dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaTest {

	Cuenta cuenta;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cuenta = new Cuenta("1234.5678.90.1234567890", "Luis");
	}

	@Test
	void testIngresarDouble() {
		try {
			cuenta.ingresar(1234);

		} catch (Exception e) {
			fail("No debería fallar");
		}
		assertTrue(cuenta.getSaldo() == 1234.0);

	}

	@Test
	void testRetirarDouble() {
		try {
			cuenta.retirar(1234);
		} catch (Exception e) {
		}
		assertTrue(cuenta.getSaldo() == 0.0);
	}

	@Test
	void testIngresarStringDouble() {
		try {
			cuenta.ingresar("Ingreso", 1234);

		} catch (Exception e) {
			fail("No debería fallar");
		}
		assertTrue(cuenta.getSaldo() == 1234.0);
	}

	@Test
	void testRetirarStringDouble() {
		try {
			cuenta.retirar("Retirada", 1234);
		} catch (Exception e) {
		}
		assertTrue(cuenta.getSaldo() == 0.0);
	}

	@Test
	void testGetSaldo() {
		try {
			cuenta.ingresar(1234);
		} catch (Exception e) {
		}

		assertEquals(1234.0, cuenta.getSaldo());
	}

}
