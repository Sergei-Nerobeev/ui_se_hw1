package edu.nerobeev.page;

import edu.nerobeev.core.ui.Browser;

import static edu.nerobeev.config.GlobalParameter.URL;

public class MainPage extends AbsBasePage {

private static final String ENTER_BUTTON_CSS_SELECTOR = "";

public static MainPage open() {
		Browser.getBrowser().open(URL);
		return new MainPage();
}



}
