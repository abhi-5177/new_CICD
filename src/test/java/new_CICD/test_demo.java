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
	        AssertJUnit.assertEquals(driver.getTitle(), "Java | Oracle1");  
	        
	        
	        //06052025---10:47PM
	    }

		@AfterClass
	    public void tearDown() {
	        if (driver != null) driver.quit();
	    }

}
