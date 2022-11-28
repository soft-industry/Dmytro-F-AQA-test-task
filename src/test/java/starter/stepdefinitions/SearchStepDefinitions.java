package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class SearchStepDefinitions {

    @When("he calls endpoint {string}")
    public void heCallsEndpoint(String arg0) {
        SerenityRest.given().get(arg0);
    }

    @Then("he sees each item contains '{word}' in title")
    public void heSeesTheResultsDisplayedForFruit(String fruit) {
        restAssuredThat(response -> response
                .statusCode(200)
                .body("title", everyItem(containsStringIgnoringCase(fruit))
                )
        );
    }

    @Then("he sees each product has 'provider', 'brand', 'price', 'unit' and 'image'")
    public void heSeesNotNullProductFields() {
        restAssuredThat(response -> response
                .statusCode(200)
                .body("provider", everyItem(notNullValue()))
                .body("brand", everyItem(notNullValue()))
                .body("price", everyItem(notNullValue()))
                .body("unit", everyItem(notNullValue()))
                .body("image", everyItem(notNullValue()))
        );
    }

    @Then("he sees the 'Not Found' error message")
    public void heSeesNotFoundErrorMessage() {
        restAssuredThat(response -> response.statusCode(404)
                .body("detail.error", is(true))
                .body("detail.message", equalTo("Not found"))
                .body("detail.requested_item", notNullValue())
                .body("detail.served_by", notNullValue())
        );
    }
}
