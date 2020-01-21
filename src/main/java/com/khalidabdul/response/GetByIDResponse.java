package com.khalidabdul.response;

import com.khalidabdul.data.RatingsData;
import lombok.Data;

@Data
public class GetByIDResponse {
    public String title;
    public int year;
    public String rated;
    public String released;
    public String runtime;
    public String genre;
    public String director;
    public String writer;
    public String actors;
    public String plot;
    public String language;
    public String country;
    public String awards;
    public String poster;
    public RatingsData[] ratings;
    public String metascore;
    public String imdbrating;
    public String imdbvotes;
    public String imdbid;
    public String type;
    public String dvd;
    public String boxoffice;
    public String production;
    public String website;
    public String response;
}
