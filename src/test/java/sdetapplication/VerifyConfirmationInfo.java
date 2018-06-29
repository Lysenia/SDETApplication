package sdetapplication;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyConfirmationInfo {

	WebDriver driver;

	@BeforeClass // runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver",
				"/Users/lesia/Documents/selenium dependencies/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.get(
				"https://forms.zohopublic.com/murodil/form/JobApplicationForm/publicrecord/thankyou/HihfWLThDw4rkSV-1q3F2Je3VfCxH-1ATH6Pa0vgxHs");
	}

	@Test

	public void verifyIP() {
		String IPaddress = "IP address: 69.244.83.190";
		String actual = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[6]")).getText();
		assertEquals(actual, IPaddress);
	}

	@Test
	public void verifyEmail() {
		String email = "Email: lesialysiak@gmail.com";
		String actual = driver.findElement(By.xpath("//*[@id=\"richTxtMsgSpan\"]/label/div[11]")).getText();
		assertEquals(actual, email);
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
}
