package dominio;

import static org.junit.jupiter.api.Assertions.*;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovimientoTest {

	
	Movimiento m;
	
	

	@BeforeEach
	void setUp() throws Exception {
		m = new Movimiento();
	}



	@Test
	void testGetImporte() {
		m.setImporte(234.5);
		assertEquals(234.5, m.getImporte());
	}

	@Test
	void testGetConcepto() {
		m.setConcepto("Ingreso");
		assertEquals("Ingreso", m.getConcepto());
	}

	@Test
	void testSetConcepto() {
		m.setConcepto("Retiro");
		assertEquals("Retiro", m.getConcepto());
	}



	@Test
	void testSetImporte() {
		m.setImporte(111.0);
		assertEquals(111.0, m.getImporte());
	}

}
