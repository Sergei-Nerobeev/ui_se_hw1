package edu.nerobeev.core.ui.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static edu.nerobeev.config.GlobalParameter.BROWSER;


public final class WebDriverFactory {

	public static WebDriver getWebDriver(){
		WebDriver webDriver;
		Logger logger = LogManager.getLogger();
		logger.info("Starting webDriver..");
		webDriver= switch (BROWSER) {
			case BrowserType.CHROME -> {
				WebDriverManager.chromedriver().setup();
				yield new ChromeDriver();
			}
			case BrowserType.FIREFOX -> {
				WebDriverManager.firefoxdriver().setup();
				yield new FirefoxDriver();
			}
			case BrowserType.SAFARI -> {
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
