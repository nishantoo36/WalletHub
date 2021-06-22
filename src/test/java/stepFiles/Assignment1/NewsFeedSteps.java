package stepFiles.Assignment1;

import com.walletHub.Pages.Assignment1.NewsFeed;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import helpers.TestContext;

public class NewsFeedSteps {
    TestContext testContext;
    NewsFeed newsFeed;

    public NewsFeedSteps(TestContext context) {
        testContext = context;
        newsFeed = testContext.getWebPageObjectManger().getNewsFeedAss1();
    }

    @When("^user do post as \"([^\"]*)\"$")
    public void userDoPostAs(String value) throws Throwable {
        newsFeed.doPost(value);
    }

}
