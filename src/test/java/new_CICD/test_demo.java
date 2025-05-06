package new_CICD;

import org.testng.AssertJUnit;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.lang.reflect.Method;
public class test_demo {
	  WebDriver driver;

	  @BeforeClass
	    public void setUp(ITestContext context){
			
	    driver = new ChromeDriver();
	    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	    context.setAttribute("driver", driver);

	    }

	    @Test
	    public void testwikiSearchLinux() {
	        driver.get("https://www.java.com/en/");
	        //AssertJUnit.assertEquals(driver.getTitle(), "Java | Oracle1");  
	        String actualTitle = driver.getTitle();
	        String expectedTitle = "The123Java";
	        AssertJUnit.assertEquals("Expected title: " + expectedTitle + " but found: " + actualTitle, actualTitle, expectedTitle);

	        
	        //06052025---10:47PM
	    }
	    @Test
	    public void visit_geeksforgeeks() {
	        driver.get("https://www.geeksforgeeks.org/");
	        //AssertJUnit.assertEquals(driver.getTitle(), "Java | Oracle");  
	        String actualTitle = driver.getTitle();
	        String expectedSubstring = "GeeksforGeeks";
	        AssertJUnit.assertTrue("Expected title to contain: " + expectedSubstring + " but found: " + actualTitle, actualTitle.contains(expectedSubstring));

	        
	        //06052025---10:47PM
	    }

		@AfterClass
	    public void tearDown() {
	        if (driver != null) driver.quit();
	    }

}
