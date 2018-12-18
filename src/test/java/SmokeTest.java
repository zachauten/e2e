import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import pageobjects.views.HomePage;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@ExtendWith(DriverResolver.class)
public class SmokeTest {

//    @RegisterExtension
//    WebDriverExtension driver = new WebDriverExtension.Builder(Browser.CHROME)
//            .setPath("src/test/webdrivers/chromedriver")
//            .setTimeout(3)
//            .setUrl("https://www.fidelitycharitable.org/")
//            .build();

//    @Test
//    void testTryOurDemo() {
//        HomePage homepage = new HomePage(driver);
//        driver.manage().window().maximize();
//        homepage.getHeader().getTryOurDemo().click();
//    }

    @TestFactory
    Stream testTryOurDemo(Stream<WebDriver> drivers) {

        return drivers.map(driver -> dynamicTest(getDemoTestDisplayName((WebDriver) driver), () -> {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.get("https://www.fidelitycharitable.org/");
            HomePage homepage = new HomePage(driver);
            driver.manage().window().maximize();
            homepage.getHeader().getTryOurDemo().click();
        }));
    }

    String getDemoTestDisplayName(WebDriver driver) {
        return driver.getClass().getSimpleName();
    }
}
