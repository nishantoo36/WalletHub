package stepFiles.Assignment2;



import com.walletHub.Pages.Assignment2.CommonUIActions;
import com.walletHub.Pages.Assignment2.DashboardPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.TestContext;
import org.testng.Assert;


public class DashboardSteps {
    TestContext testContext;
    DashboardPage dashboardPage;
    CommonUIActions commonUIActions;

    public DashboardSteps(TestContext context) {
        testContext = context;
        dashboardPage = testContext.getWebPageObjectManger().getDashboardPageAss2();
        commonUIActions = testContext.getWebPageObjectManger().getCommonActionsScreen();
    }

    @When("^user give <(\\d+)> star review$")
    public void userGiveReview(int reviewCount) {
        dashboardPage.selectOnReviewStar(reviewCount,false);
    }


    @When("^user hover on <(\\d+)> star$")
    public void userHoverOnStar(int reviewCount) {
        dashboardPage.hoverOnStar(reviewCount);

    }

    @Then("^verify that first <(\\d+)> stars inside get lit up when you hover over on <(\\d+)> one star$")
    public void verifyThatFirstStarsInsideGetLitUpWhenYouHoverOverOnOneStar(int expectedCount,int count) {
        int actual= dashboardPage.getLitUpStarCountWhenHover();
        Assert.assertEquals(actual,expectedCount,"Verification failed, Actual lit up star count is "+actual+" and expected is "+expectedCount);
    }

    @Then("^verify that <(\\d+)> star review displayed on write review form$")
    public void verifyThatStarReviewDisplayedOnWriteReviewForm(int expectedCount) {
        int actual= dashboardPage.getLitUpStarCountOnReviewForm();
        Assert.assertEquals(actual,expectedCount,"Verification failed, Actual lit up star count is "+actual+" and expected is "+expectedCount);

    }

    @When("^user select health insurance from drop down \"([^\"]*)\" on review form$")
    public void userSelectHealthInsuranceFromDropDownOnReviewForm(String dropDownVal) throws Throwable {
        dashboardPage.selectValueInDropDown(dropDownVal);
    }

    @When("^user write review as \"([^\"]*)\"$")
    public void userWriteReviewAs(String review) throws Throwable {
        dashboardPage.writeReview(review);
    }

    @When("^user submit review form$")
    public void userSubmitReviewForm() {
        dashboardPage.submitForm();
    }

    @When("^user click on profile$")
    public void userClickOnProfile() {
        commonUIActions.selectProfile();
    }


}
