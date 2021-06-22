package stepFiles.Assignment2;

import com.walletHub.Pages.Assignment2.CommonUIActions;
import com.walletHub.Pages.Assignment2.ProfilePage;
import cucumber.api.java.en.Then;
import helpers.TestContext;
import org.testng.Assert;

public class ProfilePageSteps {
    TestContext testContext;
    ProfilePage profilePage;
    CommonUIActions commonUIActions;

    public ProfilePageSteps(TestContext context) {
        testContext = context;
        profilePage = testContext.getWebPageObjectManger().getProfilePageAss2();
        commonUIActions = testContext.getWebPageObjectManger().getCommonActionsScreen();
    }

    @Then("^Verify reviewed star count as <(\\d+)>$")
    public void verifyReviewedStarCountAs(int expectedCount) {
        int actualCount = profilePage.getReviewCount();
        Assert.assertEquals(actualCount, expectedCount, "Verification failed, Expected review count is " + expectedCount + " and actual review count is " + actualCount);
    }

    @Then("^Verify selected dropdownValue as \"([^\"]*)\"$")
    public void verifySelectedDropdownValueAs(String expectedVal) {
        String actualValue = profilePage.getSelectedDropDownValue();
        Assert.assertEquals(actualValue, expectedVal, "Verification failed, Expected review dropdown is " + expectedVal + " and actual review dropdown is " + actualValue);
    }
}
