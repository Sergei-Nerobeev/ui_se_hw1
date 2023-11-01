package edu.nerobeev.core.listener;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebDriverListener extends AbstractWebDriverEventListener {
	// вынести часть логирования в этот класс!

	private Logger logger;
//	@Override
//	public void afterNavigateTo(String url, WebDriver driver) {
//
//		logger.info("Driver is opening url: " + url);
//	}
//	@Override
//	public void afterFindBy(By by, WebElement element, WebDriver driver) {
//		logger.info("Try to find element by: " + by);
//	}
//  @Override
//	public void afterClickOn(WebElement element, WebDriver driver) {
//	}

}
