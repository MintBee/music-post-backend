package com.richasha.musicpostbackend.service;

import com.richasha.musicpostbackend.entity.PinEntity;
import com.richasha.musicpostbackend.entity.UserEntity;

import java.util.List;
import java.util.NoSuchElementException;

public interface PinService {
    PinEntity getPin(long pinId) throws NoSuchElementException;

    List<PinEntity> getPins(UserEntity user);

    PinEntity createPin(PinEntity pinDto);

    void deletePin(PinEntity pinEntity);

    PinEntity deletePin(long PinId);
}
