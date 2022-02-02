package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BoaTestParametrizado {

	Boa bicha;
	Boa bicha2;

	@BeforeEach
	void setUp() throws Exception {
		bicha = new Boa("Ser", 2, "Ratones");
		bicha2 = new Boa("Piente", 5, "Peces");
	}

	@ParameterizedTest(name = "Test IsHealthy")
	@CsvSource({
			"Ser1,    	 7,   Peces,   	  false",
			"Piente1,    5,   Ratones,   true",
			"Ser2,        7,   Peces,        false",
			"Piente2,    5,   Peces,      false",
			"Ser3,        7,   Ratones,   true",
			"Piente3,    5,   Peces,        false",
			"Ser4,        7,   Peces,        false",
			"Piente4,    5,   Ratones,   true"
			
	})
	
	void testIsHealthy1(String nombre,int medidas,String comida, boolean expectedResult) throws Exception {
		bicha = new Boa(nombre,medidas,comida);
		
		assertEquals(expectedResult, bicha.isHealthy());
	}
	

	@ParameterizedTest(name = "Test FitsInCage")
	@CsvSource({
			"Ser,    	2,    3,     Ratones,    true",
			"Piente,    5,   3,   Peces,   false"
			
	})
	void testFitsInCage2(String nombre,int medidas,int cageLength,String comida, boolean expectedResult) throws Exception {
		bicha = new Boa(nombre,medidas,comida);
		
		assertEquals(expectedResult, bicha.fitsInCage(cageLength));
	}

}
