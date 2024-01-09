package lab4_package;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoffemakersTest {

	//@Test
	@org.junit.jupiter.api.Test
    void testToString() {
		CoffemakersTest myUnit = new CoffemakersTest();
		Coffemakers cofeeee = new Coffemakers("Coffeek", 500, "BLACK", 940);
		String result = cofeeee.toString();

		assertEquals("cost - 940  volume - 500  name - Coffeek  color - BLACK", result);
    }
    
	@org.junit.jupiter.api.Test
    void testSetAndGetCost() {
		CoffemakersTest myUnit = new CoffemakersTest();
		Coffemakers cofeeee = new Coffemakers();
		cofeeee.SetCost(500);
		int result = cofeeee.GetCost();
		assertEquals(500, result);
    }
	
	@org.junit.jupiter.api.Test
    void testSetAndGetVolume() {
		CoffemakersTest myUnit = new CoffemakersTest();
		Coffemakers cofeeee = new Coffemakers();
		cofeeee.SetVolume(10025);
		int result = cofeeee.GetVolume();
		assertEquals(10025, result);
    }
	
	@org.junit.jupiter.api.Test
    void testSetAndGetName() {
		CoffemakersTest myUnit = new CoffemakersTest();
		Coffemakers cofeeee = new Coffemakers();
		cofeeee.SetName("Coffa");
		String result = cofeeee.GetName();
		assertEquals("Coffa", result);
    }
	
	@org.junit.jupiter.api.Test
    void testSetAndGetColor() {
		CoffemakersTest myUnit = new CoffemakersTest();
		Coffemakers cofeeee = new Coffemakers();
		cofeeee.SetColor("Grey");
		String result = cofeeee.GetColor();
		assertEquals("Grey", result);
    }

}
