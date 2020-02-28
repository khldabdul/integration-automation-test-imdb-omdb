package com.khalidabdul.data;


public class MovieDatabase {

    public static String apikey = "28d2634c";

    //BY ID OR TITLE
    private static String i;            // IMDb id      -optional
    private static String t;            // Movie title  -optional
    private static String type;         // Movie type (movie, series, episode)
    private static int y;                // Movie year of release
    private static String plot;         // Movie plot (short, full)
    private static String r;            // Data type return (json, xml)
    private static String callback;     // JSONP callback name

    //BY SEARCH
    private static String s;            // Movie title to search    -required
    private static int page;             // Page number to return

    public static String getImdbId() {
        return i;
    }

    public static void setImdbId(String id) {
        MovieDatabase.i = id;
    }

    public static String getTitle() {
        return t;
    }

    public static void setTitle(String title) {
        MovieDatabase.t = title;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        MovieDatabase.type = type;
    }

    public static int getYear() {
        return y;
    }

    public static void setYear(int year) {
        MovieDatabase.y = year;
    }

    public static String getSearch() {
        return s;
    }

    public static void setSearch(String search) {
        MovieDatabase.s = search;
    }

    public static int getPage() {
        return page;
    }

    public static void setPage(int page) {
        MovieDatabase.page = page;
    }

}
