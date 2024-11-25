package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PagesHandling;

public class LoginPage extends PagesHandling {


    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    /////////////////////////////////////////////Locators///////////////////////////////////////////////////

    private final By EmailField= By.id("email");
    private final By SubmitButton = By.className("bg-primary");
    private final By OTPField1 = By.cssSelector("input[aria-label='Please enter OTP character 1']") ;
    private final By OTPField2 = By.cssSelector("input[aria-label='Please enter OTP character 2']");
    private final By OTPField3 = By.cssSelector("input[aria-label='Please enter OTP character 3']");
    private final By OTPField4 = By.cssSelector("input[aria-label='Please enter OTP character 4']");
    private final By OTPField5 = By.cssSelector("input[aria-label='Please enter OTP character 5']");
    private final By VerifyButton = By.xpath("//button[text()='Verify my account']");

    private final By AccountButton = By.xpath("//*[@id=\"headlessui-popover-button-:r2:\"]/div/h2");
    private final By LogoutButton = By.xpath("//div[contains(@class, 'text-base')]/p[text()='Logout']");
    private final By LogoutButton2 = By.xpath("//button[contains(@class, 'inline-flex') and contains(text(), 'Logout')]");
    //button[contains(@class, 'inline-flex') and contains(text(), 'Logout')]
    /////////////////////////////////////////Actions//////////////////////////////////////
    public void NavigateToUrl()
    {
        driver.get("https://jeel-portal-dev.dclickltd.com/login-dashboard");
    }
    public void LoginWithTestEmail()
    {

        sendkeys(EmailField,5,"test@dclickltd.com");
        click(SubmitButton,5);
    }
    public void VerifyWithOTP()
    {

        sendkeys(OTPField1,5,"1");
        sendkeys(OTPField2,5,"2");
        sendkeys(OTPField3,5,"3");
        sendkeys(OTPField4,5,"4");
        sendkeys(OTPField5,5,"5");
        click(VerifyButton,5);
    }
    public void Logout()
    {
        click(AccountButton,5);
        click(LogoutButton,5);
        click(LogoutButton2,5);
    }

}
