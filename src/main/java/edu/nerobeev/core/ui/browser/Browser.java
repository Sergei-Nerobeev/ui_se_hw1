package edu.nerobeev.core.ui.browser;

import edu.nerobeev.core.ui.element.LocatorType;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static edu.nerobeev.config.GlobalParameter.TIMEOUT;

public class Browser implements WrapsDriver {  // класс-сборщик-коннектор! Работает с Selenium.
	private final WebDriver driver;
	private final WebDriverWait wait;
	private static ThreadLocal<Browser> instance;
	private static Browser browser;

	private Browser() {
		driver = WebDriverFactory.getWebDriver(); //принимает обертку веб-драйвера
		wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)); //принимает новое ожидание с параметрами
	}

	public synchronized static Browser getBrowser() { // не даст зайти одновременно двум потокам в метод
		if (instance.get() == null) {
			instance.set(new Browser());//для каждого потока свой браузер
		}
		return instance.get();
	}

	public void open(String url) { //открывает адрес страницы
		driver.get(url);
	}

	public void toFrame(LocatorType locatorType, String locator) { //метод переключения во фрейм
		By frameLocator = getBy(locatorType, locator);
		waitPresent(frameLocator);
		driver.switchTo().frame(driver.findElement(frameLocator));
	}

	public void defaultContent() { //  метод обертка
		driver.switchTo().defaultContent();
	}

	public void click(By by) { // метод клик по элементу
		waitVisible(by); // ожидание видимости элемента
		ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(by);//ожидание кликабельно
		wait.until(condition).click();
	}
	public void type(By by, String string) { // метод печати в элемент
		waitVisible(by); // ожидание видимости элемента
		driver.findElement(by).sendKeys(string); // печать в элемент
	}
	public String getText(By by){ // метод возврата текста
		waitPresent(by);
		waitVisible(by);
		return driver.findElement(by).getText();
	}

	private void waitVisible(By by) { // метод ожидание видимости элемента
		ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(by);
		wait.until(condition);
	}

	private void waitPresent(By by) { // метод ожидание присутствия элемента (фрейма)
		ExpectedCondition<WebElement> condition = ExpectedConditions.presenceOfElementLocated(by);
		wait.until(condition);
	}

	private By getBy(LocatorType locatorType, String locator) { // метод выбора типа: локатор/селектор
		By by = switch (locatorType) {
			case XPATH -> By.cssSelector(locator);
			case CSS -> By.xpath(locator);
			default -> throw new NotImplementedException("Not implemented for locator " + locatorType);
		};
		return by;
	}

	@Override
	public WebDriver getWrappedDriver() // метод обертка над драйвером
	{
		return driver;
	}

	public void quit() //закрывает драйвер-соединение
	{
		if (instance.get() != null) {
			instance.get().getWrappedDriver().quit();
		}
		instance.remove();
	}
}
