package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PagesHandling;

public class NotificationsPage extends PagesHandling {
    public NotificationsPage(WebDriver driver)
    {
        super(driver);
    }

    /////////////////////////////////////////////Locators///////////////////////////////////////////////////////////
    final private By addNewNotificationPlusBtn = By.xpath("//button[@id=\"add-notification-btn\"]") ;
    final private By tittleField = By.id("add-title");
    final private By contentField = By.id("add-content");
    final private By saveBtn = By.id("save");
    final private By saveAndPushBtn = By.id("saveAndPush");
    final private By saveAndPushEdited = By.id("saveAndPush-edit");
    final private By threeDotsEdit = By.id("popover-notification-247");
    final private By editNotificationBtn = By.xpath("//button[@id=\"edit-popover-notification-247\"]");
    final private By editContentField = By.xpath("//input[@id=\"edit-content\"]");
    /////////////////////////////////////////Actions///////////////////////////////////////////////////////////////////

    public void addNotificationPlusBtn()
    {
        click(addNewNotificationPlusBtn,5);
    }
    public void addTittle(String Tittle)
    {
        sendkeys(tittleField,5,Tittle);
    }
    public void addContent(String Content)
    {
        sendkeys(contentField,5,Content);
    }
    public void pushNotification()
    {
        click(saveAndPushBtn,5);
    }
    public void saveNotification()
    {
        click(saveBtn,10);
    }
    public void editNotification()
    {
        click(threeDotsEdit,10);
        click(editNotificationBtn,10);
    }
    public void editContent()
    {
        sendkeys(editContentField,10,"Edit");
    }
    public void pushEditedNotification()
    {
        click(saveAndPushEdited,5);
    }
}
