package com.stackroute.userService.SeedData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.userService.domain.Track;
import com.stackroute.userService.repository.TrackRepository;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonObject {

    public JsonObject() {
    }

    public Response JsonObject() {
        RestTemplate restTemplate=new RestTemplate();

        Response response=restTemplate.getForObject("http://ws.audioscrobbler.com/2.0/?method=track.search&track=Believe&api_key=adae115666d78c83fd89526b51478923&format=json",Response.class);

        return response;
    }
}
