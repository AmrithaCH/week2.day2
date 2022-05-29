package week2.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadAssn2 {

	public static void main(String[] args) throws InterruptedException {

		//Set up web driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//load the webpage url
		driver.get("http://leaftaps.com/opentaps/control/main");
		//maximise the window
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		//Enter first name
		driver.findElement(By.xpath("//label[contains(text(),'Lead ID')]/following::label[contains(text(),'First name')]/following-sibling::div/input")).sendKeys("Akash");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Click on first result
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td/div/a")).click();
		//verify title of page
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equalsIgnoreCase("View Lead | opentaps CRM"))
		{System.out.println("Verified tile and it is: "+title);}
		else
		{System.out.println("Title not matched");}
		//Click Edit 
		driver.findElement(By.linkText("Edit")).click();
		//Update company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("updated name");
		//CLick update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("The updated company name is: "+ companyName);
		//Check if updated name is appearing
		if(companyName.startsWith("updated name"))
		{System.out.println("Verified company name is updated");}
		else
		{System.out.println("Company name not updated properly");}
		driver.close();
		

	}

}
