package edu.nerobeev.page;

import edu.nerobeev.core.ui.element.LocatorType;
import edu.nerobeev.core.ui.element.TextField;
public class ErrorPage {
	//SELECTORS
	private static final  String ERROR_CSS_SELECTOR = "";
	//ELEMENTS
	private final TextField errorHeader = new TextField(LocatorType.CSS, ERROR_CSS_SELECTOR);
	public String getErrorHeader(){
				return errorHeader.getText();
	}
}
