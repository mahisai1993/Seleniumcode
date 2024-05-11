package saisritestngbasics;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {
	
	
	@BeforeTest
	public void abcorder()
	{
	System.out.println("first case execution in day2");	
	}
	
	@BeforeTest
	public void xyzorder()
	{
	System.out.println("last beforetest case execution in day2");	
	}
	
	@Test
	public void thirdtest()
	{
	System.out.println("good");	
	}
	
}
