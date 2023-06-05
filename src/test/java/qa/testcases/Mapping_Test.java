package qa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import qa.pages.Login;
import qa.pages.Mapping_Page;
import qa.util.TestUtil;
import qa.base.TestBase;

public class Mapping_Test extends TestBase {
	Login loginPage;
	String sheetName = "login_cred";
	 Mapping_Page Mapping;
	TestUtil testUtil;
	
	@BeforeTest
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new Login();
		Mapping=new Mapping_Page();
	}
	public Mapping_Test(){
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority= -2, dataProvider="getCRMTestData")
	public void loginTest7(String Username, String Password)
	{
		Mapping= loginPage.Login11(Username, Password);	    	
	}

	@Test(priority=0)
	public void verifyProductEntityPage(){
		String homePageTitle= Mapping.verifyPageTitle();
		
		Assert.assertEquals(homePageTitle, "Mapping");
	}
	
	@Test(priority=-1)
	public void SidemenuNavigation() throws InterruptedException
	{
		Thread.sleep(3000);
		Mapping.EDM_Tab();
		Thread.sleep(3000);
		Mapping.entityTab();
		Thread.sleep(3000);
		Mapping.verifySideMenu();
	}
	
	@Test(priority=1)
	public void csvUploadAndDownload() throws InterruptedException, IOException, AWTException
	{
		Mapping.verifycsvDownloadButton();
		Thread.sleep(3000);
		Mapping.verifycsvUploadButton();
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void csvDownloadTemplate() throws InterruptedException
	{
		Thread.sleep(3000);
		Mapping.verifyDownloadTemplateButton();
		driver.findElement(By.xpath("(//*[name()='svg'][@class='k-icon k-btn1'])[1]")).click();
		
	}
	
	@Test(priority=3)
	public void verifySearchFeature() throws InterruptedException{
		Thread.sleep(3000);
		Mapping.verifySearch();
		 System.out.println("Search functionality is working fine");
		 driver.navigate().refresh();
			Thread.sleep(3000);
	}
	@Test(priority=4)
	public void verifyDropDownTable() throws InterruptedException
	{
		Thread.sleep(3000);
		Mapping.verifyDropDownMenu();
	    Thread.sleep(3000);
	}
	@Test(priority=5)
	public void verifyDropDownMenuNavigation() throws InterruptedException
	{
	
		Thread.sleep(3000);
		Mapping.DropDownMenuNavigation();
		
	}
	
	@Test(priority=6)
	public void verifypagination() throws InterruptedException
	{
		Thread.sleep(3000);
		Mapping.verifyPagination();
	}

	@AfterTest
	public void tearDown() throws IOException{
		driver.quit();
	}
}
