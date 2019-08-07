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

    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService)
    {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveUser(@RequestBody Track track) throws TrackAlreadyExistException
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

    @DeleteMapping("track/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.deleteUser(userId);
            responseEntity=new ResponseEntity<List<Track>>(trackService.getAllUsers(), HttpStatus.OK);
        }catch (TrackNotFoundException ex)
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
            trackService.updateUser(id,name,comment);
            responseEntity=new ResponseEntity<List<Track>>(trackService.getAllUsers(),HttpStatus.OK);
        }
        catch (Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("tracks")
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

    @GetMapping("query")
    public ResponseEntity<?> getAllTracks() {
        ResponseEntity responseEntity = new ResponseEntity<>(trackService.getAllUsers(), HttpStatus.OK);
        System.out.println(trackService.getByTrackName("hello").toString());
        System.out.println(trackService.getByTrackName("hello").toString());
        return responseEntity;

    }
}
