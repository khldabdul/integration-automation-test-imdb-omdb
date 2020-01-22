package com.khalidabdul.response;

import com.khalidabdul.data.RatingsData;
import lombok.Data;

@Data
public class GetByTitleResponse {
    public String Title;
    public int Year;
    public String Rated;
    public String Released;
    public String Runtime;
    public String Genre;
    public String Director;
    public String Writer;
    public String Actors;
    public String Plot;
    public String Language;
    public String Country;
    public String Awards;
    public String Poster;
    public RatingsData[] Ratings;
    public String Metascore;
    public String imdbRating;
    public String imdbVotes;
    public String imdbID;
    public String Type;
    public String DVD;
    public String BoxOffice;
    public String Production;
    public String Website;
    public String Response;
//    public String Error;
}
