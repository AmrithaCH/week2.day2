package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadsWithXpath {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//login page
		driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[contains(@class,'Submit')]")).click();
		//CRM/SFA page
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Leads Page click
		driver.findElement(By.linkText("Leads")).click();
		//Create lead page click
		driver.findElement(By.linkText("Create Lead")).click();
		//Fill in mandatory fields and click submit
		//driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Leaf123");
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName' and @class='inputBox']")).sendKeys("Amr123");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName' and @class='inputBox']")).sendKeys("Sri123");
		//dropdown
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='createLeadForm_dataSourceId']"));
		Select dd = new Select(dropdown);
		dd.selectByValue("LEAD_CONFERENCE");		
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();	
		//get the firstname and dropdown selected and print it		
		String firstname = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(firstname);
		String sourceDropdownSelected = driver.findElement(By.id("viewLead_dataSources_sp")).getText();
		System.out.println(sourceDropdownSelected);

	}

}
