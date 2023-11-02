package co.com.practice.stepdefinitions;

import  co.com.practice.exceptions.AssertionsServices;

import co.com.practice.questions.*;
import co.com.practice.tasks.ConsumeGet;
import co.com.practice.tasks.Load;
import co.com.practice.utils.resource.WebServiceEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.practice.exceptions.AssertionsServices.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static  net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;
import java.util.Map;

public class GetStepdefinitions {

    @Given("I Load customer information")
    public void iLoadCustomerInformation(List<Map<String, String>> data) {
        theActorInTheSpotlight().wasAbleTo(
                Load.testData(data.get(0))
        );
    }


    @When("I call Get user API")
    public void iCallGetUserAPI() {
        theActorInTheSpotlight().attemptsTo(
                ConsumeGet.service(
                        WebServiceEndPoints.URI.getUrl()
                )
        );
    }


    @Then("I should see the status code {int}")
    public void iShouldSeeTheStatusCode(int responseCode) {
        theActorInTheSpotlight()
                .should(seeThat(StatusCode.is(responseCode))
                        .orComplainWith(AssertionsServices.class, THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED)
                );

    }
    @Then("I validate quantity key is {int}")
    public void iValidateQuantityKeyIs(int quantity) {
        theActorInTheSpotlight()
                .should(seeThat(TheQuantityFieldsService.are(quantity))
                        .orComplainWith(AssertionsServices.class, QUANTITY_FIELDS_SERVICE_IS_NOT_EXPECTED)
                );

    }
    @Then("I validate schema response {string}")
    public void iValidateSchemaResponse(String schemaResponse) {
        theActorInTheSpotlight()
                .should(seeThat(TheSchemaIs.expected(schemaResponse))
                        .orComplainWith(AssertionsServices.class, SCHEMA_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("I validate fields get response api")
    public void iValidateFieldsGetResponseApi() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsGetServicesResponseAre.expected())
                        .orComplainWith(AssertionsServices.class, THE_FIELDS_SERVICE_IS_NOT_EXPECTED)
                );

    }
    @Then("I validate get response contain data expected")
    public void iValidateGetResponseContainDataExpected() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsAndValuesGetResponseAre.expected())
                        .orComplainWith(AssertionsServices.class, THE_FIELDS_AND_VALUES_SERVICE_IS_NOT_EXPECTED)
                );

    }

}
