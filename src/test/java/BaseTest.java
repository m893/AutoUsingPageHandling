import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.LoginPage;
import utils.BrowserFactory;
import utils.MobileAppAPIs;

public class BaseTest {
    protected WebDriver driver ;
    protected LoginPage loginPage;
    protected MobileAppAPIs mobileAppAPIs ;
    protected HomePage homePage;

    public BaseTest()
    {
        driver= BrowserFactory.getDriver();
        loginPage = new LoginPage(driver);
        mobileAppAPIs = new MobileAppAPIs();
        homePage = new HomePage(driver);
    }
    @BeforeClass
    public void LoginTest()
    {
        loginPage.NavigateToUrl();
        loginPage.LoginWithTestEmail();
        loginPage.VerifyWithOTP();

    }
}
