package gty1.selum;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gty.selum.CheckOutPage;
import gty.selum.ProductDisplay;
import gty.selum.TransactionPage;
import gty.selum.cartPage;

public class StandloonTest extends BaseTest {

	
	@Test(dataProvider="GetData" , groups= {"purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException {
		String iteam="ADIDAS ORIGINAL";
		ProductDisplay pd=ld.loginpage(input.get("email"), input.get("password"));
		List<WebElement> listele=pd.getProductList();
		pd.addProductCart(iteam); 
		cartPage cart=pd.gotoCart();
		
		Boolean br=cart.verifyProductCart(iteam);
		Assert.assertTrue(br);
		CheckOutPage cop=cart.checkOut();
		cop.countryKeySend();
		cop.countryChoice();
		
		TransactionPage trp=cop.submitKey();
		String sta=trp.finalPage();
		Assert.assertTrue(sta.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}  
	
	
	
	
	@DataProvider
	public Object[][] GetData() throws IOException {
		//HashMap<String,String> map1=new HashMap<String,String>();
		//map1.put("email", "pritammandal@gmail.com");
		//map1.put("password", "Rikprit23@");
		
		//HashMap<String,String> map2=new HashMap<String,String>();
		//map2.put("email", "rikmandal@gmail.com");
		//map2.put("password", "Rikprit23@");
		
		List<HashMap<String, String>>dats=getDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\dataSet\\data.json");
		return new Object[][] {{dats.get(0)},{dats.get(1)}};
	}

}

