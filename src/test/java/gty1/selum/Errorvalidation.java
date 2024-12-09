package gty1.selum;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import gty.selum.ProductDisplay;
import gty.selum.cartPage;

public class Errorvalidation extends BaseTest {

	
	@Test
	public void loginEroor() throws IOException {
		ProductDisplay pd=ld.loginpage("pritammandal@gmail.com", "Rikprit2@");
		Assert.assertEquals("Incorrect email or password.", ld.getErrorMassege());
		
	}
	
	@Test
	public void submitOrder() throws IOException {
		String iteam="ADIDAS ORIGINAL";
		ProductDisplay pd=ld.loginpage("pritammandal@gmail.com", "Rikprit23@");
		List<WebElement> listele=pd.getProductList();
		pd.addProductCart(iteam); 
		cartPage cart=pd.gotoCart();
		Boolean br=cart.verifyProductCart("ADIDAS ORIGINAL 87");
		Assert.assertFalse(br);
		
	}  

}

