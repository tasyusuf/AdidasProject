package com.demoblaze.step_definitions;

import com.demoblaze.pages.PlaceOrderPage;
import com.demoblaze.pages.ProductPage;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PurchaseSteps {

    ProductPage productPage = new ProductPage();
    PlaceOrderPage placeOrderPage = new PlaceOrderPage();

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("demoblaze.url"));

    }
    @When("User adds {string} from {string}")
    public void user_adds_from(String product, String category) {
        productPage.navigateTo(product, category);
        productPage.addToCart();
        productPage.home.click();
    }

    @And("User navigates to cart and removes {string}")
    public void userNavigatesToCartAndRemoves(String product) {
        productPage.cart.click();
        productPage.deleteProduct("Dell i7 8gb");
    }

    @And("User clicks on Place Order")
    public void userClicksOnPlaceOrder() {
        productPage.cart.click();
        productPage.placeOrder.click();
    }

    @And("User fills the form for order and clicks on purshase button")
    public void userFillsTheFormForOrderAndClicksOnPurshaseButton() {
        placeOrderPage.fillForm();
    }

    @Then("Order ID and order amount should be captured")
    public void orderIDAndOrderAmountShouldBeCaptured() {
        String orderDetailsText = placeOrderPage.orderDetails.getText();

        System.out.println("orderDetailsText = " + orderDetailsText);

        String orderId = orderDetailsText.split("\n")[0];
        System.out.println("orderId = " + orderId);

        int actualPurchaseAmount = Integer.parseInt(orderDetailsText.split("\n")[1].split(" ")[1]);
        System.out.println("actualPurchaseAmount = " + actualPurchaseAmount);

    }


}
