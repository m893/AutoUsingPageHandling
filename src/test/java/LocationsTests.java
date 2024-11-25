import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LocationsPage;
import pages.LoginPage;
import pages.NotificationsPage;
import utils.BrowserFactory;
import utils.MobileAppAPIs;

public class LocationsTests {
    private WebDriver driver ;
    private LoginPage loginPage;
    private LocationsPage locationsPage;
    private MobileAppAPIs mobileAppAPIs ;

    @BeforeClass
    public void setMethod()
    {
        driver= BrowserFactory.getDriver();
        loginPage = new LoginPage(driver);
        locationsPage = new LocationsPage(driver);
        mobileAppAPIs = new MobileAppAPIs();
    }

    @Test(priority = 1 , enabled = true)
     public void deactivateDeskTest()
    {
            loginPage.NavigateToUrl();
            loginPage.LoginWithTestEmail();
            loginPage.VerifyWithOTP();
            locationsPage.navigateToLocators();
            locationsPage.deactivateDesk();
    }
    @Test(priority = 2 , enabled = true)
    public void activateDeskTest()
    {
        locationsPage.activateDesk();
    }
}
