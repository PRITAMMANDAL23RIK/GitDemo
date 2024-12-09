package gty.selum;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstructpackg.commonCode;

public class ProductDisplay extends commonCode {
	WebDriver driver;
    public ProductDisplay(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
    @FindBy(css=".mb-3")
    List<WebElement> listele;
    
    @FindBy(css=".ng-animating")
    WebElement spin;
    
    By products=By.cssSelector(".mb-3");
    By cart=By.cssSelector(".card-body button:last-of-type");
    By tost=By.cssSelector("#toast-container");
    
    public List<WebElement> getProductList() {
    	waitTime(products);
    	return listele ;
    }
	public WebElement gproduct(String iteam){
		WebElement prod=getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(iteam)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductCart(String iteam) {
		WebElement pk=gproduct(iteam);
		pk.findElement(cart).click();
		waitTime(tost);
		waitTimeInvesi(spin);
	}
	
}
