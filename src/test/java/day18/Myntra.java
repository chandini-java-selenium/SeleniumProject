package day18;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Myntra
{
	public static void main(String[] args) throws InterruptedException
	{

	  ChromeOptions options=new ChromeOptions();
	  options.addArguments("--disable-notifications");
	  WebDriver driver =new ChromeDriver(options);
	  driver.manage().window().maximize();
	  driver.get("https://www.myntra.com/ ");
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	  Actions actions=new Actions(driver);
	  
	  WebElement menSection=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-group='men' and @class='desktop-main']")));
	  actions.moveToElement(menSection).perform();
	  
	  WebElement jeansLink=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='desktop-categoryLink' and  text()='Jeans']")));
	  jeansLink.click();
	  
	  WebElement LevisFilter=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[.//input[@value='Levis']]")));
	  LevisFilter.click();
	  
      wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("product-base")));	
      
      List<WebElement>Products=driver.findElements(By.className("product-base"));
      
      for(int i=0;i<2;i++)
      {
    	  Products.get(i).click();
    	  Thread.sleep(2000);
    	  
    	  ArrayList<String>tabs=new ArrayList<>(driver.getWindowHandles());
    	  driver.switchTo().window(tabs.get(i));
    	  
    	
    	  WebElement sizeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='size-buttons-buttonContainer']/button[not(@disabled)]")));
          sizeButton.click();
    	  WebElement addTOBag=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'ADD TO BAG')]")));
    	  addTOBag.click();
    	  
    	  System.out.println("product" + (i+1) + "added to bag");
    	  driver.close();
    	  
    	  driver.switchTo().window(tabs.get(0));
    	  
    	  Products=driver.findElements(By.className("product-base"));
      }
      
      System.out.println("Automation Successfull");
      Thread.sleep(2000);
      driver.quit();
    	  
    	  
    	  
      }
	
	
	
	
	
	
	}

