package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

	Account a;
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();

	@BeforeEach
	void setUp() throws Exception {
		a = new Account("Manolo", 1234567, 3f);
	}

	@Test
	void testDeposit() {
		assertEquals(false, a.deposit(-2f));
		assertEquals(true, a.deposit(5f));

	}

	
	@Test
	void testWithdraw() {
		assertEquals(false, a.withdraw(-4f, -4f));
		assertEquals(true, a.withdraw(-3f, 0f));


	}

	@Test
	void testAddInterest() {
		a.addInterest();
		assertEquals(3f + (3f * 0.045f), a.getBalance());
	}

	@Test
	void testGetBalance() {
		assertEquals(3f, a.getBalance());
	}

	@Test
	void testGetAccountNumber() {
		assertEquals(1234567, a.getAccountNumber());
	}

	@Test
	void testToString() {
		assertEquals(1234567 + "\t" + "Manolo" + "\t" + fmt.format(3f), a.toString());
	}

}
