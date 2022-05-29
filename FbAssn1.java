package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FbAssn1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("TestAmr");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("AmrLast");
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input")).sendKeys("amritha.karthick@gmail.com");
		driver.findElement(By.xpath("//div[text()='Re-enter email address']/following-sibling::input")).sendKeys("amritha.karthick@gmail.com");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("9884806675");
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select dd = new Select(day);
		dd.selectByVisibleText("11");
		
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select dd1 = new Select(month);
		dd1.selectByVisibleText("Aug");
		
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select dd2 = new Select(year);
		dd2.selectByVisibleText("1991");
		
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();
		driver.findElement(By.xpath("//button[text()='Sign Up'][@name='websubmit']")).click();

	}

}
