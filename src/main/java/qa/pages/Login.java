package qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.TestBase;

public class Login extends TestBase {

	@FindBy(xpath = "//input[@class='login-input']")
	WebElement Username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath="//button[@id='login-button']")
	WebElement Login;
	
	// Initializing the Page Objects:
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public Login Login1(String un, String pwd){
		Username.sendKeys("");
		Password.sendKeys("");
		System.out.println(Login);
//		Login.click();
		return new Login();
	}
	
	public Login Login2(String un, String pwd){
		Username.sendKeys("Valid");
		Password.sendKeys("");
		System.out.println(Login);
//		Login.click();
		return new Login();
		
	}
	public Login Login3(String un, String pwd){
		Username.sendKeys("");
		Password.sendKeys("Valid");
		System.out.println(Login);
//		Login.click();
		return new Login();
		
	}
	
	public Login Login4(String un, String pwd){
		Username.sendKeys("Invalid");
		Password.sendKeys("Valid");
		System.out.println(Login);
		Login.click();
		return new Login();
		
	}
	public Login Login5(String un, String pwd){
		Username.sendKeys("Valid");
		Password.sendKeys("Invalid");
		System.out.println(Login);
		Login.click();
		return new Login();
		
	}
	public Login Login7(String un, String pwd){
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		Login.click();
		
		return new Login();
		
	}
	public Product_Page Login8(String un, String pwd) {
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		Login.click();		
		return new Product_Page();
	}
	public Personnel_Page Login9(String un, String pwd) {
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		Login.click();		
		return new Personnel_Page();
	}
	public Location_Page Login10(String un, String pwd) {
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		Login.click();		
		return new Location_Page();
	}
	public Mapping_Page Login11(String un, String pwd) {
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		Login.click();		
		return new Mapping_Page();
	}
	public Network_Page Login12(String un, String pwd) {
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		Login.click();		
		return new Network_Page();
	}
	public Currency_Page Login13(String un, String pwd) {
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		Login.click();		
		return new Currency_Page();
	}
	
	
	
	}

	


