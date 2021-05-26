package starting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class codingTestVerity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Learning\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Software");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='gNO89b']")));
		driver.findElement(By.xpath("//input[@class='gNO89b']")).click();
		String wikipediaURL = "https://en.wikipedia.org";
		List <WebElement> softwareResults = driver.findElements(By.xpath("//div[@class='TbwUpd NJjxre']"));
		for (WebElement softwareResult : softwareResults)
		  {
			 if (softwareResult.getText().contains(wikipediaURL))
			 //if (softwareResult.getText().contains("https://en.wikipedia.org"))
			   {
				  System.out.println("The first search result displayed for keyword 'Software' is Wikipedia");
				  break;
				   
			   }
			 
		  }
		// typing "Testing" and validating the result with health.co.nz
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).clear();
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Testing");
		driver.findElement(By.xpath("//div[@class='FAuhyb']")).click();
		String ExpectedURL = "https://www.health.govt.nz";
		List<WebElement> testingresults = driver.findElements(By.xpath("//cite[@class='iUh30 Zu0yb qLRx3b tjvcx']"));
		for (WebElement testingresult : testingresults) 
		{

			if (testingresult.getText().contains(ExpectedURL))
			{
				System.out.println("health.co.nz website is displayed in search results");
				System.out.println("The position of the search result is " + testingresult.getLocation());
				break;
			}
		}
		driver.close();

	}

}
