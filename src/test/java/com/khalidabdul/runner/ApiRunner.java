package com.khalidabdul.runner;

import com.khalidabdul.api.DataController;
import com.khalidabdul.data.MovieDatabase;
import com.khalidabdul.data.Search;
import com.khalidabdul.response.GetBySearchResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class ApiRunner {

    Search[] searchData;

    @Test
    public void getBySearch() {
        MovieDatabase.s = "joker";
        GetBySearchResponse response = DataController.getBySearch();
        assertThat(response.getSearch().toString(), containsString(MovieDatabase.s));
        System.out.println(response);
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
