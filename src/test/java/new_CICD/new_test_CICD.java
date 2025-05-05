package new_CICD;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import static org.testng.Assert.*;
public class new_test_CICD {
	  WebDriver driver;

		@BeforeClass
	    public void setUp() {
	    driver = new ChromeDriver();
	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

	    }

	    @Test
	    public void testGoogleSearchTitle() {
	        driver.get("https://www.google.com");
	        AssertJUnit.assertEquals(driver.getTitle(), "Google");  
	    }

		@AfterClass
	    public void tearDown() {
	        if (driver != null) driver.quit();
	    }

}
