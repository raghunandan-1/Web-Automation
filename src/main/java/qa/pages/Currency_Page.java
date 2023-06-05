package qa.pages;

import java.awt.AWTException;
import qa.base.TestBase;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Currency_Page extends TestBase{
	@FindBy(xpath="//span[@class='border-menu']")
	@CacheLookup
	WebElement EDM_Tab;
	
	@FindBy(xpath = "//h3[@class='section-heading']")
	WebElement CurrencyHeading;
	
	@FindBy(xpath = "//div[@id='mui-component-select-show']")
	WebElement SelectRows;
	
	
	@FindBy(xpath="//span[normalize-space()='Show 10 Rows']")
	WebElement Select10Rows;
	
	@FindBy(xpath="//span[normalize-space()='Show 25 Rows']")
	WebElement Select25Rows;
	
	@FindBy(xpath="//span[normalize-space()='Show 50 Rows']")
	WebElement Select50Rows;
	
	@FindBy(xpath="//span[normalize-space()='Show 100 Rows']")
	WebElement Select100Rows;
	
	@FindBy(xpath = "//button[@class='btn refresh-btn ml-15']")
	WebElement RefreshButton;
	
	@FindBy(xpath = "//input[@id=':r0:']")
	WebElement SearchInputBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement SearchSubmit;
	
	@FindBy(xpath = "//button[normalize-space()='CSV Upload']")
	WebElement csvUploadButton;
	
	@FindBy(xpath = "//div[@class='k-pager-info k-label']")
	WebElement pagerInfo;
	
	@FindBy(xpath = "//button[normalize-space()='CSV Download']")
	WebElement csvDownloadButton;
	
	@FindBy(xpath="//span[@class='k-icon k-i-caret-alt-to-left k-color-inherit']")
	WebElement InitialPaginationIcon;
	
	@FindBy(xpath="//span[@class='k-icon k-i-caret-alt-to-right k-color-inherit']")
	WebElement FinalPaginationIcon;
	
	@FindBy(xpath="//span[@class='k-icon k-i-caret-alt-left k-color-inherit']")
	WebElement leftPaginationIcon;
	
	@FindBy(xpath="//span[@class='k-icon k-i-caret-alt-right k-color-inherit']")
	WebElement rightPaginationIcon;
	
	@FindBy(xpath="//a[normalize-space()='Product']")
	WebElement productTab;
	
	@FindBy(xpath="//a[normalize-space()='Currency']")
	WebElement currencyTab;
	
	@FindBy(xpath = "//button[@class='k-button k-button-md k-rounded-md k-button-solid k-button-solid-base download-template-button']")
	WebElement downloadTemplateButton;
	public Currency_Page() {
		PageFactory.initElements(driver, this);
	}

	public void EDM_Tab()
	{
		EDM_Tab.click();
		
	}
	
    public void entityTab() {
    	productTab.click();
    	
    }
    public String verifyPageTitle() {
    	String title=CurrencyHeading.getText();
    	System.out.println("Page Ttile is:"+title);
    	
    
    	return title;
    }
    public void verifycsvDownloadButton() {
    	csvDownloadButton.click();
    }
    public void verifycsvUploadButton() throws AWTException, IOException, InterruptedException 
	{
		// Need to change path for Mac and Windows as well. If you are running in Windows just change the Sys variable 
		String sys = "Windows";
		String filepath = System.getProperty("user.dir") + "\\src\\main\\java\\qa\\testdata\\currency.csv";

		if (sys == "mac") {
			csvUploadButton.click();
			System.out.println("@@@@@@@@@@");			
			Thread.sleep(5000);
			System.out.println(filepath);
			Thread.sleep(10000);
			Runtime.getRuntime().exec("ososcript " + System.getProperty("user.dir")+ "applescript.scpt");

			System.out.println(filepath);

		} else if (sys == "Windows") {


			csvUploadButton.click();
			Thread.sleep(3000); // suspending execution for specified time period

			// creating object of Robot class
			Robot rb = new Robot();

			// copying File path to Clipboard
			StringSelection str = new StringSelection(filepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

			// press Contol+V for pasting
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);

			// release Contol+V for pasting
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);

			// for pressing and releasing Enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} 
		else 
		{
			csvUploadButton.click();
			Thread.sleep(2000);
		}
		System.out.println("@@@@@@@@@@@@@@@@");

	}
    public void verifyDownloadTemplateButton() throws InterruptedException {
    	
    	csvUploadButton.click();
    	Thread.sleep(3000);
    	
    	downloadTemplateButton.click();
    	
    	
    }
    public void verifySearch() throws InterruptedException {
    	SearchInputBox.sendKeys("11");
    	SearchSubmit.click();
    	Thread.sleep(1000);
   
    	
    }
    public void verifySideMenu() throws InterruptedException {
    	productTab.click();
    	Thread.sleep(3000);
    	currencyTab.click();
    }
    public boolean verifyDropDownMenu() {
    	SelectRows.click();
    	
    		 Boolean dropdownPresent = driver.findElement(By.xpath("//span[normalize-space()='Show 10 Rows']")).isDisplayed();

    	        if(dropdownPresent==true)
    	        {
    	            System.out.println("Dropdown is appearing");
    	        }
    	        else{
    	            System.out.println("Dropdown is not appearing");
    	        }
    	        
    		return dropdownPresent;
    	}
    
    public void DropDownMenuNavigation() throws InterruptedException {
    	
    	try {
    		WebElement dropdown = driver.findElement(By.id("mui-component-select-show"));
           
        dropdown.click();
        
    	}
    	catch(Exception e){
    		System.out.println("Dropdown clicked");
    	}
        
        WebElement option = driver.findElement(By.xpath("(//li[@role='option'])[4]"));

      
        option.click();

       
        WebElement selectedOption = driver.findElement(By.cssSelector("div[id='menu-show'] li:nth-child(4)"));
        System.out.println("Selected option: " + selectedOption.getText());
	
        
    }
    public void verifyPagination() throws InterruptedException {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		try {
    		WebElement pagination = driver.findElement(By.xpath("//span[@class='k-icon k-i-caret-alt-right k-color-inherit']"));
           
        pagination.click();
        
    	}
    	catch(Exception e){
    		System.out.println("going to next page");
    	}
        
		Thread.sleep(3000);
		try {
    		WebElement pagination1 = driver.findElement(By.xpath("//span[@class='k-icon k-i-caret-alt-to-right k-color-inherit']"));
           
        pagination1.click();
        
    	}
    	catch(Exception e){
    		System.out.println("going to last page");
    	}
        
		Thread.sleep(3000);
		try {
    		WebElement pagination2= driver.findElement(By.xpath("//span[@class='k-icon k-i-caret-alt-left k-color-inherit']"));
           
        pagination2.click();
        
    	}
    	catch(Exception e){
    		System.out.println("going to the previous page");
    	}
		
		Thread.sleep(3000);
		try {
    		WebElement pagination3= driver.findElement(By.xpath("//span[@class='k-icon k-i-caret-alt-to-left k-color-inherit']"));
           
        pagination3.click();
        
    	}
    	catch(Exception e){
    		System.out.println("going to the first page");
    	}
		
		Thread.sleep(3000);
    }
    
    public void table_scroll() throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
    
    

}
