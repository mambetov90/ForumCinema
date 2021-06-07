package pages;

import helpers.Common;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class ProfilePage extends Common {

    public static final By EDIT_PROFILE = By.cssSelector("div[class*=\"log-out-container\"] a[href=\"/mypage/profile/\"]");
    public static final By NAVIGATE_TO_PROFILE = By.cssSelector("a[class=\"navbar-link\"]");
    private static final By FIRST_NAME = By.id("inputFirstName");
    private static final By LAST_NAME = By.id("inputLastName");
    public static final By SAVE_CHANGES = By.xpath("//button[@class=\"btn btn-primary\"]//span");

    public void editProfile(String name, String surname, String day, String month, String year) {
        driver.findElement(NAVIGATE_TO_PROFILE).click();
        driver.findElement(EDIT_PROFILE).click();
        populateForm(FIRST_NAME, name);
        populateForm(LAST_NAME, surname);
        setDOB(day, month, year);
        scrollIntoTheView();
        driver.findElement(SAVE_CHANGES).click();
    }

    public void changeData(String value) {
        driver.findElement(FIRST_NAME).clear();
        driver.findElement(FIRST_NAME).sendKeys(value);
    }

    public void changeLastname(String value) {
        driver.findElement(LAST_NAME).clear();
        driver.findElement(LAST_NAME).sendKeys(value);
    }

    public void setDOB(String day, String month, String year) {
        Select selectDay = new Select(driver.findElement(By.id("bdDay")));
        selectDay.selectByVisibleText(day);
        Select selectMonth = new Select(driver.findElement(By.id("bdMonth")));
        selectMonth.selectByVisibleText(month);
        Select selectYear= new Select(driver.findElement(By.id("bdYear")));
        selectYear.selectByVisibleText(year);
    }

    public void scrollIntoTheView() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public String generateRandomString() {
        int length = 5;
        String generatedString = RandomStringUtils.random(length, true, false);
        return generatedString;
    }

    public String generateRandomNumber(int min, int max) {
        int randomNumt = (int)Math.floor(Math.random()*(max-min+1)+min);
        return String.valueOf(randomNumt);
    }

    public String selectRandomMonth() {
        String[] months = {"Janvāris","Februāris","Marts","Aprīlis","Maijs","Jūnijs","Jūlijs","Augusts", "Septembris", "Oktobris", " Novembris", "Decembris"};
        int month = new Random().nextInt(months.length);
        String randomMonth = (months[month]);
        return randomMonth;
    }

    public boolean getNotificationMsg() {
        boolean status = false;
        WebElement notifMsg = driver.findElement(By.cssSelector("div[class=\"bs-callout bs-callout-success\"]"));
        if(notifMsg.isDisplayed()){
            status = true;
        }
        return status;
    }
}
