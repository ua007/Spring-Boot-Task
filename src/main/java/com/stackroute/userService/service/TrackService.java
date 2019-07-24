package com.stackroute.userService.service;

import com.stackroute.userService.domain.Track;
import com.stackroute.userService.exceptions.TrackAlreadyExistException;
import com.stackroute.userService.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveUser(Track track) throws TrackAlreadyExistException;

    public List<Track> deleteUser(int id) throws TrackNotFoundException;

    public Track updateUser(int id, String name, String comment);

    public List<Track> getAllUsers();

    public List<Track> getByTrackName(String name);

    public List<Track> getByTrackNameSortByName(String name);
}
