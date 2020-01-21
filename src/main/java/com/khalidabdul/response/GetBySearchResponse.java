package com.khalidabdul.response;

import com.khalidabdul.data.Search;
import lombok.Data;

@Data
public class GetBySearchResponse {
    public Search[] Search;
    public String totalResults;
    public String Response;
}

