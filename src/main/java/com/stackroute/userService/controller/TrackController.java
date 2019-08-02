package com.stackroute.userService.controller;

import com.stackroute.userService.domain.Track;
import com.stackroute.userService.exceptions.TrackAlreadyExistException;
import com.stackroute.userService.exceptions.TrackNotFoundException;
import com.stackroute.userService.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {

    TrackService trackService;

    public TrackController(TrackService trackService)
    {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveUser(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.saveUser(track);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }catch (TrackAlreadyExistException ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PostMapping("trackInput")
    public ResponseEntity<?> getAllTrack(@RequestBody List<Track> track) throws RuntimeException, TrackAlreadyExistException {
        ResponseEntity responseEntity;
        for(Track t:track) {
            trackService.saveUser(t);
        }
        responseEntity = new ResponseEntity<List<Track>>(trackService.getAllUsers(), HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("track/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;
        trackService.deleteUser(userId);
        responseEntity=new ResponseEntity<String>("Delete Successfull", HttpStatus.OK);

        return responseEntity;
    }

    @PutMapping("track")
    public ResponseEntity<?> updateUser(@RequestBody Track track) throws TrackNotFoundException
    {

        trackService.updateUser(track);
        ResponseEntity responseEntity=new ResponseEntity<String>("successfully updated",HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllUser()
    {
        try {
            return new ResponseEntity<List<Track>>(trackService.getAllUsers(), HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }

//    @GetMapping("query")
//    public ResponseEntity<?> getAllTracks() {
//        ResponseEntity responseEntity = new ResponseEntity<>(trackService.getAllUsers(), HttpStatus.OK);
//        System.out.println(trackService.getByTrackName("hello").toString());
//        System.out.println(trackService.getByTrackName("hello").toString());
//        return responseEntity;
//
//    }
}
