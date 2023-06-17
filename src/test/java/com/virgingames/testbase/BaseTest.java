package com.virgingames.testbase;

import com.virgingames.constants.Path;
import com.virgingames.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest {

    public static com.virgingames.utils.PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.basePath = Path.JACKPOT;
    }



}

