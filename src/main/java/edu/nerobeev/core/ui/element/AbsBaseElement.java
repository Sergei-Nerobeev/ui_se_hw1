package edu.nerobeev.core.ui.element;

import edu.nerobeev.core.ui.browser.Browser;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;

public abstract class AbsBaseElement {

		protected By by;

		public AbsBaseElement(LocatorType locatorType,String locator){
				switch (locatorType){
						case XPATH : by = By.xpath(locator);
						break;
						case CSS : by = By.cssSelector(locator);
						break;
						default:
								throw new NotImplementedException("Not implemented for locator " + locatorType);

				}
		}
		public String getText(){
			return Browser.getBrowser().getText(by);
		}
}
