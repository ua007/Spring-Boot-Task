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
    public Track saveTrack(Track track) throws TrackAlreadyExistException{

        if(trackRepository.existsById(track.getId()))
        {
            throw new TrackAlreadyExistException("the track already exist");
        }
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> deleteTrack(int id) throws TrackNotFoundException{
        if(trackRepository.existsById(id))
        {
            throw new TrackNotFoundException("Track not found");
        }
        trackRepository.deleteById(id);
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(int id, String name, String comment) {
        Optional<Track> user= trackRepository.findById(id);
        Track track =user.get();
        track.setName(name);
        track.setArtist(comment);

        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {

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
