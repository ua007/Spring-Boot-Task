package com.stackroute.trackService.controller;

import com.stackroute.trackService.domain.Track;
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
        }catch (Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("track/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId)
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.deleteTrack(userId);
            responseEntity=new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
        }catch (Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("track/{userId}/{name}/{comment}")
    public ResponseEntity<?> updateUser(@PathVariable int id,@PathVariable String name,@PathVariable String comment)
    {
        ResponseEntity responseEntity;
        try {
            trackService.updateTrack(id,name,comment);
            responseEntity=new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
        }
        catch (Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllUser()
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
