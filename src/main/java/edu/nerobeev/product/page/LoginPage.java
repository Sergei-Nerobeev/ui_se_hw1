package edu.nerobeev.product.page;

import edu.nerobeev.core.ui.browser.Browser;
import edu.nerobeev.core.ui.element.Button;
import edu.nerobeev.core.ui.element.Input;
import edu.nerobeev.core.ui.element.LocatorType;

public class LoginPage {
	//SELECTORS
private static final String FRAME_CSS_SELECTOR = "";
private static final String EMAIL_INPUT_CSS_LOCATOR = "input[name=email]";
private static final String PASSWORD_INPUT_CSS_SELECTOR = ".sc-rq8xzv-4.bAGBNK";
private static final String NEXT_BUTTON_CSS_SELECTOR = "button.sc-9a4spb-0.gYNtqF";
private static final String SUBMIT_BUTTON_CSS_SELECTOR = "";

	//ELEMENTS

	private final Input emailInput = new Input(LocatorType.CSS, EMAIL_INPUT_CSS_LOCATOR);
	private final Button nextButton = new Button(LocatorType.CSS, NEXT_BUTTON_CSS_SELECTOR);
	private final Input passwordInput = new Input(LocatorType.CSS, PASSWORD_INPUT_CSS_SELECTOR);
	private final Button submitButton = new Button(LocatorType.CSS, SUBMIT_BUTTON_CSS_SELECTOR);

	public LoginPage typeEmail(String email){
		emailInput.click();
		emailInput.type(email);
		Browser.getBrowser().defaultContent();
		return this;
	}
	public LoginPage typePassword(String password){
//		toFrame();
		passwordInput.type(password);
		Browser.getBrowser().defaultContent();
		return  this;
	}
	public ErrorPage clickSubmitIncorrectLogin(){
		simpleClickSubmit();
		return new ErrorPage();
	}
	public void simpleClickSubmit(){
		submitButton.click();
		Browser.getBrowser().defaultContent();
	}
	private void toFrame(){ // метод, что бы не писать длинную строчку
		Browser.getBrowser().toFrame(LocatorType.CSS,FRAME_CSS_SELECTOR);
	}



}
