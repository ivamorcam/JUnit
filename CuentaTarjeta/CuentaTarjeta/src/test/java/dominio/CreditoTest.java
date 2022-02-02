package dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreditoTest {

	Cuenta cuenta;
	Credito tarjeta;
	Movimiento mov;

	@BeforeEach
	void setUp() throws Exception {
		cuenta = new Cuenta("1234.5678.90.1234567890", "Luis");
		cuenta.ingresar(1000.0);

		String caducidad = "02/04/2025";
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date duracion = formato.parse(caducidad);
		Date fechaCaducidad = new Date(duracion.getTime());

		tarjeta = new Credito("1234567890000000", "Luis", fechaCaducidad, 1000.0);
		tarjeta.setCuenta(cuenta);
	}

	@Test
	void testRetirar() {
		try {
			tarjeta.retirar(100);

		} catch (Exception e) {
			fail("No deberia fallar");
		}
		assertEquals(5, tarjeta.getSaldo());
	}

	@Test
	void testIngresar() {
		try {
			tarjeta.ingresar(100);
			assertEquals(100, tarjeta.getSaldo());
			tarjeta.ingresar(100);

		} catch (Exception e) {
			fail("No deberia fallar");
		}
		assertEquals(200, tarjeta.getSaldo());
	}

	@Test
	void testPagoEnEstablecimiento() {
		try {
			tarjeta.pagoEnEstablecimiento("Fruteria", 300);

		} catch (Exception e) {
			fail("No deberia fallar");
		}
		assertEquals(300, tarjeta.getSaldo());
	}

	@Test
	void testGetSaldo() {
		try {
			Movimiento m = new Movimiento();
			tarjeta.ingresar(100);
			m.getImporte();
		} catch (Exception e) {
		}
		assertEquals(100.0, tarjeta.getSaldo());
	}

	@Test
	void testGetCreditoDisponible() {
		try {

			tarjeta.retirar(100);

		} catch (Exception e) {
		}
		assertEquals(995.0, tarjeta.getCreditoDisponible());
	}

}
