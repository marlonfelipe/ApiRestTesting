package co.com.practice.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class TheFieldsAndValuesGetResponseAre implements Question <Boolean>{


    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Validation fields and values get service api response exists",
                        response -> response
                                .assertThat()
                                .and().body("data.id", equalTo(1))
                                .and().body("data.email", equalTo("george.bluth@reqres.in"))
                                .and().body("data.first_name", equalTo("George"))
                                .and().body("data.last_name", equalTo("Bluth"))
                                .and().body("data.avatar", equalTo("https://reqres.in/img/faces/1-image.jpg"))
                                .and().body("support.url", equalTo("https://reqres.in/#support-heading"))
                                .and().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
                )
        );
        return true;
    }

    public static TheFieldsAndValuesGetResponseAre expected() {
        return new TheFieldsAndValuesGetResponseAre();
    }
}
