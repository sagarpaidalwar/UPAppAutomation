package com.atmecs.falcone.duels;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.atmecs.falcon.testfunction.CommonMethods;
import com.atmecs.falcon.testsuite.TestSuiteBase;

public class CheckFriendsMoveDetailScreen extends TestSuiteBase
{
	CommonMethods commonmethods;
	@Test
	public void checkFriendsMoveDetail() throws IOException
	{
		commonmethods= new CommonMethods(driver,prop);
		commonmethods.waitForVisible(By.id(prop.getProperty("homescreen.todaysdate")));
		commonmethods.goToLeftMenu("Friends");	
		commonmethods.waitForVisible(By.id(prop.getProperty("leftmenu.friends.teammate"))); 
		commonmethods.goToFriendsProfile("sagar paidalwar");
	}
}
