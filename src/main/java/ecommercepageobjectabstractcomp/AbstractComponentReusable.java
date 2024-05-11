package ecommercepageobjectabstractcomp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ecommercepageobject.Cartpage;

public class AbstractComponentReusable {

	 WebDriver driver;
	 
	 @FindBy(css="[routerlink*='myorders']")
		WebElement ordertbuttonclick;

	public AbstractComponentReusable(WebDriver driver) {
		this.driver=driver;
	}

	public void visibilityofElement(By ele1) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele1));
	}
	
	public void invisibilityofElement(WebElement ele2) throws InterruptedException  {
		Thread.sleep(5000);
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		//wait.until(ExpectedConditions.invisibilityOf(ele2));
	}
	
	public void visibilityofWebelement(WebElement ele3) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele3));
	}
	
	public OrderPage clickorderbutton() {
		ordertbuttonclick.click();
		OrderPage orderp=new OrderPage(driver);
		return orderp;
	}
	
}
