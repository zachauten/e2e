import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.openqa.selenium.WebDriver;

@Execution(ExecutionMode.CONCURRENT)
public class ConcurrentParameterizedTest {

    @AfterEach
    void teardown() {
        System.out.println("aftereach");
    }

    @ParameterizedTest
    @ArgumentsSource(WebDriverProvider.class)
    void test1(WebDriver driver) {
        System.out.println("test 1");
        driver.get("https://www.google.com/");
    }

    @ParameterizedTest
    @ArgumentsSource(WebDriverProvider.class)
    void test2(WebDriver driver) {
        System.out.println("test 2");
        driver.get("https://www.google.com/");

    }

    @ParameterizedTest
    @ArgumentsSource(WebDriverProvider.class)
    void test3(WebDriver driver) {
        System.out.println("test 3");
        driver.get("https://www.google.com/");
    }

    @ParameterizedTest
    @ArgumentsSource(WebDriverProvider.class)
    void test4(WebDriver driver) {
        System.out.println("test 4");
        driver.get("https://www.google.com/");
    }

    @ParameterizedTest
    @ArgumentsSource(WebDriverProvider.class)
    void test5(WebDriver driver) {
        System.out.println("test 5");
        driver.get("https://www.google.com/");
    }
}
