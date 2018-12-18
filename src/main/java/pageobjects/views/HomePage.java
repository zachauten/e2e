package pageobjects.views;

import pageobjects.PageObject;
import pageobjects.components.Footer;
import pageobjects.components.Header;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

    private final Header header = new Header(this.driver);
    private final Footer footer = new Footer(this.driver);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Footer getFooter() {
        return footer;
    }

    public Header getHeader() {
        return header;
    }
}
