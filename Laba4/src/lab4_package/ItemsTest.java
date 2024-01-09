package lab4_package;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemsTest {

	//@Test
		@org.junit.jupiter.api.Test
	    void testToString() {
			CoffemakersTest myUnit = new CoffemakersTest();
			Items cofeeee = new Items();
			int result = cofeeee.Size();

			assertEquals(0, result);
	    }

}

