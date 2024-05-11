package CucumberStepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ecommercepageobject.Cartpage;
import ecommercepageobject.Loginpage;
import ecommercepageobject.Paymentpage;
import ecommercepageobject.Productcatalogpage;
import ecommercepageobject.thankuclass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ssktestcomponents.baseTest;

public class StepDefinitionImpl extends baseTest {
	public Loginpage lp;
	public Productcatalogpage pc;
	public Cartpage cartpg;
	public Paymentpage paypg;
	public thankuclass thankmsg;
	
	
	
	@Given("Login into the Ecommerce Application")
	public void Login_into_the_Ecommerce_Application () throws IOException{
		lp=launchApplication();
		
	}
	
	
	 @Given("^Login with username (.+) and password (.+)$")
	 public void Login_with_username_and_password(String username,String password){
		pc=lp.loginApplication(username,password);
	 }
	 
	
	@When("^added product(.+) to cart$")
	 public void added_product_to_cart(String productName) throws InterruptedException {
		List<WebElement> products=pc.getProductsList();
		//pc.getProductName(pname);
		
		pc.addprodTocart(productName);
	 }
	
	
	 @When("^Check the product(.+) added in cart and submit order$")
	 public void check_product_added_in_cart_submit_order(String productName) {
		pc.clickcartbutton();
			
			Boolean match=cartpg.booleanmatch(productName);
			Assert.assertTrue(match);
			cartpg.checkout();
			paypg.selectcountry("ind");
			
			
			//thankuclass
			paypg.submitbutton();
	 }
	 
	 @Then("{string} message is displayed on Confirmation Page")
	 	public void verify_confirmation_message(String string) {
		 String message=thankmsg.thankordermsg();
			Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			
	 	}
	
	 @Then("{string} message is displayed ")
	 	public void verify_error_message(String string1) {
		 Assert.assertEquals(string1,lp.getErrormessage());
			
	 	}
	
	
}
