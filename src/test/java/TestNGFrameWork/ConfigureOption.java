package TestNGFrameWork;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConfigureOption {

	public WebDriver driver;
	@BeforeMethod
	public void openBrowser() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp=new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		driver=new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@Test
	public void loginCredentails() {
		try {
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Alert a1=driver.switchTo().alert();
			a1.accept();
			driver.findElement(By.xpath("//span[text()='Performance']")).click();
			driver.findElement(By.xpath("//span[text()='Configure ']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
