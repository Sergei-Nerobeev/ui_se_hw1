package edu.nerobeev.uitest;

import edu.nerobeev.core.ui.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class AbsBaseTest {
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
