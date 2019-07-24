package com.stackroute.userService.service;

import com.stackroute.userService.domain.Track;

import java.util.List;

public interface TrackService {

    public Track saveUser(Track track);

    public List<Track> deleteUser(int id);

    public Track updateUser(int id, String name, String comment);

    public List<Track> getAllUsers();
}
