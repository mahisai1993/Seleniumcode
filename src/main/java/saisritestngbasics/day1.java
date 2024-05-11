package saisritestngbasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day1 {
	@BeforeClass
	public void beforeclass()
	{
	System.out.println("beforeclass case");	
	}
	
	@AfterClass
	public void afterclass()
	{
	System.out.println("afterclass case");	
	}
	
	
	@BeforeTest
	public void firstcase()
	{
	System.out.println("first case executioni day1");	
	}
	
	@BeforeMethod
	public void beforemethod()
	{
	System.out.println("before method case");	
	}
	
	@AfterMethod
	public void aftermethod()
	{
	System.out.println("after method case");	
	}
	
	@Test
	public void Demo()
	{
	System.out.println("hello");	
	}
	
	@Test
	public void Demo1()
	{
	System.out.println("Bye");	
	}
}
