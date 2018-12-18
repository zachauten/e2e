import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebDriverExtension
        implements WebDriver, Extension,
        BeforeTestExecutionCallback,
        AfterTestExecutionCallback {

    private WebDriver driver;
    private String url;

    private WebDriverExtension() {}

    public void beforeTestExecution(ExtensionContext context) {
        this.driver.get(this.url);
    }

    public void afterTestExecution(ExtensionContext context) {
        this.driver.quit();
    }

    public void get(String url) {this.driver.get(url);}

    public String getCurrentUrl() {return this.driver.getCurrentUrl();}

    public String getTitle() {return this.driver.getTitle();}

    public List<WebElement> findElements(By by) {return this.driver.findElements(by);}

    public WebElement findElement(By by) {return this.driver.findElement(by);}

    public String getPageSource() {return this.driver.getPageSource();}

    public void close() {this.driver.close();}

    public void quit() {this.driver.quit();}

    public Set<String> getWindowHandles() {return this.driver.getWindowHandles();}

    public String getWindowHandle() {return this.driver.getWindowHandle();}

    public WebDriver.TargetLocator switchTo() {return this.driver.switchTo();}

    public WebDriver.Navigation navigate() {return this.driver.navigate();}

    public WebDriver.Options manage() {return this.driver.manage();}

    public static class Builder {

        private Browser browser;
        private int timeout;
        private String url;

        public Builder(Browser browser) {
            this.browser = browser;
        }

        public Builder setPath(String path) {
            switch (this.browser) {
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", path);
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", path);
            }
            return this;
        }

        public Builder setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public WebDriverExtension build() {
            WebDriverExtension driverExtension = new WebDriverExtension();
            driverExtension.driver = getDriver(browser);
            driverExtension.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
            driverExtension.url = this.url;
            return driverExtension;
        }

        private WebDriver getDriver(Browser browser) {
            switch (browser) {
                case FIREFOX: return new FirefoxDriver();
                case CHROME:
                default: return new ChromeDriver();
            }
        }
    }
}
