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
import qa.pages.Currency_Page;
import qa.util.TestUtil;
import qa.base.TestBase;

public class Currency_Test extends TestBase{
	Login loginPage;
	String sheetName = "login_cred";
	 Currency_Page Currency;
	TestUtil testUtil;
	
	@BeforeTest
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new Login();
	Currency=new Currency_Page();
	}
	public Currency_Test(){
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority= -2, dataProvider="getCRMTestData")
	public void loginTest7(String Username, String Password)
	{
		Currency= loginPage.Login13(Username, Password);	    	
	}

	@Test(priority=0)
	public void verifyProductEntityPage(){
		String homePageTitle= Currency.verifyPageTitle();
		
		Assert.assertEquals(homePageTitle, "Currency");
	}
	
	@Test(priority=-1)
	public void SidemenuNavigation() throws InterruptedException
	{
		Thread.sleep(3000);
		Currency.EDM_Tab();
		Thread.sleep(3000);
		Currency.entityTab();
		Thread.sleep(3000);
		Currency.verifySideMenu();
	}
	
	@Test(priority=1)
	public void csvUploadAndDownload() throws InterruptedException, AWTException, IOException
	{
		Currency.verifycsvDownloadButton();
		Thread.sleep(3000);
		Currency.verifycsvUploadButton();
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void csvDownloadTemplate() throws InterruptedException
	{
		Thread.sleep(3000);
		Currency.verifyDownloadTemplateButton();
		driver.findElement(By.xpath("(//*[name()='svg'][@class='k-icon k-btn1'])[1]")).click();
		
	}
	
	@Test(priority=3)
	public void verifySearchFeature() throws InterruptedException{
		Thread.sleep(3000);
		Currency.verifySearch();
		 System.out.println("Search functionality is working fine");
		 driver.navigate().refresh();
			Thread.sleep(3000);
	}
	@Test(priority=4)
	public void verifyDropDownTable() throws InterruptedException
	{
		Thread.sleep(3000);
		Currency.verifyDropDownMenu();
	    Thread.sleep(3000);
	}
	@Test(priority=5)
	public void verifyDropDownMenuNavigation() throws InterruptedException
	{
	
		Thread.sleep(3000);
		Currency.DropDownMenuNavigation();
		
	}
	
	@Test(priority=6)
	public void verifypagination() throws InterruptedException
	{
		Thread.sleep(3000);
		Currency.verifyPagination();
	}

	@AfterTest
	public void tearDown() throws IOException{
		driver.quit();
	}
	

}
