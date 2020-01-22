package com.khalidabdul.cucumber;

import com.khalidabdul.api.DataController;
import com.khalidabdul.data.MovieDatabase;
import com.khalidabdul.data.Search;
import com.khalidabdul.response.GetByIDResponse;
import com.khalidabdul.response.GetBySearchResponse;
import com.khalidabdul.response.GetByTitleResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class TestApiSteps extends ScenarioSteps {

    // GIVEN
    @Given("set apikey to '(.*)")
    public void set_apikey (String value) {
        MovieDatabase.apikey = value;
    }

    @Given("set search to '(.*)'")
    public void set_search_to (String value) {
        MovieDatabase.s = value;
    }

    @Given("set title to '(.*)'")
    public void set_title_to (String value) {
        MovieDatabase.t = value;
    }

    @Given("set imdb id to '(.*)'")
    public void set_imdb_id_to (String value) {
        MovieDatabase.i = value;
    }

    @Given("set page to '(.*)'")
    public void set_page_to (int value)  {
        MovieDatabase.page = value;
    }

    @Given("set type to '(.*)'")
    public void set_type_to (String value) {
        MovieDatabase.type = value;
    }

    @Given("set year to '(.*)'")
    public void set_year_to (int value) {
        MovieDatabase.y = value;
    }

    @Given("set plot to '(.*)'")
    public void set_plot_to (String value) {
        MovieDatabase.plot = value;
    }


    // WHEN
    @When("send get by search")
    public void send_get_by_search () {
        GetBySearchResponse response = DataController.getBySearch();
        System.out.println(response);
    }

    @When("send get by search and page")
    public void send_get_by_search_and_page () {
        GetBySearchResponse response = DataController.getBySearchAndPage();
        System.out.println(response);
    }

    @When("send get by title")
    public void send_get_by_title () {
        GetByTitleResponse response = DataController.getByTitle();
        System.out.println((response.toString()));
    }

    @When("send get by id")
    public void set_get_by_id () {
        GetByIDResponse response = DataController.getByID();
        System.out.println(response);
    }


    // THEN
    @Then("get by search response equals with request")
    public void get_by_search_response_equals_with_request () {
        Search[] response = DataController.getBySearch().getSearch();
//        GetBySearchResponse response = DataController.getBySearch();
        assertThat(String.valueOf(response), Matchers.containsString(MovieDatabase.s));
    }

    @Then("get by search and page response equals with request")
    public void get_by_search_and_page_response_equals_with_request () {
        GetBySearchResponse response = DataController.getBySearchAndPage();
        assertThat(String.valueOf(response.getSearch()), containsString(MovieDatabase.s));
        assertThat(String.valueOf(response.getSearch()), equalTo(MovieDatabase.page));
    }

    @Then("get by title response equals with request")
    public void get_by_title_response_equals_with_request () {
        GetByTitleResponse response = DataController.getByTitle();
        assertThat(response.getTitle(), equalTo(MovieDatabase.t));
    }

    @Then("get by id response equals with request")
    public void get_by_id_response_equals_with_request () {
        GetByIDResponse response = DataController.getByID();
        assertThat(response.getImdbID(), equalTo(MovieDatabase.i));
        System.out.println(response);
    }
}