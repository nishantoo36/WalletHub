package stepFiles.Assignment2;

import com.walletHub.Pages.Assignment2.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.TestContext;
import org.testng.Assert;

public class HomePageSteps  {
    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getWebPageObjectManger().getHomePageAss2();
    }

    @Given("^verify that homepage is opened$")
    public void verifyThatHomepageIsOpened() {
        Assert.assertTrue(homePage.isHomePageOpen(),"Verification failed, Home page is not opened");
    }

    @When("^user click on login button$")
    public void userClickOnLoginButton() {
        homePage.clickOnLogin();
    }

}
