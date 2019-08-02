package com.stackroute.userService.seedData;

import org.springframework.web.client.RestTemplate;

public class JsonObject {

    public JsonObject() {
    }

    public Response JsonObject() {
        RestTemplate restTemplate=new RestTemplate();

        Response response=restTemplate.getForObject("http://ws.audioscrobbler.com/2.0/?method=track.search&track=Believe&api_key=adae115666d78c83fd89526b51478923&format=json",Response.class);

        return response;
    }
}
