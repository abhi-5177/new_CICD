package new_CICD;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;


public class AllureTestListener implements ITestListener {

    // Get WebDriver from your BaseTest or ThreadLocal
    private WebDriver getDriver(ITestResult result) {
        return (WebDriver) result.getTestContext().getAttribute("driver");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = getDriver(result);
        if (driver != null) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File screenshot = ts.getScreenshotAs(OutputType.FILE);
            try {
                byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
                Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(fileContent));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // You can add other overrides like onTestStart, onTestSuccess, etc. if needed
}
