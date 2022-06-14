package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();
	    
	    ChromeDriver Driver= new ChromeDriver();
		
		Driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		Driver.manage().window().maximize();
		
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Driver.switchTo().frame("frame1");
		
		Driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("Selenium");
		
		Driver.switchTo().frame("frame3");
		
		Driver.findElement(By.xpath("//input[@id='a']")).click();
		
		
		
		Driver.switchTo().defaultContent();
		
		Driver.switchTo().frame("frame2");
		
		WebElement findElement = Driver.findElement(By.id("animals"));
		
		Select newSlect= new Select(findElement);
		
		newSlect.selectByVisibleText("big baby cat");
		
		Driver.close();
	}

}
