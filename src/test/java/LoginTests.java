import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    private WebDriver driver ;





    @Test(priority = 1,enabled = false)
    public void LoginTest()
    {
        loginPage.NavigateToUrl();
        loginPage.LoginWithTestEmail();
        loginPage.VerifyWithOTP();


    }
   /* @Test(priority = 2 ,enabled = true)
    public void LogoutTest()
    {
        loginPage.Logout();
    }
    @Test(priority = 3 ,enabled = true)
    public void AddNewCategoryTest()
    {
        loginPage.NavigateToUrl();
        loginPage.LoginWithTestEmail();
        loginPage.VerifyWithOTP();
        dashBoardPage.AddNewCategory();

    }
    @Test( priority = 4,enabled = true)
    public void AddNewCateringTest() throws InterruptedException {

        dashBoardPage.AddNewItem("Test");
        Thread.sleep(5000);


    }
    @Test( priority = 5,enabled = true)
    public void AddNewCateringTwoTest()
    {

        dashBoardPage.AddNewItem("Test2");


    }
    @Test(priority = 6)
    public void BookDeskTest()
    {
        //just we need to change time in api body to current time
        mobileAppAPIs.BookDesk();
    }
    @Test(priority = 7)
    public void GetIDForCatering()
    {
        mobileAppAPIs.GetTheCateringThatWillorderd();
    }
    @Test(priority =8 ,enabled = true )
    public void OderCateringFromAppTest()
    {
        mobileAppAPIs.OrderCatering();
        //mobileAppAPIs.GetOrderedCatering();
    }
    @Test(priority = 9 ,enabled = true)
    public void AcceptOrderFromPantryTest()
    {
        onDutyPage.NavigateToOnDutyPage();
        onDutyPage.AcceptOrder();

        onDutyPage.DeliverOrder();

    }

    @Test(priority = 10 , enabled = true)
    public void CancelPartialAndAccept()
    {

        mobileAppAPIs.OrderCatering2();
        onDutyPage.NavigateToOnDutyPage();
        onDutyPage.CancelOrder();
        onDutyPage.AcceptOrder();

        onDutyPage.DeliverOrder();

    }
    @Test(priority = 11,enabled = true )
    public void CancelOrderTest()
    {

        mobileAppAPIs.OrderCatering();
        onDutyPage.NavigateToOnDutyPage();
        onDutyPage.CancelOrder();



    }

    @Test(priority = 12,enabled = true)
    public void DeleteCateringTest()
    {
        mobileAppAPIs.GetTheCateringThatWillorderd();
        mobileAppAPIs.DeleteCatering();
    }
    @Test(priority = 13,enabled = true)
    public void DeleteCategoryAfterTest()
    {
        mobileAppAPIs.GetCategoryThatWillDeleted();
        mobileAppAPIs.DeleteCategory();

    }

    @Test(priority = 14 , enabled = true)
    public void CancelBooking()
    {
        mobileAppAPIs.CancelDeskBooking();
        driver.quit();
    }
*/
}
