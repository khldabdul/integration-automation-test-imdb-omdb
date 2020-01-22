package com.khalidabdul.response;

import lombok.Data;

@Data
public class GetBySearchErrorResponse extends Throwable {
    public String Response;
    public String Error;
}
