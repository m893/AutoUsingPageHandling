import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NotificationsPage;
import pages.PostPage;
import utils.BrowserFactory;
import utils.MobileAppAPIs;

public class NotificationsTests extends BaseTest {
    private WebDriver driver ;
    protected NotificationsPage notificationsPage ;


    @Test( enabled = true)
    public void addNewNotificationWithContentTest()
    {
        notificationsPage = homePage.navigateToNotificationsPage();
        notificationsPage.addNotificationPlusBtn();
        notificationsPage.addTittle("New Automation Script");
        notificationsPage.addContent("WithContent");
        notificationsPage.pushNotification();
    }
    @Test(enabled = true)
    public void addNewNotificationWithoutContentTest()
    {
        notificationsPage = homePage.navigateToNotificationsPage();
        notificationsPage.addNotificationPlusBtn();
        notificationsPage.addTittle("New Automation Script");
        notificationsPage.pushNotification();

    }
    @Test(enabled = false , dependsOnMethods = "addNewNotificationWithContentTest")
    public void editNotificationTest()
    {
        notificationsPage = homePage.navigateToNotificationsPage();
        notificationsPage.editNotification();
        notificationsPage.editContent();
        notificationsPage.pushEditedNotification();
    }

}
