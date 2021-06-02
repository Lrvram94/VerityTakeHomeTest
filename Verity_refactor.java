package starting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Verity_refactor {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Learning\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		//Typing "Software" in search box and validating the results
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Software");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='gNO89b']")));
		driver.findElement(By.xpath("//input[@class='gNO89b']")).click();
		driver.findElement(By.xpath("//a[@href='https://en.wikipedia.org/wiki/Software']")).click();
		String ActualWikiURL = driver.getCurrentUrl();
		try 
		{
			Assert.assertEquals(ActualWikiURL, TestData.wikipediaURL);
			System.out.println("Search result for 'Software' is Passed");
		}
		catch(AssertionError e) 
		{
			System.out.println("Search result for 'Software' is Failed");
			throw e;
		}
		
		driver.navigate().back();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='gLFyf gsfi']"))).clear();
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Testing");
		driver.findElement(By.xpath("//div[@class='FAuhyb']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'https://www.health.govt.nz/')]")).click();
		String ActualTestURL = driver.getCurrentUrl();
		try 
		{
			Assert.assertEquals(ActualTestURL, TestData.GovtHealthURL);
			System.out.println("Search result for 'Testing' is Passed");
			driver.navigate().back();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'https://www.health.govt.nz/')]")));
			System.out.println("The position of the search result is " + driver.findElement(By.xpath("//a[contains(@href,'https://www.health.govt.nz/')]")).getLocation());
			
	   }
		catch(AssertionError e) 
		{
			System.out.println("Search result for 'Testing' is Failed");
			throw e;
		}
		
		driver.close();

	}

}
