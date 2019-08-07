package com.stackroute.userService.service;

import com.stackroute.userService.domain.Track;
import com.stackroute.userService.exceptions.TrackAlreadyExistException;
import com.stackroute.userService.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistException;

    public boolean deleteTrack(int id) throws TrackNotFoundException;

    public Track updateTrack(Track track) throws TrackNotFoundException;

    public List<Track> getAllTracks();

    public List<Track> getByTrackName(String name);

    public List<Track> getByTrackNameSortByName(String name);
}
