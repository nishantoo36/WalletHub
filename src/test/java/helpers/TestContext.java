package helpers;
import ObjectManager.WebPageObjectManager;
import runner.AllRunner;

import java.io.IOException;


public class TestContext {
	private WebPageObjectManager webPageObjectManager;
	private AllRunner cucumberWebRunner;
	public TestContext() throws IOException {
		cucumberWebRunner = new AllRunner();
		webPageObjectManager = new WebPageObjectManager(cucumberWebRunner.getWebDriver());
	}
	public WebPageObjectManager getWebPageObjectManger() {
		return webPageObjectManager;
	}
}
