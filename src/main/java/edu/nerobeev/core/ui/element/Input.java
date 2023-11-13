package edu.nerobeev.core.ui.element;

import edu.nerobeev.core.ui.browser.Browser;

public class Input extends AbsBaseElement{
	public Input(LocatorType locatorType, String locator) {
		super(locatorType, locator);
	}
	// МЕТОДЫ С ОЖИДАНИЕМ СОСТОЯНИЯ
	public void type(String string){ // метод передачи печати в Браузер с ожиданием состояния
		Browser.getBrowser().type(by,string);
	}
	public void click() { //метод клик с ожиданием состояния
		Browser.getBrowser().click(by);
	}


	// МЕТОДЫ БЕЗ ОЖИДАНИЯ СОСТОЯНИЯ

	public void simpleClick() { //метод клик без ожидания состояния
		Browser.getBrowser().simpleClick(by);
	}
	public void simpleType(String string){ // метод передачи печати в Браузер без ожидания состояния
		Browser.getBrowser().simpleType(by,string);
	}
}
