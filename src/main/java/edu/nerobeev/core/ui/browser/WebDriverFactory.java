package edu.nerobeev.core.ui.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import static edu.nerobeev.config.GlobalParameter.BROWSER;
import static edu.nerobeev.config.GlobalParameter.TIMEOUT;

public final class WebDriverFactory {

	public static WebDriver getWebDriver(){
		WebDriver webDriver;
		webDriver= switch (BROWSER) {
			case CHROME -> {
				WebDriverManager.chromedriver().setup();
				yield new ChromeDriver();
			}
			case FIREFOX -> {
				WebDriverManager.firefoxdriver().setup();
				yield new FirefoxDriver();
			}
			case SAFARI -> {
				WebDriverManager.safaridriver().setup();
				yield new SafariDriver();
			}
			default -> throw new NotImplementedException("Not implemented for " + BROWSER);
		};
/*
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMEOUT));
*/
		webDriver.manage().window().maximize();
		return webDriver;
	}
 private WebDriverFactory(){

 }

}
