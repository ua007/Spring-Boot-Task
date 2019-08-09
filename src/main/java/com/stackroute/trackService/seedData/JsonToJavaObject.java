package com.stackroute.trackService.SeedData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.trackService.domain.Track;

import java.io.File;
import java.io.IOException;

@JsonIgnoreProperties
public class JsonToJavaObject {

    public JsonToJavaObject() {
    }

    public void JsonObject() {
        ObjectMapper mapper = new ObjectMapper();

        Track track=new Track();
        try {

            // JSON file to Java object
            track = mapper.readValue(new File("/home/utkarsh/Desktop/Spring Boot/userService/src/main/java/com/stackroute/userService/api.json"), Track.class);

            // JSON string to Java object
//            Track track2 = mapper.readValue(jsonInString, Track.class);

            // compact print
            System.out.println(track);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
