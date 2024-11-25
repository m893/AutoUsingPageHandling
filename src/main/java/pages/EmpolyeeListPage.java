package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PagesHandling;

public class EmpolyeeListPage extends PagesHandling {
    EmpolyeeListPage(WebDriver driver)
    {
        super(driver);
    }
    /////////////////////////////////////////////Locators///////////////////////////////////////////////
    final private By manageEmployee = By.cssSelector("a[href='/employees']");
    final private By threeDots = By.id("emp-menu");
    final private By searchField = By.id("default-search");
    final private By editButton = By.id("edit-employee-13");
    final private By deactivateBtn = By.id("active-employee-13");
    final private By firstName = By.id("firstName");
    final private By lastName = By.id("lastName");
    final private By selectRole = By.id("select-Role of employees");
    final private By saveEdits = By.id("saveEdits");
    final private By cancelEdits = By.id("cancel-edit-emp");

//////////////////////////////////////////////////////////Actions/////////////////////////////////////////////////////////


}
