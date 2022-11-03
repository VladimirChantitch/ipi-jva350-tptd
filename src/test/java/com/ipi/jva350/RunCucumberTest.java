package com.ipi.jva350;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/ipi/jva350")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberTest {

    @Test
    public void Test_IsItFriday(){
        StepDefinitions stepDefinitions = new StepDefinitions();

        Given:
        stepDefinitions.today_is_Sunday();

        When:
        stepDefinitions.i_ask_whether_it_s_Friday_yet();

        Then:
        assert(stepDefinitions.i_should_be_told("Nope")) ;
    }
}
