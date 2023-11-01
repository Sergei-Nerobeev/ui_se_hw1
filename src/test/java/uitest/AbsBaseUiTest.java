package uitest;

import edu.nerobeev.core.ui.browser.Browser;
import edu.nerobeev.core.ui.browser.BrowserType;
import edu.nerobeev.core.ui.browser.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public abstract class AbsBaseUiTest {
	 	protected SoftAssert assertion;

		@BeforeMethod(alwaysRun = true)
		public void initTest(){
		assertion = new SoftAssert();
		}

		@AfterMethod(alwaysRun = true)
		public void teardown(){
		Browser.getBrowser().quit();
		}

}
