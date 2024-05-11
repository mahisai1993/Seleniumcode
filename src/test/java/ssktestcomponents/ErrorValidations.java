package ssktestcomponents;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ecommercepageobject.Cartpage;
import ecommercepageobject.Loginpage;
import ecommercepageobject.Paymentpage;
import ecommercepageobject.Productcatalogpage;
import ecommercepageobject.thankuclass;
import io.github.bonigarcia.wdm.WebDriverManager;
import ssktestcomponents.baseTest;

public class ErrorValidations extends baseTest {

	@Test(groups= {"errorvalidation"}) //suppose for retry use it as @Test(groups= {"errorvalidation"},retryAnalyzer=Retry.class)
	public void ErrorValidationlogin() throws IOException, InterruptedException {

		lp.loginApplication("saisri@kosagi.com", "Saisri1@1704");
		Assert.assertEquals("Incorrect email or password.",lp.getErrormessage());

}
	@Test
	public void ProductErrorValidation() throws InterruptedException {
		String pname="ZARA COAT 3";
		
		
		//productcatalog page
		
		Productcatalogpage pc=lp.loginApplication("saisri@kosagi.com", "Saisri@1704");
		List<WebElement> products=pc.getProductsList();
		pc.getProductName(pname);
		pc.addprodTocart(pname);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2));
		
	//cart page
	
		Cartpage cartpg=pc.clickcartbutton();
		
		Boolean match=cartpg.booleanmatch("ZARA COAT 3889898878");
		Assert.assertFalse(match);
		
			}
	}
