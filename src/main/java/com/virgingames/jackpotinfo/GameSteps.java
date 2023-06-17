package com.virgingames.jackpotinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GameSteps {
    @Step("Getting all jackpot information")
    public ValidatableResponse getAllJackpots(){
        return SerenityRest.given().log().all()
                .queryParam("currency","GBP")
                .when()
                .get( EndPoints.GET_ALL_JACKPOT)
                .then();
    }
}
