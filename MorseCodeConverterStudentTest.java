import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverterStudentTest {

	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish(".. / .-.. --- ...- . / -.-. -- ... -.-.");
		assertEquals("i love cmsc",converter1);
	}
	
	
	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		String converter1 = MorseCodeConverter.convertToEnglish(".. / .... .- ...- . / .- / .--. . - / -. . .--. .... . .-- / -. .- -- . -.. / .--. .. ... - .- -.-. .... .. --- / .... . / .. ... / .- -.. --- .-. .- -... .-.. .");
		assertEquals("i have a pet nephew named pistachio he is adorable", converter1);

	}
	@Test
	public void testConvertMorseFileToEnglishString() {	
		
		/*Make sure howDoILoveThee.txt is in the src directory for this 
		  test to pass
		*/
		File file = new File("src/IHaveAPetNephewNamedPistachioHeIsAdorable.txt"); 
		try {
			assertEquals("i have a pet nephew named pistachio he is adorable", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}

}
