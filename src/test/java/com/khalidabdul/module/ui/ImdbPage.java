package com.khalidabdul.module.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.List;

public class ImdbPage extends PageObject {

    @FindBy(xpath = "//input[@id='suggestion-search']")
    WebElementFacade searchBox;

    @FindBy(xpath = "//td[@class='result_text']//a")
    List<WebElementFacade> movieTitle;

    public void openHomePage () {
        openUrl("https://www.imdb.com/");
    }

    public void doSearch (String value) {
        searchBox.typeAndEnter(value);
//        movieTitle.get(0).click();
    }

    public List<String> getMovieTitle() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < movieTitle.size(); i++) {
            list.add(movieTitle.get(i).getText());
        }
        return list;
    }

    public void titleClick () {
        movieTitle.get(0).click();
    }

}
