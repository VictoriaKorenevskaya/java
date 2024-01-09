package laba5package;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class coffemakersTest {

	@Test
	void testGetCost() {
		coffemakers cooker = new coffemakers.Builder("Coffeek", 940, 500).Color("black").build();
		assertEquals(cooker.GetCost(), 500);
	}
	
	@Test
	void testGetVolume() {
		coffemakers cooker = new coffemakers.Builder("Coffa", 760, 400).Color("white").build();
		assertEquals(cooker.GetVolume(), 760);
	}
	
	@Test
	void testGetName() {
		coffemakers cooker = new coffemakers.Builder("Coffeek", 940, 500).Color("black").build();
		assertEquals(cooker.GetName(),"Coffeek");
	}
	
	@Test
	void testGetColor() {
		coffemakers cooker = new coffemakers.Builder("Cava", 4800, 300).Color("grey").build();
		assertEquals(cooker.GetColor(),"grey");
		coffemakers cooker2 = new coffemakers.Builder("Coffa", 760, 400).build();
		assertEquals(cooker2.GetColor()," ");
	}
	
	@Test
	void testToString() {
		coffemakers cooker = new coffemakers.Builder("Cava", 4800, 300).Color("grey").build();
		assertEquals(cooker.toString(),"cost - 300  volume - 4800  name - Cava  color - grey");
		
	}

}
