package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAddCart {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		/*1.Load the URL https://www.amazon.in/
			2.search as oneplus 9 pro 
			3.Get the price of the first product
			4. Print the number of customer ratings for the first displayed product
			5. Click the first text link of the first image
			6. Take a screen shot of the product displayed
			7. Click 'Add to Cart' button
			8. Get the cart subtotal and verify if it is correct.
			9.close the browser*/
		
        WebDriverManager.chromedriver().setup();
	    
	    ChromeDriver Driver= new ChromeDriver();
		
		Driver.get("https://www.amazon.in/");
		
		Driver.manage().window().maximize();
		
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Oneplus 9 Pro");
		
		Driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		

		 String Firstprice = Driver.findElement(By.xpath("(//span[@class='a-price-whole'])[3]")).getText();
		
		System.out.println("First Mobile Price :"+Firstprice);
		
		
		WebElement findElement = Driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style']/span)[7]"));
		
		String NumberofRating=findElement.getText();
		
		System.out.println("Number of Rating :"+NumberofRating);
		
		
		
		
		Driver.findElement(By.xpath("(//a[@target='_blank']/span[@class='a-size-medium a-color-base a-text-normal'])[3]")).click();
		
		Set<String> windowHandles = Driver.getWindowHandles();
		
		List<String> NoofWindow= new ArrayList<String>(windowHandles);
		
		Driver.switchTo().window(NoofWindow.get(1));
		
		//get screenshot
		 
		File source = Driver.getScreenshotAs(OutputType.FILE);
		
		File Desc= new File("./screenshots.png");
		
		FileUtils.copyFile(source, Desc);
		
	    //add cart
		
		Driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		
			String Price = Driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-price a-text-bold']/span")).getText();
		
		if(Price.equals(Firstprice)) {
			
			System.out.println("Mobile price is affordable");
		}
		else {
			
			System.out.println("It not affordable");
		}
		
		Driver.close();
	}

}
