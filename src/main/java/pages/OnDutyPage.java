package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MobileAppAPIs;
import utils.PagesHandling;


public class OnDutyPage extends PagesHandling {

    public OnDutyPage(WebDriver driver)
    {
        super(driver);
    }
    ///////////////////Locators/////////////////////////////////////////////


    private final By AcceptOrderButton = By.id("accept-order");
    private final By DeliverOrderButton = By.id("ready-order");
    private final By CancelOrderButton = By.xpath("//*[@id=\"scroll_bar\"]/div/div[2]/button");


/////////////////Actions////////////////////////////////////////////////////////////////


    public void NavigateToOnDutyPage()
    {
        driver.get("https://jeel-portal-dev.dclickltd.com/pantry/3/?X-API-KEY=MIXojpPiXVcYl6rwKz6k4eGzXeHp7CnmrkhDPUaAXLGwWwxFYPLBDDYzCExCkcBG");
    }
    public void NavigateToOnDutyPageForRoom()
    {
        driver.get("https://jeel-portal-dev.dclickltd.com/pantry/"+ MobileAppAPIs.PantryID +"/?X-API-KEY=MIXojpPiXVcYl6rwKz6k4eGzXeHp7CnmrkhDPUaAXLGwWwxFYPLBDDYzCExCkcBG");

    }
    public void AcceptOrder()
    {
        click(AcceptOrderButton,5);
    }
    public void DeliverOrder()
    {
       click(DeliverOrderButton,5);
    }
    public void CancelOrder()
    {
        click(CancelOrderButton,5);
    }

    /////////////////////////////////Validations/////////////////////////////////////////////////////


}
