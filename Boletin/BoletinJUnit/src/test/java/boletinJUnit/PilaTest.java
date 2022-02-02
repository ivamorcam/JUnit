package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PilaTest {

	Pila p;

	@BeforeEach
	void setUp() throws Exception {
		p = new Pila();
	}

	@Test
	void testPush() {
		p.push(2);
		assertEquals(true, p.isEmpty());
		p.push(11);
		assertEquals(false, p.isEmpty());
	}

	@Test
	void testPop() {
		assertEquals(null, p.pop());

		p.push(4);
		p.push(5);
		p.push(8);

		assertEquals(8, p.pop());
		assertEquals(5, p.pop());
		assertEquals(4, p.pop());

	}

	@Test
	void testIsEmpty() {
		assertEquals(true, p.isEmpty());

		p.push(13);
		assertEquals(false, p.isEmpty());
	}

	@Test
	void testTop() {
		assertEquals(null, p.top());

		p.push(10);
		p.push(15);
		p.push(8);

		assertEquals(8, p.top());
	}

}
