package com.qa.fifa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {

	@Test
	public void validateSearch() {
		// set up chromedriver
		WebDriverManager.chromedriver().setup();
		// create a web driver object
		WebDriver driver = new ChromeDriver();
		// open the url
		driver.get("https://www.google.com");
		// maximize the window
		driver.manage().window().maximize();
		// type in the search box
		driver.findElement(By.name("q")).sendKeys("fifa worldcup 2022");
		// trigger the search
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		//capture the webelement
		WebElement firstLink = driver.findElement(By.xpath("(//div[@class='ofy7ae'])[1]"));
		String actualText = firstLink.getText();
		String expected = "FIFA World Cup Qatar 2022™";
		// Adding Assertion to the Test
		Assert.assertTrue(actualText.equalsIgnoreCase(expected), 
				"Expected " +expected+ " but found >> "+ actualText);
		
		
	}
	
	
	
}
