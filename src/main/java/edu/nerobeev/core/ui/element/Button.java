package edu.nerobeev.core.ui.element;

import edu.nerobeev.core.ui.browser.Browser;

public class Button extends AbsBaseElement {

		public Button(LocatorType locatorType, String locator){ // метод выбора кнопки
				super(locatorType, locator);
		}

		public void click() { //метод клик по кнопке
				Browser.getBrowser().click(by);
		}
}
