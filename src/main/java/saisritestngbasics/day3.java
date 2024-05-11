package saisritestngbasics;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class day3 {
	
	
	
	@AfterTest
	public void lastcase() {
		System.out.println("last case execution");
	}
	
	
	@AfterTest
	public void lastcase1() {
		System.out.println("last case execution in same day");
	}

@Test(groups= {"Smokecase"})
	public void WebHomeloan() {
		System.out.println("WebHomeloan");
	}
	
@Test
public void MobileHomeloan() {
	System.out.println("MobileHomeloan");
}

@Test
public void APIHomeloan() {
	System.out.println("APIHomeloan");
}


@BeforeSuite
public void beforesuitecase() {
	System.out.println("Suite 1st case");
}

}
