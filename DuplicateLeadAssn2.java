package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLeadAssn2 {

	public static void main(String[] args) throws InterruptedException {
		//Set up web driver
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				//load the webpage url
				driver.get("http://leaftaps.com/opentaps/control/main");
				//maximise the window
				driver.manage().window().maximize();
				//implicit wait
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				//login page
				driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("DemoSalesManager");
				driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys("crmsfa");
				driver.findElement(By.xpath("//input[contains(@class,'Submit')]")).click();
				//CRM/SFA page
				driver.findElement(By.linkText("CRM/SFA")).click();
				//Click leads
				driver.findElement(By.linkText("Leads")).click();
				//Find Leads
				driver.findElement(By.linkText("Find Leads")).click();
				//Click on email tab
				driver.findElement(By.xpath("//span[text()='Email']")).click();
				//Enter email and click find
				driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("a");
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				//Click on first occuring lead
				Thread.sleep(2000);
				String firstOccuringLead = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td/div/a")).getText();
				String firstOccuringName = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td[3]/div/a")).getText();
				System.out.println("First occuring lead is: "+firstOccuringLead+" and the name is "+firstOccuringName);
				driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td/div/a")).click();
				//Click on duplicate lead
				driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
				//Click on create
				driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
				//Check the name of the created lead
				String duplicatedLead = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
				if(firstOccuringName.contains(duplicatedLead))
				{System.out.println("Success");}
				else
				{System.out.println("Failure");}
				driver.close();
				

	}

}
