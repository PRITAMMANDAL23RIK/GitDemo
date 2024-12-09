package min.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import gty.selum.CheckOutPage;
import gty.selum.LandingPage;
import gty.selum.ProductDisplay;
import gty.selum.TransactionPage;
import gty.selum.cartPage;
import gty1.selum.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionImplementation extends BaseTest {
    public LandingPage ld;
    public ProductDisplay productdisplay;
    public TransactionPage trp;

    @Given("I landed on Ecomerce Page")
    public void I_landed_on_Ecomerce_Page() throws IOException {
        ld = launchApplication();
        System.out.println("LandingPage object initialized: " + (ld != null));
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void Logged_in_with_ussename_password(String username, String Password) {
        if (ld == null) {
            throw new IllegalStateException("LandingPage object is not initialized. Ensure 'I landed on Ecomerce Page' is executed before this step.");
        }
        System.out.println("LandingPage object before login: " + (ld != null));
        productdisplay = ld.loginpage(username, Password);
    }

    @When("^I add product (.+) to cart$")
    public void I_add_product_to_cart(String productname) {
        List<WebElement> listele = productdisplay.getProductList();
        productdisplay.addProductCart(productname);
    }

    @And("^Checkout (.+) and submit the order$")
    public void Checkout_and_submit_the_order(String productname) {
        cartPage cart = productdisplay.gotoCart();
        Boolean br = cart.verifyProductCart(productname);
        Assert.assertTrue(br);
        CheckOutPage cop = cart.checkOut();
        cop.countryKeySend();
        cop.countryChoice();
        trp = cop.submitKey();
    }

    @Then("{string} message is displayed on finalPage")
    public void message_is_diplayed_on_finalPage(String string) {
        String sta = trp.finalPage();
        Assert.assertTrue(sta.equalsIgnoreCase(string));
    }
}
