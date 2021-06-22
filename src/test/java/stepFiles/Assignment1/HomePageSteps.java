package stepFiles.Assignment1;

import com.walletHub.Pages.Assignment1.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.TestContext;

public class HomePageSteps {

    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getWebPageObjectManger().getHomePageAss1();
    }

    @When("^user enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userEnterUsernameAsAndPasswordAs(String username, String password) throws Throwable {
       homePage.enterUsername(username);
       homePage.enterPassword(password);
    }

    @When("^user click on facebook login button$")
    public void userClickOnFacebookLoginButton() {
        homePage.clickOnFbLogin();
    }

    @Given("^verify that facebook homepage is opened$")
    public void verifyThatFacebookHomepageIsOpened() {
        homePage.isHomePageOpen();
    }
}
