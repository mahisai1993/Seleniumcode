package sskpackageframewrk;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ecommercepageobject.Cartpage;
import ecommercepageobject.Loginpage;
import ecommercepageobject.Paymentpage;
import ecommercepageobject.Productcatalogpage;
import ecommercepageobject.thankuclass;
import ecommercepageobjectabstractcomp.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import ssktestcomponents.Retry;
import ssktestcomponents.baseTest;

public class Submitordertest extends baseTest {
	String pname="ZARA COAT 3";
	
	@Test(dataProvider="getData1", groups="Purchase")
	//public void submitOrder(String emaildata,String passdata,String pname) throws IOException, InterruptedException {
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		
		
		//productcatalog page
		
		//Productcatalogpage pc=lp.loginApplication(emaildata,passdata);
		Productcatalogpage pc=lp.loginApplication(input.get("emaildata"),input.get("passdata"));
		
		List<WebElement> products=pc.getProductsList();
		//pc.getProductName(input.get("product"));
		pc.addprodTocart(input.get("product"));
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		
	//cart page
	
		Cartpage cartpg=pc.clickcartbutton();
		
		Boolean match=cartpg.booleanmatch(input.get("product"));
		Assert.assertTrue(match);
		
		//payment page
		
		Paymentpage paypg=cartpg.checkout();
		paypg.selectcountry("ind");
		
		
		//thankuclass
		thankuclass thankmsg=paypg.submitbutton();
		String message=thankmsg.thankordermsg();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
	
	//To verify zaracoat is present in orders page
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderedProductVerification() {
		Productcatalogpage pc=lp.loginApplication("saisri@kosagi.com", "Saisri@1704");
		OrderPage op=pc.clickorderbutton();
		
		Assert.assertTrue(op.verifyOrderpagedisplay(pname));
	
	}
	
	
	
	//using parameters but becomes difficult if there are 100 parameters
	/*
	public Object[][] getData() {
		//Object[][] objects = new Object[][]= {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"},{"saisri@kosagi","Saisri@1704","ZARA COAT 3"}};
		return new Object[][] {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"},{"saisri@kosagi.com","Saisri@1704","ADIDAS ORIGINAL"}};
	}
	*/
	
	@DataProvider
	public Object[][] getData1() throws IOException {
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("emaildata", "anshika@gmail.com");
		map.put("passdata", "Iamking@000");
		map.put("product", "ADIDAS ORIGINAL");
		//map.put("product", "ZARA COAT 3");
		
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("emaildata", "saisri@kosagi.com");
		map1.put("passdata", "Saisri@1704");
		map1.put("product", "ZARA COAT 3");
		//map1.put("product", "ADIDAS ORIGINAL");
		return  new Object[][] {{map},{map1}};
		
		//getJsonData(System.getProperty("user.dir") + "//src//test//java//sskdatapackage//Purchaseorder.json");
		
		//List<HashMap<String, String>> data=getJsonData(System.getProperty("user.dir") + "//src//main//java//sskresources//globalfile.properties");
		
		
		
		//return new Object[][] {{data.get(0)},{data.get(1)}};
		
		
	}

}
