package runner;

import FileManager.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import helpers.ReportHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.GregorianCalendar;

@CucumberOptions(strict = true, monochrome = true, features = "src/test/java/FeatureFiles",
        glue = "stepFiles", plugin = {"pretty", "json:target/cucumber.json"})
public class AllRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver = null;

    private static String browser;

    static {
        browser = FileReaderManager.getInstance().getConfigReader().getBrowserName();
    }

    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterSuite(alwaysRun = true)
    public void generateHTMLReports() throws IOException {
        ReportHelper.generateCucumberReport();
    }

    public void takeScreenShot(String screenshotName, String path,Object driver) {
        try {
            File sourcePath = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            File destinationPath = new File(path + screenshotName + ".png");
            FileUtils.copyFile(sourcePath, destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void killDriver(ITestResult result) {
        String path = null;
        String ImageFileName = result.getMethod().getMethodName()
                + new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
        if(AllRunner.driver!=null){
            if (result.isSuccess()) {
                path = System.getProperty("user.dir") + "//screenshots/Web/Pass//" + ImageFileName;
            } else {
                path = System.getProperty("user.dir") + "//screenshots/Web/Fail-Skip//" + ImageFileName;
            }
            takeScreenShot(ImageFileName, path, AllRunner.driver);
            AllRunner.driver.quit();
            AllRunner.driver=null;
        }
    }

    private WebDriver startDriver() {
        if ("Chrome".equalsIgnoreCase(browser)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.setHeadless(false);
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } else if ("FireFox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public WebDriver getWebDriver(){
        if (driver == null || ((RemoteWebDriver)driver).getSessionId()==null)
            startDriver();
        return driver;
    }
}
