package com.khalidabdul.module.api;
import com.khalidabdul.data.MovieDatabase;
import com.khalidabdul.response.GetByIDResponse;
import com.khalidabdul.response.GetBySearchResponse;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class DataController {

  public static GetBySearchResponse getBySearch () {
    String url = "http://www.omdbapi.com";

    Response response = SerenityRest.given()
            .queryParam("apikey", MovieDatabase.apikey)
            .queryParam("s", MovieDatabase.getSearch())
            .header("Content-Type", "application/json")
            .get(url);

    response.getBody().prettyPrint();
    return response.getBody().as(GetBySearchResponse.class);
  }

  public static GetByIDResponse getByID () {
    String url = "http://www.omdbapi.com";

    Response response = SerenityRest.given()
            .queryParam("apikey", MovieDatabase.apikey)
            .queryParam("i", MovieDatabase.getSearch())
            .header("Content-Type", "application/json")
            .get(url);

    response.getBody().prettyPrint();
    return response.getBody().as(GetByIDResponse.class);
  }
}