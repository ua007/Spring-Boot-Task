package com.stackroute.trackService.service;

import com.stackroute.trackService.domain.Track;
import com.stackroute.trackService.repository.TrackRepository;
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
    public Track saveUser(Track track) throws TrackAlreadyExistException {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> deleteUser(int id) throws TrackNotFoundException {
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
}
