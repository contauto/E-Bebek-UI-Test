package Base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static TestCases.SearchTest.driver;

public class BaseClass {

    public static String baseUrl="https://www.e-bebek.com/";

    public BaseClass() {
        driver.manage().window().setSize(new Dimension(1552, 840));
    }

    public static void last(){
        driver.quit();
    }

    public static void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0)");
    }

    public static WebDriverWait waiter(int sec){
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(9, ChronoUnit.SECONDS));
        return wait;
    }

}
