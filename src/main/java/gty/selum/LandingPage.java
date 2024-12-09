package gty.selum;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstructpackg.commonCode;

public class LandingPage extends commonCode {
	
    WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;
	
	
	public ProductDisplay loginpage(String email,String pass) {
		useremail.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
		ProductDisplay pd=new ProductDisplay(driver);
		return pd;
	}
	
	public String getErrorMassege() {
		waitTimeWeb(errormessage);
		return errormessage.getText();
	}
	
	public void Goto() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	

}
