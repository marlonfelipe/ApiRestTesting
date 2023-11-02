package co.com.practice.runners;

import co.com.practice.utils.exceldata.BeforeSuite;
import co.com.practice.utils.exceldata.DataToFeature;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

import static io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(CustomRunner.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features = "src/test/resources/features/post.feature",
        glue = {"co.com.practice.stepdefinitions.hook",
                 "co.com.practice.stepdefinitions"
        }
)

public class PostRunners {
        @BeforeSuite
        public static void test()
                throws IOException, InvalidFormatException {
                DataToFeature.overrideFeatureFiles("./src/test/resources/features/post.feature");
        }
}
