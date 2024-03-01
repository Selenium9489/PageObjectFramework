import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SampleTest {
	SoftAssert softAssert;
	
	@Test
	public void abc() {
		softAssert = new SoftAssert();
		softAssert.assertEquals("A", "A");
		softAssert.assertEquals("A", "A1");//fail
		softAssert.assertEquals("A", "A");
		//softAssert.fail("XYZ");//fail
		
		softAssert.assertAll();
		System.out.println("XYZZZZZ");
		
		
	}
	
	@AfterMethod
	public void quit() {
		
	}

}
