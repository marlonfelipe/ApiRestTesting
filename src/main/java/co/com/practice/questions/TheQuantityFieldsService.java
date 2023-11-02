package co.com.practice.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matcher;
import static org.hamcrest.Matchers.is;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class TheQuantityFieldsService implements Question<Boolean> {

    private final int quantity;

    public TheQuantityFieldsService(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Validation quantity fields service response",
                        response -> response
                                .assertThat()
                                .body("size()", is(quantity))
                )
        );
        return true;


    }

    public static TheQuantityFieldsService are(int quantity) {
        return new TheQuantityFieldsService(quantity);
    }

}
