package com.khalidabdul.runner;

import com.khalidabdul.api.DataController;
import com.khalidabdul.data.MovieDatabase;
import com.khalidabdul.data.Search;
import com.khalidabdul.response.GetByIDResponse;
import com.khalidabdul.response.GetBySearchErrorResponse;
import com.khalidabdul.response.GetBySearchResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class ApiRunner {

    private void resetParam () {
        MovieDatabase.s = "";
        MovieDatabase.page = 1;
        MovieDatabase.i = "";
        MovieDatabase.type = "";
        MovieDatabase.t = "";
        MovieDatabase.y = 0;
        MovieDatabase.plot = "";
        MovieDatabase.r = "";
        MovieDatabase.callback = "";
    }

    @Test
    public void getBySearch () {
        MovieDatabase.s = "joker";
        Search[] response = DataController.getBySearch().getSearch();
        assertThat(response[5].getTitle().toLowerCase(), containsString(MovieDatabase.s));
        System.out.println(response[5].getTitle().toLowerCase());
        resetParam();
    }

    @Test
    public void getBySearchError () {
        try {
            getBySearch();
        }catch (Exception e){
            GetBySearchErrorResponse responseError = DataController.getBySearchError();
            System.out.println(responseError);
        }
        resetParam();
    }

    @Test
    public void getBySearchAndPage () {
        MovieDatabase.s = "harley quinn";
        MovieDatabase.page = 2;
        Search[] response = DataController.getBySearchAndPage().getSearch();
        assertThat(response[1].getTitle().toLowerCase(), containsString(MovieDatabase.s));
        System.out.println(response[1].getTitle().toLowerCase());
        resetParam();
    }

    @Test
    public void getBySearchAndPageError () {
        MovieDatabase.s = "harley quinn";
        MovieDatabase.page = 0;
        try {
            Search[] response = DataController.getBySearchAndPage().getSearch();
            assertThat(response[1].getTitle().toLowerCase(), containsString(MovieDatabase.s));
            System.out.println(response[1].getTitle().toLowerCase());
        } catch (Exception e) {
            GetBySearchErrorResponse response = DataController.getBySearchAndPageError();
            System.out.println(response);
        }
        resetParam();
    }

    @Test
    public void getByID () {
        MovieDatabase.i = "tt7286456";
        GetByIDResponse response = DataController.getByID();
        assertThat(String.valueOf(response.getImdbID()), equalTo(MovieDatabase.i));
        System.out.println(response);
        resetParam();
    }

//    @Test
//    public void getBySearchAndPage() {
//        MovieDatabase.page = 2;
//        GetListUserResponse response = DataController.getListUser();
//        assertThat(String.valueOf(response.getPage()), equalTo(MovieDatabase.page));
//        System.out.println(response.toString());
//    }
//
//    @Test
//    public void addUser() {
//        DataController.addUser();
//    }
//
//    @Test
//    public void updateUser() {
//        MovieDatabase.name = "abdul";
//        MovieDatabase.job = "game maker";
//        UpdateUserResponse response = DataController.updateUser();
//        assertThat(response.getName(), equalTo(MovieDatabase.name));
//        assertThat(response.getJob(), equalTo(MovieDatabase.job));
//        System.out.println(response.toString());
//    }
//
//    @Test
//    public void deleteUser() {
//        DeleteUserResponse response = DataController.deleteUser();
//        System.out.println(response);
//    }
//
//    @Test
//    public void getResource() {
//        MovieDatabase.id = "2";
//        GetSingleResourceResponse response = DataController.getResource();
//        assertThat(String.valueOf(response.getData().getId()), equalTo(MovieDatabase.id));
//        System.out.println(response);
//    }
//
//    @Test
//    public void getListResource() {
//        MovieDatabase.page = "1";
//        MovieDatabase.per_page = "3";
//        GetListResourceResponse response = DataController.getListResource();
//        assertThat(String.valueOf(response.getPage()), equalTo(MovieDatabase.page));
//        assertThat(String.valueOf(response.getPer_page()), equalTo(MovieDatabase.per_page));
//        System.out.println(response);
//    }
//
//    @Test
//    public void postRegister() {
//        PostRegisterResponse response = DataController.postRegister();
//        System.out.println(response);
//    }
}
