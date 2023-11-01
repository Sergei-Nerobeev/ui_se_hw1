package edu.nerobeev.core.ui.element;

import edu.nerobeev.core.ui.browser.Browser;

public class Input extends AbsBaseElement{
	public Input(LocatorType locatorType, String locator) {
		super(locatorType, locator);
	}
	public void type(String string){ // метод передачи печати в Браузер
		Browser.getBrowser().type(by,string);
	}
	public void click() { //метод клик
		Browser.getBrowser().click(by);
	}
}
