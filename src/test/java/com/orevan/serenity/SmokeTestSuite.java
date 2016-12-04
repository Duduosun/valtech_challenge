package com.orevan.serenity;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by tolaf on 24/07/2016.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/luma/", tags = {"@pdpconfig"})
public class SmokeTestSuite {
}
