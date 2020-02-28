package com.khalidabdul.cucumber;

import com.khalidabdul.module.api.DataController;
import com.khalidabdul.data.MovieDatabase;
import com.khalidabdul.data.Search;
import com.khalidabdul.response.GetByIDResponse;
import com.khalidabdul.response.GetBySearchResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestApiSteps extends ScenarioSteps {

    // GIVEN
    @Given("set apikey to '(.*)")
    public void set_apikey (String value) {
        MovieDatabase.apikey = value;
    }

    @Given("set search to '(.*)'")
    public void set_search_to (String value) {
        MovieDatabase.setSearch(value);
    }

    @Given("set title to '(.*)'")
    public void set_title_to (String value) {
        MovieDatabase.setTitle(value);
    }

    @Given("set imdb id to '(.*)'")
    public void set_imdb_id_to (String value) {
        MovieDatabase.setImdbId(value);
    }

    @Given("set page to '(.*)'")
    public void set_page_to (int value)  {
        MovieDatabase.setPage(value);
    }

    @Given("set type to '(.*)'")
    public void set_type_to (String value) {
        MovieDatabase.setType(value);
    }

    @Given("set year to '(.*)'")
    public void set_year_to (int value) {
        MovieDatabase.setYear(value);
    }

    // WHEN
    @When("send get by search")
    public void send_get_by_search () {
        GetBySearchResponse response = DataController.getBySearch();
        System.out.println(response);
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
        assertThat(String.valueOf(response), Matchers.containsString(MovieDatabase.getSearch()));
    }

    @Then("get by id response equals with request")
    public void get_by_id_response_equals_with_request () {
        GetByIDResponse response = DataController.getByID();
        assertThat(response.getImdbID(), equalTo(MovieDatabase.getImdbId()));
        System.out.println(response);
    }
}