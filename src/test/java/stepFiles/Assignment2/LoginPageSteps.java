package stepFiles.Assignment2;

import com.walletHub.Pages.Assignment2.CommonUIActions;
import com.walletHub.Pages.Assignment2.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.TestContext;
import org.testng.Assert;

public class LoginPageSteps {

    TestContext testContext;
    LoginPage loginPage;
    CommonUIActions commonUIActions;

    public LoginPageSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getWebPageObjectManger().getLoginPageAss2();
        commonUIActions = testContext.getWebPageObjectManger().getCommonActionsScreen();
    }



    @Then("^verify that login page open$")
    public void verifyThatLoginPageOpen() {
        Assert.assertTrue(loginPage.isLoginPageOpen(),"Verification failed, Login page is not open");
    }

    @When("^user enter username as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEnterUsernameAsAnd(String username, String password) throws Throwable {
        loginPage.doLogin(username,password);
        Thread.sleep(5000);
    }


}
