package Compatibility_Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//Question 2 - One of the travel websites requires you to automate their Flight Search function.
public class CheckEmail {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://jt-dev.azurewebsites.net/#/SignUp";
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.findElement(By.id("language")).click();
	    String Language = driver.findElement(By.id("ui-select-choices-row-1-0")).getText();
	    System.out.println("First Language in dropdown is "+Language);
	    String Language2 = driver.findElement(By.id("ui-select-choices-row-1-1")).getText();
	    System.out.println("Second Language in dropdown is "+Language2);
	    
	    driver.findElement(By.id("ui-select-choices-row-1-0")).click();
	    driver.findElement(By.id("name")).sendKeys("Ram Abhang");
	    driver.findElement(By.id("orgName")).sendKeys("Abhang Organization");
	    driver.findElement(By.id("singUpEmail")).sendKeys("abhang1@yopmail.com");
	    driver.findElement(By.xpath("//*[@class='black-color ng-binding']")).click();
	    driver.findElement(By.xpath("//*[@class='btn btn-custom btn-block ng-binding']")).click();
	    CheckEmail.smallSleep(20);
	    driver.findElement(By.xpath("//*[@class='alert alert-danger alert-custom']//*[@class='ng-binding']")).isDisplayed();
	    String SuccessMessage = driver.findElement(By.xpath("//*[@class='alert alert-danger alert-custom']//*[@class='ng-binding']")).getText();
	    if(SuccessMessage.contentEquals("A welcome email has been sent. Please check your email.")) {
	    	System.out.println("Welcome email has been sent");
	    }
	    
	    if(!SuccessMessage.contentEquals("A welcome email has been sent. Please check your email.")) {
	    	System.out.println("Welcome email not sent");
	    }
	    
	    driver.close();
	   }
	
	
//Added method for the small wait while page load
public static void smallSleep(int timeout){
		try{
			Thread.sleep(timeout*1000);
		}
		catch(Exception e){	
		}
	
	}
	}
