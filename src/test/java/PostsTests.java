import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CateringScreenPage;
import pages.LoginPage;
import pages.OnDutyPage;
import pages.PostPage;
import utils.BrowserFactory;
import utils.MobileAppAPIs;

public class PostsTests extends BaseTest {
    private WebDriver driver ;
   private PostPage postPage ;


    @Test( enabled = true)
    public void addNewPostTest()
    {
        postPage = homePage.navigateToPostsPage();
        postPage.addPostPlusBtn();
        postPage.setPostImage();
        postPage.addNewPostBtn();
    }
  @Test(priority = 2 , enabled = true)
    public void changePostPriorityTest()
    {
        postPage = homePage.navigateToPostsPage();
        postPage.addPostPlusBtn();
        postPage.setPostImage();
        postPage.addNewPostBtn();
    }
    /*@Test(priority = 3 , enabled = true)
    public void checkTheOrderOfPostOnAppTest()
    {
        mobileAppAPIs.GetPostsOrder();
    }
    @Test(priority = 4 , enabled = true)
    public void deletePostTest()
    {
        driver.quit();
    }
*/
}
