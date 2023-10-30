package edu.nerobeev.core.ui.element;

import edu.nerobeev.core.ui.Browser;

public class Button extends AbsBaseElement {


		public Button(LocatorType locatorType, String locator)
		{
				super(locatorType, locator);
		}

		public void click() {
				Browser.getBrowser().click(by);
		}
}
