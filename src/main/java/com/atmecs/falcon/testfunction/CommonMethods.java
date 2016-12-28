package com.atmecs.falcon.testfunction;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;
import java.util.Properties;

import org.codehaus.jettison.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.falcon.automation.util.parser.JsonParser;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.jawbone.utility.Constants;

public class CommonMethods implements Constants
{

	JsonParser par=new JsonParser();
	Properties locators=null;
	public AppiumDriver<MobileElement> driver;
	
	/*
	 * Constructor for getting driver and property object from main script
	 */
	public CommonMethods(AppiumDriver<MobileElement> driver, Properties prop)
	{
		locators=prop;
		this.driver=driver;
	}

	/*
	 * Method to log in to application
	 */
	public void	testLogin(org.codehaus.jettison.json.JSONObject tesdata,String emailid,String pass) throws Exception
     {
		    String emailAddress=emailid;
		    String password=pass;
		    waitForVisible(driver, By.id(locators.getProperty("loginscreen.opensignin")));
    		driver.findElementById(locators.getProperty("loginscreen.opensignin")).click();
    		driver.findElementById(locators.getProperty("loginscreen.emailtextbox")).sendKeys((String)tesdata.get(emailAddress));
    		driver.findElementById(locators.getProperty("loginscreen.passwordtextbox")).sendKeys((String)tesdata.get(password));
    		driver.hideKeyboard();
    		driver.findElementById(locators.getProperty("loginscreen.signinbutton")).click();
    		try
    		{
    			driver.findElementById(locators.getProperty("homescreen.welcomehome")).click();
    			System.out.println("Welcome screen found for the for the first time login");
    		}catch(NoSuchElementException e)
    		{
    			System.out.println("No welcome screen found for the second time");
    		}
	 }

	/*
	 * Method used to wait until the element is visible
	 */
	public void waitForVisible(AppiumDriver<MobileElement> driver,By by) throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, ELEMENT_WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	/*
	 * Method for log out from the Application
	 */
	public void logout() throws IOException, InterruptedException
	{
		waitForVisible(driver, By.id(locators.getProperty("homescreen.todaysdate")));
		driver.findElementByAccessibilityId(locators.getProperty("homescreen.leftmenubutton")).click();
		waitForVisible(driver, By.id(locators.getProperty("homescreen.hometext")));
		driver.swipe(300, 900, 300,700,500);
		driver.findElementById(locators.getProperty("leftmenu.helpsettingsbutton")).click();
		driver.findElementById(locators.getProperty("leftmenu.signoutbutton")).click();
		driver.findElementById(locators.getProperty("leftmenu.signoutpopupokbutton")).click();
		waitForVisible(driver, By.id(locators.getProperty("loginscreen.opensignin")));
		}
}


