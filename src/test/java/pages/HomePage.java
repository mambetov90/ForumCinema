package pages;

import helpers.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends Common {

    private static final By login = By.xpath("//div[@class=\"btn-login btn btn-default popover-link hidden-xs hidden-sm\"]");
    private static final By USERNAME = By.name("userName");
    private static final By PASSWORD = By.name("password");
    private static final By LOGIN = By.xpath("//button[@type=\"submit\" and @class=\"btn btn-primary btn-lg\"]");

    public void populateLoginForm(String username, String pwd) throws InterruptedException {
        driver.findElement(login).click();
        populateForm(USERNAME, username);
        populateForm(PASSWORD, pwd);
        driver.findElement(LOGIN).sendKeys(Keys.ENTER);
    }
}
