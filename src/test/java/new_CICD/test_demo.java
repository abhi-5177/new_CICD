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
public class test_demo {
	  WebDriver driver;

		@BeforeClass
	    public void setUp() {
	    driver = new ChromeDriver();
	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

	    }

	    @Test
	    public void testwikiSearchLinux() {
	        driver.get("https://en.wikipedia.org/wiki/Linux");
	        AssertJUnit.assertEquals(driver.getTitle(), "Linux");  
	        
	        
	        //06052025---10:47PM
	    }

		@AfterClass
	    public void tearDown() {
	        if (driver != null) driver.quit();
	    }

}
