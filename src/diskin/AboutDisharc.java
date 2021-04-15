package diskin;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AboutDisharc {
	public static void main(String[]args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://disharc.org/");
		
		Actions action = new Actions(driver);
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"menu-item-5321\"]/a"));
		action.moveToElement(btn).perform();
		//mouse hover to the services tab
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-5463\"]/a")).click();
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-700)");
		
		driver.findElement(By.xpath("//*[@id=\"slick-slide00\"]/a")).click();
		//clicks on the Dr. Anil Kumar Jha
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,900)");
		Thread.sleep(2000);
		
		String expectedTitle = "Prof. Dr. Anil Kumar Jha – DI Skin Health and Referral Center";
        String actualTitle = "";
		
        actualTitle = driver.getTitle();
		
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
        driver.navigate().back();
        //navigate to the previous page
        
        driver.close();
	}

}
