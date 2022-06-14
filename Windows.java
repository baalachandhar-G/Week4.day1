package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();
        
        ChromeOptions Options= new ChromeOptions();
        
        Options.addArguments("--disable-notification");
	    
	    ChromeDriver Driver= new ChromeDriver();
		
		Driver.get("http://www.leafground.com/pages/Window.html");
		
		Driver.manage().window().maximize();
		
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String ParentWindows = Driver.getWindowHandle();
		
		
		
		
		
		
		Driver.findElement(By.xpath("//button[@id='home']")).click();
		
		Set<String> windowHandles = Driver.getWindowHandles();
		
		List<String> Window= new ArrayList<String>(windowHandles);
		
		Driver.switchTo().window(Window.get(1));
		
		String Newtitle = Driver.getTitle();
		
		System.out.println("New Windows Title :"+Newtitle);
		
		Driver.switchTo().window(ParentWindows);
		
		
		
		Driver.findElement(By.xpath("//button[@onclick='openWindows()']")).click();
		
        Set<String> windowHandles1 = Driver.getWindowHandles();
		
		List<String> Window1= new ArrayList<String>(windowHandles1);
		
		Driver.switchTo().window(Window1.get(1));
		
		String SecondTitle = Driver.getTitle();
		
		  System.out.println("Second windows Title :"+SecondTitle);
		
		  Driver.findElement(By.partialLinkText("Home")).click();
		
		   Set<String> windowHandles2 = Driver.getWindowHandles();
			
			List<String> Window2= new ArrayList<String>(windowHandles2);
			
			Driver.switchTo().window(Window2.get(1));
			
			String ParentTitleName = Driver.getTitle();
			
			System.out.println("Parenttitle :"+ParentTitleName);
			
			
			
			
			Driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
			
            Set<String> windowHandles3 = Driver.getWindowHandles();
			
			List<String> Window3= new ArrayList<String>(windowHandles3);
			
			Driver.switchTo().window(Window3.get(1));
			
			String ThirdTitle = Driver.getTitle();
			
			System.out.println("Title :"+ThirdTitle);			
			
			Driver.switchTo().window(ParentTitleName);
			
			Driver.quit();
			
			
		}	
		
	}


