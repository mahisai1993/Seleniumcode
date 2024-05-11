package ecommercepageobject;

import static org.testng.Assert.assertTrue;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class ecommercemain {

	public static void main(String[] args) throws InterruptedException {
		
		String pname="ZARA COAT 3";
		
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		
		//login page
		Loginpage lp=new Loginpage(driver);
		lp.gotourl("https://rahulshettyacademy.com/client");
		
		
		//productcatalog page
		
		Productcatalogpage pc=lp.loginApplication("saisri@kosagi.com", "Saisri@1704");
		
		
		
		
		List<WebElement> products=pc.getProductsList();
		pc.getProductName(pname);
		pc.addprodTocart(pname);
		
		
		
		
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		
	//cart page
	
		Cartpage cartpg=pc.clickcartbutton();
		
		Boolean match=cartpg.booleanmatch(pname);
		Assert.assertTrue(match);
		
		
		
		//payment page
		
		Paymentpage paypg=cartpg.checkout();
		paypg.selectcountry("ind");
		
		
		//thankuclass
		thankuclass thankmsg=paypg.submitbutton();
		String message=thankmsg.thankordermsg();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		}

}
