package ssktestcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ecommercepageobject.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
	public WebDriver driver;
	public Loginpage lp;
	//System.getProperty("user.dir") + "//src//main//java//sskresources//globalfile.properties"
	
	
	
	
	public WebDriver initializedriver() throws IOException {
		
		
	Properties prop=new Properties();
	FileInputStream file=new FileInputStream(System.getProperty("user.dir") + "//src//main//java//sskresources//globalfile.properties");
	prop.load(file);
	//for running from maven
	String browsername=System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
	
	//prop.getProperty("browser");
	

		if(browsername.contains("chrome")) {
			//normal mode
			//WebDriverManager.ChromeDriver().setup();
			//driver= new ChromeDriver();
			
			//to run in headless mode
		ChromeOptions options=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if(browsername.contains("headless")) { // if browsername in Jenkins maven command contains headless then run in that mode else normal mode
		options.addArguments("headless");
		
		}
		driver= new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1440,900));//set screenin full screen mode tp opof maximise mode
	}
		
		else if(browsername.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		else if(browsername.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonData(String filepath) throws IOException {
		
		//String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//java//sskdatapackage//Purchaseorder.json"),StandardCharsets.UTF_8);
	
		String jsonContent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		
		
	//convert string to hashmap
		ObjectMapper obj=new ObjectMapper();
		List<HashMap<String, String>> data=obj.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
			});
		return data;
			
	
	
	}

	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports"+testcasename+".png");
		
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports" + testcasename +".png";
		
		
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public  Loginpage launchApplication() throws IOException{
		driver=initializedriver();
		lp=new Loginpage(driver);
		
		lp.gotourl("https://rahulshettyacademy.com/client");
		return lp;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void browserClose() {
		driver.close();
	}
	
	
	

}
