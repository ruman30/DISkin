package diskin;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class appointment {
	public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
   		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://disharc.org/#/authentication");
			
		driver.findElement(By.xpath("//*[@id=\"menu-item-5322\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"appointmentDataForm\"]/div/div[1]/div[2]/div/div/div/div[2]/button[2]/i")).click();
		driver.findElement(By.xpath("//*[@id=\"appointmentDataForm\"]/div/div[1]/div[2]/div/div/div/div[2]/button[2]/i")).click();
		driver.findElement(By.xpath("//*[@id=\"appointmentDataForm\"]/div/div[1]/div[2]/div/div/div/div[1]/div/div[7]/div/div/div/img")).click();
		
		js.executeScript("window.scrollBy(0,500)");
		
		Select dropDown = new Select(driver.findElement(By.id("appointmentDataForm")));
		dropDown.selectByVisibleText("OPD");
		
//		driver.close();
	}
}
