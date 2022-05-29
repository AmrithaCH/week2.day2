package week2.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeAssn3 {

	public static void main(String[] args) {
		
		//Set up web driver
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				//load the webpage url
				driver.get("https://acme-test.uipath.com/login");
				//maximise the window
				driver.manage().window().maximize();
				//implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				//Enter email and passw
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
				driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
				//Get title and print
				System.out.println("The title is "+driver.getTitle());
				//Logout
				driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
				//close session
				//driver.close();
				

	}

}
