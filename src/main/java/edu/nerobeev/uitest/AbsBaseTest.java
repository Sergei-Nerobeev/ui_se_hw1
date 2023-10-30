package edu.nerobeev.uitest;


import edu.nerobeev.core.ui.WebDriverFactory;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbsBaseTest {
		protected WebDriver webDriver;
		protected SoftAssertions assertions;

		@BeforeMethod(alwaysRun = true)
		public void initTest(){
				webDriver = WebDriverFactory.getWebDriver();
				assertions = new SoftAssertions();
		}
		@AfterMethod(alwaysRun = true)
				public void teardown(){
						webDriver.quit();
				}

}
