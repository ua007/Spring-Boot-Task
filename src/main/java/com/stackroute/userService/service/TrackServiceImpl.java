package com.stackroute.userService.service;

import com.stackroute.userService.domain.Track;
import com.stackroute.userService.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveUser(Track track) {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> deleteUser(int id) {
        trackRepository.deleteById(id);
        return trackRepository.findAll();
    }

    @Override
    public Track updateUser(int id, String name, String comment) {
        Optional<Track> user= trackRepository.findById(id);
        Track track =user.get();
        track.setName(name);
        track.setComment(comment);

        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllUsers() {

        return trackRepository.findAll();
    }

    @Override
    public List<Track> getByTrackName(String name) {
        return trackRepository.findByName(name);
    }

    @Override
    public List<Track> getByTrackNameSortByName(String name) {
        return trackRepository.findByNameSortById(name);
    }
}
