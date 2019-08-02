package com.stackroute.userService.controller;

import com.stackroute.userService.SeedData.JsonToJavaObject;
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
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistException
    {
        ResponseEntity responseEntity;
        
            trackService.saveUser(track);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        
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
    public ResponseEntity<?> deleteTrack(@PathVariable int userId) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;
        
            trackService.deleteUser(userId);
            responseEntity=new ResponseEntity<List<Track>>(trackService.getAllUsers(), HttpStatus.OK);
        
        return responseEntity;
    }

    @PutMapping("track/{userId}/{name}/{comment}")
    public ResponseEntity<?> updateTrack(@PathVariable int id,@PathVariable String name,@PathVariable String comment) throws Exception
    {
        ResponseEntity responseEntity;
       
            trackService.updateUser(id,name,comment);
            responseEntity=new ResponseEntity<List<Track>>(trackService.getAllUsers(),HttpStatus.OK);
        
        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTrack() throws Exception
    {
       
            return new ResponseEntity<List<Track>>(trackService.getAllUsers(), HttpStatus.OK);
        
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() throws Exception {
        ResponseEntity responseEntity = new ResponseEntity<>(trackService.getAllUsers(), HttpStatus.OK);
        System.out.println(trackService.getByTrackName("hello").toString());
        System.out.println(trackService.getByTrackName("hello").toString());
        return responseEntity;

    }
}
