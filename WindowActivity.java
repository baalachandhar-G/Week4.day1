package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		    WebDriverManager.chromedriver().setup();
		    
		    ChromeOptions Options=new ChromeOptions();
		    Options.addArguments("--disable-notifications");
		    
		   ChromeDriver Driver= new ChromeDriver();
			
			Driver.get("https://www.irctc.co.in/nget/train-search");
			
			Driver.manage().window().maximize();
			
			Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			Driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Driver.findElement(By.linkText("FLIGHTS")).click();
			
			Set<String> windows = Driver.getWindowHandles();
			
			List<String> lister= new ArrayList<String>(windows);
			
			Driver.switchTo().window(lister.get(1));
			
			String title = Driver.getTitle();
			
			System.out.println(title);
			
			
	}

}
