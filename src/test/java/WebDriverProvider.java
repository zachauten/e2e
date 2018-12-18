import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class WebDriverProvider implements ArgumentsProvider {

    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        System.setProperty("webdriver.gecko.driver", "src/test/webdrivers/geckodriver");
        System.setProperty("webdriver.chrome.driver", "src/test/webdrivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
        firefoxDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return Stream.of(chromeDriver, firefoxDriver).map(Arguments::of);
    }
}
