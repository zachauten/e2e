import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.stream.Stream;

public class DriverResolver implements ParameterResolver {

    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Class<?> type = parameterContext.getParameter().getType();
        ParameterizedType parameterizedType = (ParameterizedType) parameterContext.getParameter().getParameterizedType();
        return  type == Stream.class && parameterizedType.getActualTypeArguments()[0] == WebDriver.class;
    }

    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        System.setProperty("webdriver.gecko.driver", "src/test/webdrivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", "src/test/webdrivers/geckodriver");
        return Arrays.asList(new ChromeDriver(), new FirefoxDriver()).stream();
    }
}
