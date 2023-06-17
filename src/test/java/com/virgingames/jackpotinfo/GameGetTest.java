package com.virgingames.jackpotinfo;

import com.virgingames.testbase.BaseTest;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)

public class GameGetTest extends BaseTest {
    public static ValidatableResponse response;

    @Steps
    GameSteps gameSteps;
    @Title("Getting all jackpot Information")
    @Test
    public void test001(){
        response = gameSteps.getAllJackpots().statusCode(200).log().all();
    }
    @Title("Verify if currency is GBP")
    @Test
    public void test002(){
        response = gameSteps.getAllJackpots();
        HashMap<String, Object> listOfJackpot = response.extract().path("data.pots[0]");
        System.out.println("List: "+ listOfJackpot);
        System.out.println("Record"+ listOfJackpot.size());
        Assert.assertThat(listOfJackpot, hasValue("GBP"));
    }
}
