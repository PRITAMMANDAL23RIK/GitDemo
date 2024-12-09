package gty.selum;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstructpackg.commonCode;

public class cartPage extends commonCode {
	
    WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cart;
	
	@FindBy(xpath="//div/div[3]/ul/li[3]/button")
	WebElement checkoutKey;
	
	public Boolean verifyProductCart(String iteam){
		Boolean br=cart.stream().anyMatch(pro->pro.getText().equalsIgnoreCase(iteam));
		return br;
	}
	public CheckOutPage checkOut() {
		checkoutKey.click();
		CheckOutPage cop=new CheckOutPage(driver);
		return cop;
	}

}
