package stepFiles.Assignment2;

import com.walletHub.Pages.Assignment2.CommonUIActions;
import cucumber.api.java.en.Given;
import helpers.TestContext;

public class PreconditionSteps  {

    TestContext testContext;
    CommonUIActions commonUIActions;

    public PreconditionSteps(TestContext context) {
        testContext = context;
        commonUIActions = testContext.getWebPageObjectManger().getCommonActionsScreen();
    }


    @Given("^Open Url \"([^\"]*)\"$")
    public void openUrl(String url) throws Throwable {
       commonUIActions.openMainURL(url);
    }
}
