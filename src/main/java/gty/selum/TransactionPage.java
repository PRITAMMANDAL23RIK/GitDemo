package gty.selum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstructpackg.commonCode;

public class TransactionPage extends commonCode {
	
    WebDriver driver;
	public TransactionPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="hero-primary")
	WebElement headText;
	
	public String finalPage() {
		String str=headText.getText();
		return str;
	}
	

}
