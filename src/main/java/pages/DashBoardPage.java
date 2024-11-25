package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PagesHandling;
import java.io.File;

public class DashBoardPage extends PagesHandling {

    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public DashBoardPage(WebDriver driver)
    {
        super(driver);
    }

    File imagefile= new File("images/carRender.jpg");
    String imagePath=imagefile.getAbsolutePath();
    //////////////////////////////////////Locators/////////////////////////////////////////

    final private By BeverageButton = By.id("headlessui-disclosure-button-:r0:");
    final private By ManageCategoriesButton = By.cssSelector("a[href='/categories']");
    final private By ManageItemsButton = By.cssSelector("a[href='/beverages']");
    final private By AddCategoryPlusIcon = By.id("add-category");
    final private By CategoryImageButton = By.cssSelector("#dropzone-category-file");
    final private By SaveCategoryImage = By.xpath("//button[text()='Save']");
    final private By CategoryNameField = By.id("category-name");
    final private By AddNewCategoryButton = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div/form/div[2]/button[1]");
    final private By TestCategoryButton = By.xpath("#root > main > div:nth-child(3) > div > div > div.flex.flex-col.min-w-0.flex-1.overflow-hidden > div.flex.flex-col.flex-1.h-full.relative.z-0.ps-5.overflow-hidden.ps-\\[46px\\] > div.w-full.flex > div > div.flex.flex-col.gap-5 > div:nth-child(2) > div > div > div > button:nth-child(3)");
    final private By AddCateringPlusButton = By.xpath("//*[@id=\"add-beverage\"]");
    final private By ChooseCategoryButton = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div/form/div[1]/div[2]/div[2]/div/button");
    final private By TestCategorySpan = By.xpath("//span[text()='TestCategory']");
    final private By CateringImageButton = By.id("dropzone-catering-file");
    final private By CateringNameField = By.id("product-name");
    final private By AddItemButton = By.id("add-catering");
    /////////////////////////////////Actions//////////////////////////////////

    public void AddNewCategory()
    {
        click(BeverageButton,5);
        click(ManageCategoriesButton,5);
        click(AddCategoryPlusIcon,5);
        sendkeys(CategoryImageButton,5,imagePath);
        click(SaveCategoryImage,5);
        sendkeys(CategoryNameField,5,"TestCategory");
        click(AddNewCategoryButton,5);

    }
    public void AddNewItem(String Name)
    {

        driver.get("https://jeel-portal-dev.dclickltd.com/beverages");


        click(TestCategoryButton,5);
        click(AddCateringPlusButton,5);
        sendkeys(CateringImageButton,5,imagePath);
        click(SaveCategoryImage,5);
        sendkeys(CateringNameField,5,Name);
        click(AddItemButton,5);
    }
    public void CloseWebsite()
    {
        driver.close();
    }


}
