package dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DebitoTest {

	Debito debito;
	Cuenta cuenta;

	@BeforeEach
	void setUp() throws Exception {
		cuenta = new Cuenta("1234.5678.90.1234567890", "Luis");

		String caducidad = "02/04/2024";
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date duracion = formato.parse(caducidad);
		Date fechaCaducidad = new Date(duracion.getTime());
		debito = new Debito("123456789000000", "Luis", fechaCaducidad);

		debito.setCuenta(cuenta);
	}

	@Test
	void testRetirar() {
		
		
		try {
			debito.ingresar(3000);
			debito.retirar(1000.0);
			assertEquals(2000, debito.getSaldo());
		} catch (Exception e) {
			fail("No falla");
		}
	}

	@Test
	void testIngresar() {
		try {
			debito.ingresar(2000.0);
			assertEquals(2000, debito.getSaldo());
		} catch (Exception e) {
			fail("No falla");
		}
	}

	@Test
	void testPagoEnEstablecimiento() {
		try {
			debito.ingresar(2000.0);
			debito.pagoEnEstablecimiento("tabaco", 100);
			assertEquals(1900, debito.getSaldo());
		} catch (Exception e) {
			fail("No falla");
		}
	}

	@Test
	void testGetSaldo() {
		try {
			debito.ingresar(2000.0);
			assertEquals(2000.0, debito.getSaldo());
		} catch (Exception e) {
		}

		
	}

}
