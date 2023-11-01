package edu.nerobeev.core.ui.browser;

import edu.nerobeev.core.listener.WebDriverListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import static edu.nerobeev.config.GlobalParameter.BROWSER;

public final class WebDriverFactory {

	public static WebDriver getWebDriver(){
		WebDriver webDriver;
		Logger logger = LogManager.getLogger();
		logger.info("Starting webDriver..");

		webDriver = switch (BROWSER) {
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
		logger.info("Web driver started");
		webDriver.manage().window().maximize();

    logger.info("Try to add listener");
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(webDriver);
		eventFiringWebDriver.register(new WebDriverListener());
		webDriver = eventFiringWebDriver;
		logger.info("Listener registered");

		logger.info("Web driver configured");
		return webDriver;
	}

 private WebDriverFactory(){

 }

}
