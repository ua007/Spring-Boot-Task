package com.stackroute.trackService.service;

import com.stackroute.trackService.domain.Track;

import java.util.List;

public interface TrackService {

    public Track saveUser(Track track) throws TrackAlreadyExistException;

    public List<Track> deleteUser(int id) throws TrackNotFoundException;

    public Track updateUser(int id, String name, String comment);

    public List<Track> getAllUsers();
}
