package edu.nerobeev.core.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static edu.nerobeev.config.GlobalParameter.TIMEOUT;

public class Browser implements WrapsDriver {
		private WebDriver driver;
		private WebDriverWait wait;
		private static ThreadLocal<Browser> instance;
		private static Browser browser;
		private Browser() {
			driver = WebDriverFactory.getWebDriver();
			wait = new WebDriverWait(driver, Duration.ofMillis(TIMEOUT));
		}

		public synchronized static Browser getBrowser() { //не даст зайти одновременно двум потокам в метод
				if(instance.get() == null) {
						instance.set(new Browser());//для каждого потока свой браузер
				}
				return instance.get();
		}
		public void open(String url) {
		driver.get(url);
		}
		public void quit()
		{
				if (instance.get() != null)
				{
						instance.get().getWrappedDriver().quit();
				}
				    instance.remove();
		}
		public void click(By by){

		}
		@Override
		public WebDriver getWrappedDriver()
		{
				return driver;
		}
}
