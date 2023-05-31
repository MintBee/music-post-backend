package com.richasha.musicpostbackend.service;

import com.richasha.musicpostbackend.entity.PinEntity;

import java.util.List;
import java.util.NoSuchElementException;

public interface PinService {
    PinEntity getPin(long pinId) throws NoSuchElementException;

    List<PinEntity> getPins(String username);

    PinEntity createPin(PinEntity pinDto);

    void deletePin(PinEntity pinEntity);

    void deletePin(long PinId);
}
