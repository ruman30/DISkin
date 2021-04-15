package diskin;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class teleHealthCommunity {
	
	public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
   		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://disharc.org/");
			
		Actions action = new Actions(driver);
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"menu-item-5348\"]/a"));
		action.moveToElement(btn).perform();
		//mouse hover to the services tab
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-5349\"]/a")).click();
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//scrolling to the bottom of the page
		
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//div/div[1]/div/a[5]/img")).click();
				
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id=\"elementor-lightbox-slideshow-single-img\"]/div/div[1]/i")).click();
		
		String expectedTitle = "Tele-health And Community – DI Skin Health and Referral Center";
        String actualTitle = "";
		
        actualTitle = driver.getTitle();
		
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
		driver.close();
	}
}

      