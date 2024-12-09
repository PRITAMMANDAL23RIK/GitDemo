package gty.selum;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstructpackg.commonCode;

public class CheckOutPage extends commonCode {
	
    WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[2]/div/div[1]/div/input")
	WebElement country;
	
	@FindBy(xpath="//div/section/button")
	List<WebElement> countryList;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	public void countryKeySend() {
		country.sendKeys("ind");
	}
	public void countryChoice() {
		for(WebElement option:countryList ) {
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
	}
	public TransactionPage submitKey() {
		submit.click();
		TransactionPage trp=new TransactionPage(driver);
		return trp;
	}
	

}
