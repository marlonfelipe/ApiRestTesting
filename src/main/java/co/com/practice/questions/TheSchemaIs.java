package co.com.practice.questions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


public class TheSchemaIs implements Question<Boolean> {

    private final String structure;

    public TheSchemaIs(String structure) {
        this.structure = structure;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Validation schema service response",
                        response -> response
                                .assertThat()
                                .body(matchesJsonSchemaInClasspath("schemas/"+structure+".json"))
                )
        );
        return true;
    }

    public static TheSchemaIs expected(String schemaResponse) {
        return new TheSchemaIs(schemaResponse);
    }
}
