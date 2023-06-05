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
import qa.pages.Product_Page;
import qa.util.TestUtil;
import qa.base.TestBase;

public class Product_Test extends TestBase{
	
	Login loginPage;
	String sheetName = "login_cred";
	 Product_Page Product;
	TestUtil testUtil;
	
	@BeforeTest
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new Login();
		Product=new Product_Page();
	}
	public Product_Test(){
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority= -2, dataProvider="getCRMTestData")
	public void loginTest7(String Username, String Password)
	{
		Product= loginPage.Login8(Username, Password);	    	
	}

	@Test(priority=0)
	public void verifyProductEntityPage(){
		String homePageTitle= Product.verifyPageTitle();
		
		Assert.assertEquals(homePageTitle, "Product");
	}
	
	@Test(priority=-1)
	public void SidemenuNavigation() throws InterruptedException
	{
		Thread.sleep(3000);
		Product.EDM_Tab();
		Thread.sleep(3000);
		Product.entityTab();
		Thread.sleep(3000);
		Product.verifySideMenu();
	}
	
	@Test(priority=1)
	public void csvUploadAndDownload() throws InterruptedException, AWTException, IOException
	{
		Product.verifycsvDownloadButton();
		Thread.sleep(3000);
		Product.verifycsvUploadButton();
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void csvDownloadTemplate() throws InterruptedException
	{
		Thread.sleep(3000);
		Product.verifyDownloadTemplateButton();
		driver.findElement(By.xpath("(//*[name()='svg'][@class='k-icon k-btn1'])[1]")).click();
		
	}
	
	@Test(priority=3)
	public void verifySearchFeature() throws InterruptedException{
		Thread.sleep(3000);
		Product.verifySearch();
		 System.out.println("Search functionality is working fine");
		driver.navigate().refresh();
		Thread.sleep(3000);
	}
	@Test(priority=4)
	public void verifyDropDownTable() throws InterruptedException
	{
		Thread.sleep(3000);
		Product.verifyDropDownMenu();
	    Thread.sleep(3000);
	}
	@Test(priority=5)
	public void verifyDropDownMenuNavigation() throws InterruptedException
	{
	
		Thread.sleep(3000);
		Product.DropDownMenuNavigation();
		
	}
	
	@Test(priority=6)
	public void verifypagination() throws InterruptedException
	{
		Thread.sleep(3000);
		Product.verifyPagination();
	}

	@AfterTest
	public void tearDown() throws IOException{
		driver.quit();
	}
	
}




