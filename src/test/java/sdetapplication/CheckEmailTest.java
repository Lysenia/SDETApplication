package sdetapplication;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckEmailTest {

	WebDriver driver;
	
	String email = "lesialysiak@gmail.com";
	
	@BeforeClass //runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","/Users/lesia/Documents/selenium dependencies/drivers/chromedriver");driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
@Test
	
	public void emailSearch() {
		driver.get("https://mail.google.com");
		//driver.findElement(By.xpath("//input[@id='profileIdentifier']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys((email) + Keys.ENTER);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(("living2017"+ Keys.ENTER));
		//driver.findElement(By.xpath("//div[id='passwordNext']")).click();
		
		String expected = "SDET Job Application #2125";
		String actual = driver.getPageSource();
		
		if(actual.contains(expected)) {
			System.out.println("pass");
		}else {
				System.out.println("fail");
			}
			}
@AfterClass
public void tearDown() throws InterruptedException {
	Thread.sleep(4000);
	driver.quit();
}
		
	



}
