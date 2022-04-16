package unoSquare.UnoSquare;

import org.testng.annotations.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class AutomationPractice extends Base{
	
   @BeforeClass
  public void launchUrl() {
	   
	   setupBrowser("Chrome" , "https://www.unosquare.com");
	   
   }

  @Test (priority=1)
  public void verifyPageTitle() {
	  
	    driver.manage().window().maximize();
	    
	    WebElement Industries=	driver.findElement(By.xpath("//a[@class='nav-link'][normalize-space()='Industries']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(Industries);
		System.out.println("on industry next to click tech");
		
		
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.xpath("//a[@class='nav-link drop-link'][normalize-space()='High Tech']"));
		
		//To mouseover on sub menu
		
		actions.moveToElement(subMenu);

		//build()- used to compile all the actions into a single step 
		actions.click().build().perform();
		
		System.out.println("performed hovering on -Industries and clicking on -Tech ");
		
		
		
		boolean expertiesTitle = driver.findElement(By.xpath("//*[contains(text(),'Industry expertise')]")).isDisplayed();
		
		if (expertiesTitle == true) {
			System.out.println("Title is present");}
		
			else {
				System.out.println("Title is not present");
			}
		}	

  @Test (priority=2)
  
  public void validateSubmitBtn() throws InterruptedException {
	
	  
	 driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();
	 
	 driver.findElement(By.xpath("//input[@id='name-2a32df81-981f-4329-b943-9f2e76efe5f0']")).sendKeys("practice test");
	 driver.findElement(By.xpath("//input[@id='email-2a32df81-981f-4329-b943-9f2e76efe5f0']")).sendKeys("test@unoSquare.com");
	 
	 driver.findElement(By.xpath("//input[@value='Submit']")).click();
	 
	 Thread.sleep(20000);
	 
  }
   @AfterClass 
  
  public void tearDown() {
	  
	  driver.close();
	  
  }
  

}
