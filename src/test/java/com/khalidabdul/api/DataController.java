package com.khalidabdul.api;
import com.khalidabdul.data.MovieDatabase;
import com.khalidabdul.response.GetByIDResponse;
import com.khalidabdul.response.GetBySearchResponse;
import com.khalidabdul.response.GetByTitleResponse;
import net.serenitybdd.rest.SerenityRest;

public class DataController {

  private static String URL_api = "apikey=" + MovieDatabase.apikey + "&";
  private static String URL_search = "s=" + MovieDatabase.s + "&";
  private static String URL_page = "page=" + MovieDatabase.page + "&";
  private static String URL_id = "i=" + MovieDatabase.i + "&";
  private static String URL_title = "t=" + MovieDatabase.t + "&";
  private static String URL_type = "type=" + MovieDatabase.type + "&";
  private static String URL_y = "y=" + MovieDatabase.y + "&";
  private static String URL_plot = "plot=" + MovieDatabase.plot + "&";
  private static String URL_returnType = "r=" + MovieDatabase.r + "&";
  private static String URL_callback = "callback=" + MovieDatabase.callback + "&";

  public static GetBySearchResponse getBySearch () {
    GetBySearchResponse response = SerenityRest.given()
            .header("Content-Type", "application/json")
            .get("http://www.omdbapi.com/?" + URL_api + URL_search)
            .getBody().as(GetBySearchResponse.class);
    return response;
  }

  public static GetBySearchResponse getBySearchAndPage () {
    GetBySearchResponse response = SerenityRest.given()
            .header("Content-Type", "application/json")
            .get("http://www.omdbapi.com/?" + URL_api + URL_search + URL_page)
            .getBody().as(GetBySearchResponse.class);
    return response;
  }

  public static GetByIDResponse getByID () {
    GetByIDResponse response = SerenityRest.given()
            .header("Content-Type", "application/json")
            .get("http://www.omdbapi.com/?" + URL_api + URL_id)
            .getBody().as((GetByIDResponse.class));
    return response;
  }

  public static GetByTitleResponse getByTitle () {
    GetByTitleResponse response = SerenityRest.given()
            .header("Content-Type", "application/json")
            .get("http://www.omdbapi.com/?" + URL_api + URL_title)
            .getBody().as(GetByTitleResponse.class);
    return response;
  }

}