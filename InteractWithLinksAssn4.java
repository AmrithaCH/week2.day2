package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithLinksAssn4 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/Link.html");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		WebElement link = allLinks.get(0);
		link.click();
		driver.navigate().back();
		List<WebElement> allLinks1 = driver.findElements(By.tagName("a"));
		System.out.println(allLinks1.size());
		WebElement secondLink = allLinks1.get(1);

		System.out.println(secondLink.getAttribute("href"));

		

		for(int i = 0; i<allLinks.size(); i++)
		{List<WebElement> allLinks2 = driver.findElements(By.tagName("a"));
			allLinks2.get(i).click();
			String title = driver.getTitle();
			if(title.contains("404"))
			{System.out.println(i+ " Broken");}
			else
			{System.out.println(i+ " Not broken");}
			driver.navigate().back();
			
		}
	}
}
