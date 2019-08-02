package com.stackroute.userService.SeedData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    @JsonProperty
    private RestResponse restResponse;

    public Response() {
    }

    public RestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }
}
