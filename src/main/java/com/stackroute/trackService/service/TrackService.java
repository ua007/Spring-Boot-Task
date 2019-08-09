package com.stackroute.trackService.service;

import com.stackroute.trackService.domain.Track;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track);

    public List<Track> deleteTrack(int id);

    public Track updateTrack(int id, String name, String comment);

    public List<Track> getAllTracks();
}
