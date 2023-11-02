package co.com.practice.stepdefinitions.hook;

import freemarker.core.Environment;
import io.cucumber.java.Before;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class Hook {

    private EnvironmentVariables environmentVariables;

    @Before
    public void configureBaseUrl(){

        setTheStage(new OnlineCast());
        theActorCalled("Reqres");

        String theRestApiBaseUrl = environmentVariables.optionalProperty("environments.qa.base.url")
                .orElse("environments.dev.base.url");

        theActorInTheSpotlight().whoCan(CallAnApi.at(theRestApiBaseUrl));

    }
}
