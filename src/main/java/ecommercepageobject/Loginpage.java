package ecommercepageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommercepageobjectabstractcomp.AbstractComponentReusable;

public class Loginpage extends AbstractComponentReusable {

	WebDriver driver;
	
	public Loginpage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement userid=driver.findElement(By.id("userEmail"));
	
	//page factory
	@FindBy(id="userEmail")
	WebElement userid;
	
	@FindBy(id="userPassword")
	WebElement pass;
	
	
	@FindBy(css=".login-btn")
	WebElement loginbutton;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement loginerrormsg;
	
	
	public Productcatalogpage loginApplication(String email, String passw) {
		userid.sendKeys(email);
		pass.sendKeys(passw);
		loginbutton.click();
		
		Productcatalogpage pc=new Productcatalogpage(driver);
		return pc;
	}
	
	public void gotourl(String urlname) {
		driver.get(urlname);
		driver.manage().window().maximize();
	}
	
	
	public String getErrormessage() {
		visibilityofWebelement(loginerrormsg);
		
		return loginerrormsg.getText();
		
	}
	
	
}
