import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CateringScreenPage;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.OnDutyPage;
import utils.BrowserFactory;
import utils.MobileAppAPIs;

public class CateringScreenTests {
    private WebDriver driver ;
    private OnDutyPage onDutyPage;
    private CateringScreenPage cateringScreenPage;

    private MobileAppAPIs mobileAppAPIs ;

    @BeforeClass
    public void setupMethod()
    {
        driver= BrowserFactory.getDriver();
        onDutyPage = new OnDutyPage(driver);
        cateringScreenPage=new CateringScreenPage(driver);
        mobileAppAPIs = new MobileAppAPIs();

    }
    @Test(priority = 1 , enabled = true)
    public void BookMeeting()
    {
        mobileAppAPIs.GetTheRoomThatWillBooked();
        mobileAppAPIs.BookMeeting();

    }
    @Test(priority = 2 , enabled = true)
    public void CreateOrder()
    {
        cateringScreenPage.navigateToCateringRoom();
        cateringScreenPage.OrderCatering();


    }
    @Test(priority = 3 , enabled = true)
    public void CancelOrder()
    {
        onDutyPage.NavigateToOnDutyPageForRoom();
        onDutyPage.CancelOrder();

        cateringScreenPage.navigateToCateringRoom();

        cateringScreenPage.CancelAcknowledge();
    }
    @Test(priority = 4, enabled = true)
    public void AcceptOrder()
    {
        cateringScreenPage.navigateToCateringRoom();
        cateringScreenPage.OrderCatering();

        onDutyPage.NavigateToOnDutyPageForRoom();
        onDutyPage.AcceptOrder();
        onDutyPage.DeliverOrder();

    }
    @Test(priority = 5 , enabled = false)
    public void CancelPartialOrder()
    {
        cateringScreenPage.navigateToCateringRoom();
        cateringScreenPage.OrderTwoCatering();

        onDutyPage.NavigateToOnDutyPageForRoom();

        onDutyPage.CancelOrder();
        onDutyPage.AcceptOrder();

        onDutyPage.DeliverOrder();
    }
    @Test(priority = 6 ,enabled = true)
    public void CancelMeeting()
    {
        mobileAppAPIs.CancelMeetingBooking();
    }

}
