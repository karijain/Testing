package jquery;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class TestJquery {
	
	@Test
	public void testJquery() throws InterruptedException
	{
	
	/*public static void main(String[] args) {
		*/
	
		//System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		ChromeDriverManager.getInstance().setup();
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setBinary("C:\\Users\\karijain\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
		WebDriver driver=new ChromeDriver(chromeOptions);
		driver.get("https://jqueryui.com");
		
		Actions action=new Actions(driver);
		//action.moveToElement(driver.findElement(By.linkText("Contribute"))).build().perform();
		
		//driver.findElement(By.linkText("Code")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Draggable")).click();
		
		driver.switchTo().frame(0);
		
		action.dragAndDropBy(driver.findElement(By.id("draggable")), 189, 142).build().perform();
		
		
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Droppable")).click();
		
		driver.switchTo().frame(0);
		
		action.dragAndDrop(driver.findElement(By.id("draggable")), 
				driver.findElement(By.id("droppable"))).build().perform();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Resizable")).click();
			
		driver.switchTo().frame(0);
		WebElement e = driver.findElement(By.cssSelector("#resizable>div+div+div"));
		action.clickAndHold(e).moveByOffset(200, 100).build().perform();
		
		
		
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Selectable")).click();
		
		
		driver.switchTo().frame(0);
		
		action.clickAndHold(driver.findElement(By.cssSelector("ol>li"))).moveToElement(driver.findElement(By.cssSelector("ol>li+li+li"))).release().build().perform();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Sortable")).click();
		
		
		
		
		Thread.sleep(4000);
		driver.quit();
			
	}
	

}
