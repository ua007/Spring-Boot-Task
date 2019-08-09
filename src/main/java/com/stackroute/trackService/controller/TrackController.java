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

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.saveTrack(track);
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
            trackService.saveTrack(t);
        }
        responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("track/{userId}")
    public ResponseEntity<?> deleteTrack(@PathVariable Integer userId) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;
        trackService.deleteTrack(userId);
        responseEntity=new ResponseEntity<String>("Delete Successfull", HttpStatus.OK);

        return responseEntity;
    }

    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException
    {

        trackService.updateTrack(track);
        ResponseEntity responseEntity=new ResponseEntity<String>("successfully updated",HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTrack()
    {
        try {
            return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }

}
