package ecommercepageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ecommercepageobjectabstractcomp.AbstractComponentReusable;

public class Paymentpage extends AbstractComponentReusable {

	WebDriver driver;
	
	public Paymentpage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(xpath="//*[@placeholder='Select Country']")
	WebElement countryname;
	
	By listcountries=By.cssSelector(".ta-results");
	
	
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement countryindia;
	
	
	@FindBy(css=".action__submit")
	WebElement submitbutton;
	
	public void selectcountry(String entercountry) {
		Actions a=new Actions(driver);
		a.sendKeys(countryname, entercountry).build().perform();
		
		visibilityofElement(listcountries);
		
		countryindia.click();
	}
	
	public thankuclass submitbutton() {
		submitbutton.click();
		return new thankuclass(driver);
		
	}
	
	
	
	
	
}
