package com.stackroute.userService.controller;

import com.stackroute.userService.domain.Track;
import com.stackroute.userService.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class TrackController {

    TrackService trackService;

    @Autowired
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
            trackService.deleteUser(userId);
            responseEntity=new ResponseEntity<List<Track>>(trackService.getAllUsers(), HttpStatus.OK);
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
            trackService.updateUser(id,name,comment);
            responseEntity=new ResponseEntity<List<Track>>(trackService.getAllUsers(),HttpStatus.OK);
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
            return new ResponseEntity<List<Track>>(trackService.getAllUsers(), HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }
}
