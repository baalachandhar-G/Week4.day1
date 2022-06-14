package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();
	    
	    ChromeDriver Driver= new ChromeDriver();
		
		Driver.get("http://leaftaps.com/opentaps/control/login");
		
		Driver.manage().window().maximize();
		
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		Driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		Driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		Driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		Driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		Driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		
	//	Driver.findElement(By.xpath("//a[@id='ext-gen618']/img")).click();
		
		String Parentwindows = Driver.getWindowHandle();
		
		Driver.switchTo().window(Parentwindows);
		
		
		
		//Switch to new windows
		
		Driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::img")).click();
		
		Set<String> windowHandles = Driver.getWindowHandles();
		
		List<String> Windows= new ArrayList<String>(windowHandles);
		
		Driver.switchTo().window(Windows.get(1));
		
		
		Driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		Driver.switchTo().window(Parentwindows);
		
		
		//Switch to New windows
		
		Driver.findElement(By.xpath("//input[@id='partyIdTo']/following::img")).click();
		
		Set<String> WindowHandles1= Driver.getWindowHandles();
		
		List<String> Windows2= new ArrayList<String>(WindowHandles1);
		
		Driver.switchTo().window(Windows2.get(1));
		
		
		Driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Driver.switchTo().window(Parentwindows);
		
	
	    Driver.findElement(By.xpath("//a[text()='Merge']")).click();
	    
	    Alert alert = Driver.switchTo().alert();
	    
	    alert.accept();
	    
	    System.out.println("New Title :"+ Driver.getTitle());
	    
	    Driver.close();
		
	}

}
