package com.richasha.musicpostbackend.service;

import com.richasha.musicpostbackend.entity.PinEntity;
import com.richasha.musicpostbackend.entity.UserEntity;
import com.richasha.musicpostbackend.repo.PinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PinServiceImpl implements PinService {
    private final PinRepository pinRepository;
    
    @Override
    public PinEntity getPin(long pinId) throws NoSuchElementException {
        return pinRepository.findById(pinId).orElseThrow();
    }

    @Override
    public List<PinEntity> getPins(UserEntity user) {
        return pinRepository.findAllByOwner(user);
    }

    @Override
    public PinEntity createPin(PinEntity pinEntity) {
        return pinRepository.save(pinEntity);
    }

    @Override
    public void deletePin(PinEntity pinEntity) {
        pinRepository.delete(pinEntity);
    }

    @Override
    public PinEntity deletePin(long PinId) {
        return null;
    }
}
