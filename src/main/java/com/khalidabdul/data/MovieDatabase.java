package com.khalidabdul.data;

public class MovieDatabase {

    public static String apikey = "28d2634c";

    //BY ID OR TITLE
    public static String i = "";            // IMDb id      -optional
    public static String t = "";            // Movie title  -optional
    public static String type = "";         // Movie type (movie, series, episode)
    public static int y = 0;                // Movie year of release
    public static String plot = "";         // Movie plot (short, full)
    public static String r = "";            // Data type return (json, xml)
    public static String callback = "";     // JSONP callback name


    //BY SEARCH
    public static String s = "";            // Movie title to search    -required
    public static int page = 1;             // Page number to return
}
