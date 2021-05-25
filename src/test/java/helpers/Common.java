package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common {

    public static WebDriver driver = null;
    private final String URL = "https://www.forumcinemas.lv/";

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void openApplication() {
        driver.get(URL);
        driver.manage().window().maximize();
    }

    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    public void populateForm(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

}
