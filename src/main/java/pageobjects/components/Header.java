package pageobjects.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.PageObject;

public class Header extends PageObject {

    private WebElement logo;
    @FindBy(linkText = "https://www.demo-charitablegift.com/cgfweb/DonorCenter/pgLoginExt_demo.jsp")
    private WebElement tryOurDemo;
    private WebElement contactUs;
    private WebElement openGivingAccount;
    private WebElement logIn;

    public Header(WebDriver driver) {
        super(driver);
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getTryOurDemo() {
        return tryOurDemo;
    }

    public WebElement getContactUs() {
        return contactUs;
    }

    public WebElement getOpenGivingAccount() {
        return openGivingAccount;
    }

    public WebElement getLogIn() {
        return logIn;
    }
}
