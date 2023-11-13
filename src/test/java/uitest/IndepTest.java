package uitest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndepTest {
	private WebDriver driver;
	private WebDriverWait wait;
	private void creatorObjectDriver(ChromeOptions chromeOptions) {
		driver = new ChromeDriver(chromeOptions);
	}

	@BeforeEach
	public void startUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(12, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://otus.ru/");
		driver.getTitle();
		assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям",driver.getTitle());


	}
	@AfterEach
	public void end() {
		if (driver != null) {
			driver.quit();
		}
	}
	@Test
	public void getOuts() {

//		driver.findElement(By.cssSelector(".sc-mrx253-0")).click(); // button In
		driver.findElement(By.cssSelector(".sc-1r3ji37-0 .sc-yfk21i-0:nth-last-child(10)")).click();


		driver.findElement(By.cssSelector("#__next")).isDisplayed(); // toFrame

		driver.findElement(By.cssSelector("button.sc-11ptd2v-2-Component")).click(); // button Submit
//		driver.findElement(By.cssSelector("")).click();// input email







	}
}
