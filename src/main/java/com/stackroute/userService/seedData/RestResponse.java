package com.stackroute.userService.SeedData;

import com.stackroute.userService.domain.Track;

import java.util.Arrays;

public class RestResponse {

    private String[] message;
    private Track track;

    public RestResponse() {
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "message=" + Arrays.toString(message) +
                ", track=" + track +
                '}';
    }
}
