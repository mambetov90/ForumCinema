package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Common;
import pages.HomePage;
import pages.ProfilePage;

import static pages.ProfilePage.*;


public class HomePageSteps extends Common {

    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();

    @Given("Open home page")
    public void openHomepage(){
    setUp();
    openApplication();
    }

    @When("^Login to my profile page and enter (.*) and (.*)$")
    public void loginToMyProfilePageAndEnterUsernameAndPassword(String username, String pwd) throws InterruptedException {
        homePage.populateLoginForm(username, pwd);

    }

    @Then("^Change (.*), (.*)$")
    public void changeNameLastnameAndDob(String name, String lastname) {
        driver.findElement(NAVIGATE_TO_PROFILE).click();
        driver.findElement(EDIT_PROFILE).click();
        profilePage.changeData(name);
        profilePage.changeLastname(lastname);
    }

    @And("Save the changes")
    public void saveTheChanges(){
        profilePage.scrollIntoTheView();
        driver.findElement(SAVE_CHANGES).click();
    }

}
