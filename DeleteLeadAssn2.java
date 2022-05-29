package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeadAssn2 {

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
		// CLick on phone tab
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		//Enter any phone number for search
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1");
		//Click Find Leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//First Resulting Lead ID
		Thread.sleep(2000);
		String firstOccuringLead = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td/div/a")).getText();
		System.out.println("First occuring lead is: "+firstOccuringLead);
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td/div/a")).click();
		//Delete the first occuring lead
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		//Find Leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//Enter captured lead id
		driver.findElement(By.xpath("//label[contains(text(),'Lead ID')]/following-sibling::div/input")).sendKeys(firstOccuringLead);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		//Check if the lead got deleted successfully
		String deleted = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		if(deleted.equals("No records to display"))
		{System.out.println("When entered "+firstOccuringLead+" shows "+deleted+". Hence success");}
		else
		{System.out.println("not deleted successfully");}
		//close browser
		driver.close();
		
		
	}

}
