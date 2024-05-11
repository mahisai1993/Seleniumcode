package saisritestngbasics;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class day4 {
	@Test
	public void WebCarloan() {
		System.out.println("WebCarloan");
	}
	
@Test(groups= {"Smokecase"})
public void MobileCarloan() {
	System.out.println("WebCarloan");
}

@Test
public void APICarloan() {
	System.out.println("WebCarloan");
}

@AfterSuite

public void aftresuitecase() {
	System.out.println("After suite case");
}
}
