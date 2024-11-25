package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MobileAppAPIs;
import utils.PagesHandling;

public class CateringScreenPage extends PagesHandling {

    public CateringScreenPage(WebDriver driver)
    {
       super(driver);
    }



    ///////////////////////Locators///////////////////////////////////////////////////////




    final private By AddCateringButton1 = By.id("button-increase-299");

    final private By AddCateringButton2 = By.id("button-increase-298");

    final private By CreateOrder = By.id("create-order");

    final private By CurrentOrder = By.id("current-order-tab");

    final private By RejectAcknowledgeButton = By.id("reject-acknowledge");



    ///////////////////Actions////////////////////////////////////////////////////////////
    public void navigateToCateringRoom()
    {
        driver.get("https://jeel-portal-dev.dclickltd.com/room-catering/"+ MobileAppAPIs.RoomID+"/order?ApiKey=MIXojpPiXVcYl6rwKz6k4eGzXeHp7CnmrkhDPUaAXLGwWwxFYPLBDDYzCExCkcBG");

    }
    public void OrderCatering()
    {
        click(AddCateringButton1,5);
        click(CreateOrder,5);

    }
    public void OrderTwoCatering()
    {
        click(AddCateringButton1,5);
        click(AddCateringButton2,5);
        click(CreateOrder,5);

    }


    //////////////////Validations//////////////////////////////////////////////////////////
    public void CancelAcknowledge()
    {
        click(CurrentOrder,5);
        click(RejectAcknowledgeButton,5);
    }
}
