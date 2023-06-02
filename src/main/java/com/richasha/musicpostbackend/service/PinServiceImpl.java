package com.richasha.musicpostbackend.service;

import com.richasha.musicpostbackend.entity.PinEntity;
import com.richasha.musicpostbackend.repo.PinRepository;
import com.richasha.musicpostbackend.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PinServiceImpl implements PinService {
    private final PinRepository pinRepository;
    private final UserRepository userRepository;
    
    @Override
    public PinEntity getPin(long pinId) throws NoSuchElementException {
        return pinRepository.findById(pinId).orElseThrow();
    }

    @Override
    public List<PinEntity> getPins(String username) {
        return pinRepository.findAllByOwner_Username(username);
    }

    @Override
    public PinEntity createPin(PinEntity pinEntity) {
        var userForPin = userRepository.findByUsername(pinEntity.getOwner().getUsername());
        pinEntity.setOwner(userForPin);
        return pinRepository.save(pinEntity);
    }

    @Override
    public void deletePin(long pinId) {
        if (pinRepository.existsById(pinId)) {
            pinRepository.deleteById(pinId);
        }
    }
}
