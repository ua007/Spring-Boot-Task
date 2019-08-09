package com.stackroute.trackService.service;

import com.stackroute.trackService.domain.Track;
import com.stackroute.trackService.exceptions.TrackAlreadyExistException;
import com.stackroute.trackService.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistException;

    public boolean deleteTrack(int id) throws TrackNotFoundException;

    public Track updateTrack(Track track) throws TrackNotFoundException;

    public List<Track> getAllTracks();

//    public List<Track> getByTrackName(String name);
//
//    public List<Track> getByTrackNameSortByName(String name);
}
