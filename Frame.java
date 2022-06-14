package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

WebDriverManager.chromedriver().setup();
		
		ChromeDriver Driver= new ChromeDriver();
		
		Driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		
		Driver.manage().window().maximize();
		
		//WebElement findElement = Driver.findElement(By.xpath("//div[@id='container']/div[@id='iframecontainer']"));)
		
		Driver.switchTo().frame("iframeResult");
		
		
	    Driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
	    Alert alert = Driver.switchTo().alert();
	    
	    alert.sendKeys("Baalachandhar");
	    
	    alert.accept();
	    
	    String Name = Driver.findElement(By.id("demo")).getText();
	    
	    if(Name.contains("Baalachandhar")) {
	    	
	    	System.out.println("Corret Name");
	    	
	    }else {
	    	System.out.println("Wrong Name");
	    }
	}

}
