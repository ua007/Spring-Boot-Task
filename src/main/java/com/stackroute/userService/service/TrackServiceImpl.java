package com.stackroute.userService.service;

import com.stackroute.userService.domain.Track;
import com.stackroute.userService.exceptions.TrackAlreadyExistException;
import com.stackroute.userService.exceptions.TrackNotFoundException;
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
    public Track saveUser(Track track) throws TrackAlreadyExistException{

        if(trackRepository.existsById(track.getId()))
        {
            throw new TrackAlreadyExistException("the track already exist");
        }
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public boolean deleteUser(int id) throws TrackNotFoundException{
        if(trackRepository.existsById(id))
        {
            throw new TrackNotFoundException("Track not found");
        }
        trackRepository.deleteById(id);
        return true;
    }

    @Override
    public Track updateUser(Track track) throws TrackNotFoundException{
        if(trackRepository.existsById(track.getId()))
        {
            Track updateTrack=trackRepository.save(track);
            return updateTrack;
        }

        else {
            throw new TrackNotFoundException("ID doesn't exist");
        }
    }

    @Override
    public List<Track> getAllUsers() {

        return trackRepository.findAll();
    }

//    @Override
//    public List<Track> getByTrackName(String name) {
//        return trackRepository.findByName(name);
//    }
//
//    @Override
//    public List<Track> getByTrackNameSortByName(String name) {
//        return trackRepository.findByNameSortById(name);
//    }
}
