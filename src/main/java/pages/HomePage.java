package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PagesHandling;

public class HomePage extends PagesHandling {

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    //////////////////////////////////Locators//////////////////////////////////////////////
    final private By dashBoardBtn = By.xpath("//a[@class=\" text-white group flex items-center px-2 my-1 py-4 text-sm font-medium rounded-xl\"]");
    final  private By postsBtn = By.xpath("//a[@href=\"/posts\"]");
    final private By locationsBtn = By.xpath("//a[@href=\"/locations\"]");
    final private By floorsBtn = By.xpath("//a[@href=\"/floors\"]");
    final private By pantriesBtn = By.xpath("//a[@href=\"/pantries\"]");
    final private By notificationsBtn = By.xpath("//a[@href=\"/notifications\"]");
    final private By employeeListBtn = By.xpath("//a[@href=\"/employees\"]");
    final private By wifiBtn = By.xpath("//a[@href=\"/wifi\"]");
    final private By settingsBtn = By.xpath("//a[@href=\"/settings\"]");

    final private By beverageListBtn = By.xpath("//button[@id=\"headlessui-disclosure-button-:r0:\"]");
    final private By reportsBtn = By.xpath("//button[@id=\"headlessui-disclosure-button-:r1:\"]");
    final private By manageItemsBtn = By.xpath("//a[@href=\"/beverages\"]");
    final private By manageCategoriesBtn = By.xpath("//a[@href=\"/categories\"]");


    ///////////////////////////////Actions//////////////////////////////////////////////////

    public DashBoardPage navigateToDashBoardPage()
    {
        click(dashBoardBtn,10);
        return new DashBoardPage(driver);
    }
    public PostPage navigateToPostsPage()
    {
        click(postsBtn,10);
        return new PostPage(driver);
    }
    public NotificationsPage navigateToNotificationsPage()
    {
        click(notificationsBtn,10);
        return new NotificationsPage(driver);
    }
    public LocationsPage navigateToLocationsPage()
    {
        click(locationsBtn,10);
        return new LocationsPage(driver);
    }

}
