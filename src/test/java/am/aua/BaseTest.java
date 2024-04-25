package am.aua;

import am.aua.page.login.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.Resources;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class BaseTest {

    private WebDriver driver;

    protected WebDriverWait wait;
    protected LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    @BeforeMethod
    public void setUp() {
        driver.get(Constants.APP_URL);
        loginPage = new LoginPage(driver, wait);
    }


    @AfterClass
    public void afterClass() {
        driver.close();
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
