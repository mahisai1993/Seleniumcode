package ecommercepageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommercepageobjectabstractcomp.AbstractComponentReusable;

public class Productcatalogpage extends AbstractComponentReusable {

	WebDriver driver;
	
	public Productcatalogpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement userid=driver.findElement(By.id("userEmail"));
	
	//page factory
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By listproducts=By.cssSelector(".mb-3");
	By addtocartproduct=By.cssSelector(".card-body button:last-of-type");
	By toastmessage=By.cssSelector("#toast-container");
	
	@FindBy(css=".ng-animating")
	WebElement animationspin;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement addcartbuttonclick;
	
	
	
	public List<WebElement> getProductsList() {
		visibilityofElement(listproducts);
		return products;
		
	}
	
	public WebElement getProductName(String pname) {
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(pname)).findFirst().orElse(null);
		return prod;
	}
	
	public void addprodTocart(String pname) throws InterruptedException {
		
		WebElement prod=getProductName(pname);
		prod.findElement(addtocartproduct).click();
		
		visibilityofElement(toastmessage);
		invisibilityofElement(animationspin);
	
	}
	
	public Cartpage clickcartbutton() {
		addcartbuttonclick.click();
		Cartpage cartpg=new Cartpage(driver);
		return cartpg;
	}
	
	
	
	
}
