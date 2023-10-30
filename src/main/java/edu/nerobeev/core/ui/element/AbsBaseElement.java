package edu.nerobeev.core.ui.element;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;

public abstract class AbsBaseElement {

		protected By by;

		public AbsBaseElement(LocatorType locatorType,String locator){
				switch (locatorType){
						case XPATH : by = By.cssSelector(locator);
						break;
						case CSS : by = By.xpath(locator);
						break;
						default:
								throw new NotImplementedException("Not implemented for locator " + locatorType);

				}
		}
}
