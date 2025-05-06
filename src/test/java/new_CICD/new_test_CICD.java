package new_CICD;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.lang.reflect.Method;
public class new_test_CICD {
	  WebDriver driver;

		@BeforeClass
	    public void setUp(ITestContext context){
			
	    driver = new ChromeDriver();
	    context.setAttribute("driver", driver);
	    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

	    }

	    @Test
	    public void testGoogleSearchTitle() {
	        driver.get("https://www.google.com");
	        AssertJUnit.assertEquals(driver.getTitle(), "Google1");  
	        
	        
	        //05052025---15:37PM
	    }

		@AfterClass
	    public void tearDown() {
	        if (driver != null) driver.quit();
	    }

}
