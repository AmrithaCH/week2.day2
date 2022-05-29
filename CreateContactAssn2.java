package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactAssn2 {

	public static void main(String[] args) {

		//Set up web driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//load the webpage url
		driver.get("http://leaftaps.com/opentaps/control/main");
		//maximise the window
		driver.manage().window().maximize();
		//login page
		driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[contains(@class,'Submit')]")).click();
		//CRM/SFA page
		driver.findElement(By.linkText("CRM/SFA")).click();
		//click on Contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//Click on Create Contact
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		//Enter field values
		driver.findElement(By.id("firstNameField")).sendKeys("Amritha");
		driver.findElement(By.id("lastNameField")).sendKeys("Srini");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Ash");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Sri");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("EIE");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Department is EIE");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("amr.kar@gmail.com");
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd = new Select(state);
		dd.selectByVisibleText("New York");
		//Create contact button click
		driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
		System.out.println(driver.getTitle());
		//edit contact
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Important Note");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println(driver.getTitle());
		//close browser
		driver.close();
		
		

	}

}
