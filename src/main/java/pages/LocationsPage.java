package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PagesHandling;

public class LocationsPage extends PagesHandling {

    public LocationsPage(WebDriver driver)
    {
        super(driver);
    }
    ///////////////////////////////////////////////Locators////////////////////////////////////////////////////////////////
    final private By ManageLocationsButton = By.cssSelector("a[href='/locations']");
    // we need to give these all elements id in website
    final private By threeDotBtn = By.xpath("/html/body/div/main/div[2]/div/div/div[3]/div[2]/div[2]/div/div[3]/div/div/div[2]/div/div/button");
    final private By editBtn = By.id("headlessui-menu-item-:r3v:");
    final private By deactivateBtn = By.id("headlessui-menu-item-:r48:");
    final private By activateBtn = By.id("headlessui-menu-item-:r4b:");

    ////////////////////////////////////////////////Actions//////////////////////////////////////////////////////////////////

    public void navigateToLocators()
    {
        click(ManageLocationsButton,5);
    }
    public void deactivateDesk()
    {
        click(threeDotBtn,5);
        click(deactivateBtn,5);
    }
    public void activateDesk()
    {
        click(threeDotBtn,5);
        click(activateBtn,5);
    }

}
