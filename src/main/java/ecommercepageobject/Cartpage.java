package ecommercepageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommercepageobjectabstractcomp.AbstractComponentReusable;

public class Cartpage extends AbstractComponentReusable {

	WebDriver driver;
	
	public Cartpage(WebDriver driver){
		super(driver);
		
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement userid=driver.findElement(By.id("userEmail"));
	
	//page factory
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutbutton;
	
	
	
	public Boolean booleanmatch(String pname) {
		Boolean match=cartproducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(pname));
		return match;
		
	}
	
	public Paymentpage checkout() {
		checkoutbutton.click();
		Paymentpage pay=new Paymentpage(driver);
		return pay;
		
		
	}
	
}
