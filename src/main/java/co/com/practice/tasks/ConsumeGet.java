package co.com.practice.tasks;

import co.com.practice.interactions.ExecuteGet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeGet implements Task {

    private final String resource;

    public ConsumeGet(String resource) {
        this.resource = resource;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteGet.service(resource));

    }

    public static ConsumeGet service(String resource) {
        return instrumented(ConsumeGet.class, resource);
    }
}
