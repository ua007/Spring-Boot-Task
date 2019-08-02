package com.stackroute.userService.services;

import com.stackroute.userService.domain.Track;
import com.stackroute.userService.exceptions.TrackAlreadyExistException;
import com.stackroute.userService.exceptions.TrackNotFoundException;
import com.stackroute.userService.repository.TrackRepository;
import com.stackroute.userService.service.TrackServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceTest {



    Track track;

    @Mock
    TrackRepository trackRepository;

    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list = null;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setId(11);
        track.setName("Rihana");
        track.setArtist("Good song");
        list = new ArrayList<>();
        list.add(track);
    }


    @Test
    public void saveTrackTest() throws TrackAlreadyExistException
    {
        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedTrack = trackService.saveUser(track);
        Assert.assertEquals(track,savedTrack);
    }

    @Test
    public void getTrackTest()
    {
        trackRepository.save(track);
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> trackList = trackService.getAllUsers();
        Assert.assertEquals(list,trackList);
    }

    @Test
    public void updateTrackTest() throws TrackNotFoundException
    {
        when(trackRepository.save((Track)any())).thenReturn(track);
        Track updateTrack = null;
        try {
            updateTrack = trackService.saveUser(track);
        } catch (TrackAlreadyExistException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(track,updateTrack);
    }
}