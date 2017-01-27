package com.atmecs.falcone.duels;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.atmecs.falcon.testfunction.CommonMethods;
import com.atmecs.falcon.testsuite.TestSuiteBase;

public class StartDuelOnFriendsProfile extends TestSuiteBase
{

CommonMethods commonmethods;	
@Test	
public void sendDuelsFromFriendsProfile() throws IOException
 {
	commonmethods= new CommonMethods(driver,prop);
	commonmethods.waitForVisible(By.id(prop.getProperty("homescreen.todaysdate")));
	commonmethods.goToLeftMenu("Friends");
	commonmethods.waitForVisible(By.id(prop.getProperty("leftmenu.friends.teammate"))); 
	commonmethods.goToFriendsProfile("sagar paidalwar");
	commonmethods.waitForVisible(By.id(prop.getProperty("leftmenu.friends.profile.name")));
	VerificationManager.verifyBoolean(driver.findElementById(prop.getProperty("leftmenu.friends.profile.startduels")).isDisplayed(), true, prop.getProperty("duels.startduelfromfriendsprofile.profile.duelicon"));
	driver.findElementById(prop.getProperty("leftmenu.friends.profile.startduels")).click();
	VerificationManager.verifyString(driver.findElementById(prop.getProperty("leftmenu.friends.profile.duelinvite.friendtext")).getText(), "sagar paidalwar", prop.getProperty("duels.startduelfromfriendsprofile.duelinvite.username"));
	VerificationManager.verifyString(driver.findElementById(prop.getProperty("leftmenu.friends.profile.duelinvite.duelduration")).getText(), "3", prop.getProperty("duels.startduelfromfriendsprofile.duelinvite.duration"));
	VerificationManager.verifyString(driver.findElementById(prop.getProperty("leftmenu.friends.profile.duelinvite.privacytext")).getText(), "Public", prop.getProperty("duels.startduelfromfriendsprofile.duelinvite.privacy"));
	VerificationManager.verifyBoolean(driver.findElementById(prop.getProperty("leftmenu.friends.profile.duelinvite.senduel")).isEnabled(), true, prop.getProperty("duels.startduelfromfriendsprofile.duelinvite.sendbutton"));
    driver.findElementByAccessibilityId(prop.getProperty("backbutton")).click();
    VerificationManager.verifyString(driver.findElementById(prop.getProperty("leftmenu.friends.profile.name")).getText(), "sagar paidalwar", prop.getProperty("duels.startduelfromfriendsprofile.duelinvite.back"));
  }
}  