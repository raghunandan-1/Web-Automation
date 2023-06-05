package qa.testcases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import qa.base.TestBase;

import qa.pages.Login;
import qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	Login loginPage;
	
	
	
	String sheetName = "contacts";
	boolean flag = true;
	
	
	public LoginPageTest(){
	}

	@BeforeTest
	public void setUp(){
		initialization();
		loginPage = new Login();	
	}
	
	@Test(priority=0, description = "To verify the title of the page.")
	public void loginPageTitleTest(){
		
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "SCAI - Supply Chain AI for Enterprise");
		System.out.println(title);
	}
	
//	@Test(priority=1, description = "To verify the log in process with blank username and password.")
//	public void loginTest1(String Username, String Password)
//	{
//		loginPage.Login1(Username, Password);
//	}
//	
//	@Test(priority=2, description = "To verify the log in process with valid username and blank password.")
//	public void loginTest2(String Username, String Password){
//		loginPage.Login2(Username, Password);
//	}
//	
//	@Test(priority=3, description = "To verify the log in process with blank username and valid password.")
//	public void loginTest3(String Username, String Password){
//		loginPage.Login3(Username, Password);
//	}
	
//	@Test(priority=4, description = "To verify the log in process with invalid username and valid password.")
//	public void loginTest4(String Username, String Password){
//		homePage = loginPage.Login4(Username, Password);
//	}
	
//	@Test(priority=5, description = "To verify the log in process with valid username and invalid password.")
//	public void loginTest5(String Username, String Password){
//		homePage = loginPage.Login5(Username, Password);
//	}
	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void loginTest7(String Username, String Password)
	{
		long s = System.currentTimeMillis();
		 loginPage.Login7(Username, Password);
			      
		System.out.println("Login Complete!");
		WebDriverWait wt = new WebDriverWait(driver,6);
		System.out.println("Waiting for the element");
		wt.until(ExpectedConditions.elementToBeClickable (By.xpath("//span[@class='border-menu']"))).click();
		System.out.println("Element found");
		long e = System.currentTimeMillis();
		long r = (e - s);
		float min = (float) (r/1000);
		System.out.println(e);
		System.out.println(s);
		System.out.println(r);
		System.out.println("Page load time" + min +"Seconds");
	
		
	}
	@Test(priority=2, description = "To verify the title of the page.")
	public void EDMPageTitleTest1(){
		
	String	title=driver.findElement(By.xpath("//h3[@class='section-heading']")).getText();
		Assert.assertEquals(title, "Product");
		System.out.println(title);
	}
//	@Test(priority=8, description = "To take screenshot.")
//	public static void takeScreenshot() throws IOException{
//		// Take screenshot and store as a file format
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String fileName = "ss";
//		// now copy the screenshot to desired location using copyFile //method
//		FileUtils.copyFile(src, 
//				new File("/home/user/eclipse-workspace/PageObjectModel/screenshots/" + fileName +".png"));
//
//	}

	@AfterTest
	public void tearDown() throws IOException{
		driver.quit();
	}

}
