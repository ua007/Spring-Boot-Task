package com.stackroute.trackService.controller;

import com.stackroute.trackService.domain.Track;
import com.stackroute.trackService.exceptions.TrackAlreadyExistException;
import com.stackroute.trackService.exceptions.TrackNotFoundException;
import com.stackroute.trackService.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {

    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService)
    {
        this.trackService = trackService;
    }

    @PostMapping("tracks")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistException
    {
        ResponseEntity responseEntity;
        
            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        
        return responseEntity;
    }

    @PostMapping("trackInput")
    public ResponseEntity<?> getAllTrack(@RequestBody List<Track> track) throws RuntimeException, TrackAlreadyExistException {
        ResponseEntity responseEntity;
        for(Track t:track) {
            trackService.saveTrack(t);
        }
        responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("track/{userId}")
    public ResponseEntity<?> deleteTrack(@PathVariable int userId) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;
        
            trackService.deleteTrack(userId);
            responseEntity=new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        
        return responseEntity;
    }

    @PutMapping("track/{userId}/{name}/{comment}")
    public ResponseEntity<?> updateTrack(@PathVariable int id,@PathVariable String name,@PathVariable String comment) throws Exception
    {
        ResponseEntity responseEntity;
       
            trackService.updateTrack(id,name,comment);
            responseEntity=new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
        
        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTrack() throws Exception
    {
       
            return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        
    }

    @GetMapping("getAllTracks")
    public ResponseEntity<?> getAllTracks() throws Exception {
        ResponseEntity responseEntity = new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.OK);
        System.out.println(trackService.getByTrackName("hello").toString());
        System.out.println(trackService.getByTrackName("hello").toString());
        return responseEntity;

    }
}
