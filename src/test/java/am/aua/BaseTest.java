package am.aua;

import am.aua.page.login.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.Resources;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;

public abstract class BaseTest {

    private WebDriver driver;

    protected WebDriverWait wait;
    protected LoginPage loginPage;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL(Constants.REMOTE_DRIVER_URL), new EdgeOptions())                                                                                ;
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @BeforeMethod
    public void setUp() {
        driver.get(Constants.APP_URL);
        loginPage = new LoginPage(driver, wait);
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        driver.manage().deleteAllCookies();
        if (result.getStatus() == ITestResult.FAILURE) {
            if (driver instanceof TakesScreenshot takesScreenshot) {
                byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
                Resources.saveScreenshot(screenshot, result.getName() + "_" + LocalDateTime.now() + ".png");
            }
        }
    }
}
