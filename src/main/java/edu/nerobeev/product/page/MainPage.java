package edu.nerobeev.product.page;

import edu.nerobeev.core.ui.browser.Browser;
import edu.nerobeev.core.ui.element.Button;
import edu.nerobeev.core.ui.element.LocatorType;
import static edu.nerobeev.config.GlobalParameter.URL;
public class MainPage {
	//SELECTORS
private static final String ENTER_BUTTON_CSS_SELECTOR = ".sc-mrx253-0";

 //ELEMENTS
private final Button enterButton = new Button(LocatorType.CSS, ENTER_BUTTON_CSS_SELECTOR);


	public static MainPage open() {
		Browser.getBrowser().open(URL);
		return new MainPage();
}

	public LoginPage pressEnterButton(){
		enterButton.click();
		return new LoginPage();

}



}
