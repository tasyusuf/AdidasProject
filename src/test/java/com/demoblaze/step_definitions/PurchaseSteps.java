package com.demoblaze.step_definitions;

import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PurchaseSteps {
    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("demoblaze.url"));

    }
    @When("User adds {string} from {string}")
    public void user_adds_from(String product, String category) {

    }
}
