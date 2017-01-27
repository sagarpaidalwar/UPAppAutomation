package com.atmecs.falcone.duels;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.atmecs.falcon.testfunction.CommonMethods;
import com.atmecs.falcon.testsuite.TestSuiteBase;

public class SendTwentyFourHrDuelFromFriendsProfile extends TestSuiteBase
{
	CommonMethods commonmethods;
	@Test
	public void sendTwentyFourHrDuelFromFriendsProfile() throws IOException
	{
		commonmethods= new CommonMethods(driver,prop);
		commonmethods.waitForVisible(By.id(prop.getProperty("homescreen.todaysdate")));
		commonmethods.goToLeftMenu("Friends");	
		commonmethods.waitForVisible(By.id(prop.getProperty("leftmenu.friends.teammate"))); 
		commonmethods.goToFriendsProfile("sagar paidalwar");
		commonmethods.sendDuelsFromFriendsProfile(24);
		commonmethods.waitForVisible(By.id(prop.getProperty("leftmenu.friends.profile.name")));
		VerificationManager.verifyBoolean(driver.findElementById(prop.getProperty("leftmenu.friends.profile.name")).isDisplayed(), true, prop.getProperty("duels.senduel.redirect"));
		driver.findElementByAccessibilityId(prop.getProperty("backbutton")).click();
		commonmethods.goToLeftMenu("Duels");
		commonmethods.waitForVisible(By.id("com.jawbone.up:id/text"));
		VerificationManager.verifyString(driver.findElementByXPath(prop.getProperty("leftmenu.friends.duels.pending.name")).getText(),"sagar hasn't responded",prop.getProperty("duels.sendtwentyfourhrduelfromfriendsprofile.duels.pendings.user"));
		VerificationManager.verifyString(driver.findElementByXPath(prop.getProperty("leftmenu.friends.duels.pending.duration")).getText(),"24 Hour Step Duel",prop.getProperty("duels.sendtwentyfourhrduelfromfriendsprofile.duels.pendings.duration"));
		 commonmethods.withDrawRecentPendingInvite();
	}
}
