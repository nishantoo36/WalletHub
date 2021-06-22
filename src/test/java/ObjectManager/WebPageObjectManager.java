package ObjectManager;


import com.walletHub.Pages.Assignment1.NewsFeed;
import com.walletHub.Pages.Assignment2.*;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;

public class WebPageObjectManager extends AbstractTestNGCucumberTests {
    public WebDriver driver;
    public CommonUIActions commonUIActionsAss2;
    public HomePage homePageAss2;
    public LoginPage loginPageAss2;
    public ProfilePage profilePageAss2;
    public DashboardPage dashboardPageAss2;
    public com.walletHub.Pages.Assignment1.HomePage homePageAss1;
    public NewsFeed newsFeedAss1;


    public WebPageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public CommonUIActions getCommonActionsScreen() {
        return (commonUIActionsAss2 == null) ? commonUIActionsAss2 = new CommonUIActions(driver) : commonUIActionsAss2;
    }

    public HomePage getHomePageAss2() {
        return (homePageAss2 == null) ? homePageAss2 = new HomePage(driver) : homePageAss2;
    }

    public com.walletHub.Pages.Assignment1.HomePage getHomePageAss1() {
        return (homePageAss1 == null) ? homePageAss1 = new com.walletHub.Pages.Assignment1.HomePage(driver) : homePageAss1;
    }

    public LoginPage getLoginPageAss2() {
        return (loginPageAss2 == null) ? loginPageAss2 = new LoginPage(driver) : loginPageAss2;
    }

    public ProfilePage getProfilePageAss2() {
        return (profilePageAss2 == null) ? profilePageAss2 = new ProfilePage(driver) : profilePageAss2;
    }

    public DashboardPage getDashboardPageAss2() {
        return (dashboardPageAss2 == null) ? dashboardPageAss2 = new DashboardPage(driver) : dashboardPageAss2;
    }

    public NewsFeed getNewsFeedAss1() {
        return (newsFeedAss1 == null) ? newsFeedAss1 = new NewsFeed(driver) : newsFeedAss1;
    }
}
