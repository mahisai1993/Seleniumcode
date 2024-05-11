package ecommercepageobjectabstractcomp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ecommercepageobjectabstractcomp.AbstractComponentReusable;

public class OrderPage extends AbstractComponentReusable {

	WebDriver driver;
	
	public OrderPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(xpath="//tr/td[2]")
	List<WebElement> orderproducts;
	
	public Boolean verifyOrderpagedisplay(String pname) {
		Boolean matchorder=orderproducts.stream().anyMatch(a->a.getText().equalsIgnoreCase(pname));
		return matchorder;
			
	}
	
	
	
	
}
