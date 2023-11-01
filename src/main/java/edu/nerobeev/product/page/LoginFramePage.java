package edu.nerobeev.product.page;

import edu.nerobeev.core.ui.browser.Browser;
import edu.nerobeev.core.ui.element.Button;
import edu.nerobeev.core.ui.element.Input;
import edu.nerobeev.core.ui.element.LocatorType;

public class LoginFramePage {
	//SELECTORS
private static final String FRAME_CSS_SELECTOR = " ";
private static final String EMAIL_INPUT_CSS_SELECTOR = "//*[@name='email']";
private static final String PASSWORD_INPUT_CSS_SELECTOR = "";
private static final String NEXT_BUTTON_CSS_SELECTOR = "";
private static final String SUBMIT_BUTTON_CSS_SELECTOR = "";

	//ELEMENTS
	private final Input emailInput = new Input(LocatorType.XPATH, EMAIL_INPUT_CSS_SELECTOR);
	private final Button nextButton = new Button(LocatorType.CSS, NEXT_BUTTON_CSS_SELECTOR);
	private final Input passwordInput = new Input(LocatorType.CSS, PASSWORD_INPUT_CSS_SELECTOR);
	private final Button submitButton = new Button(LocatorType.CSS, SUBMIT_BUTTON_CSS_SELECTOR);

	public LoginFramePage typeEmail(String email){
//		toFrame();
		emailInput.click();
		emailInput.type(email);
		Browser.getBrowser().defaultContent();
		return this;
	}
	public LoginFramePage clickNextButton(){
		toFrame();
		nextButton.click();
		Browser.getBrowser().defaultContent();
		return new LoginFramePage();
	}
	public LoginFramePage typePassword(String password){
		toFrame();
		passwordInput.type(password);
		Browser.getBrowser().defaultContent();
		return  this;
	}
	public ErrorPage clickSubmitIncorrectLogin(){
		simpleClickSubmit();
		return new ErrorPage();
	}
	public void simpleClickSubmit(){
		toFrame();
		submitButton.click();
		Browser.getBrowser().defaultContent();
	}
	private void toFrame(){ // метод, что бы не писать длинную строчку
		Browser.getBrowser().toFrame(LocatorType.CSS,FRAME_CSS_SELECTOR);
	}



}
