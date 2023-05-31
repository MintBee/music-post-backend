package com.richasha.musicpostbackend.controller;

import com.richasha.musicpostbackend.dto.PinDto;
import com.richasha.musicpostbackend.mapper.entitydto.PinMapper;
import com.richasha.musicpostbackend.service.PinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pin")
public class PinController {
    private final PinService pinService;
    private final PinMapper pinMapper;

    @GetMapping
    public List<PinDto> getPins(@RequestParam String username) {
        return pinService.getPins(username).stream()
                .map(pinMapper::toDto).toList();
    }


    @PostMapping
    public PinDto createPin(@RequestBody PinDto pinDto) {
        var newPinEntity = pinMapper.toEntity(pinDto);
        return pinMapper.toDto(pinService.createPin(newPinEntity));
    }

    @DeleteMapping("{id}")
    public void deletePin(@PathVariable("id") Long pinId) {
        pinService.deletePin(pinId);
    }
}
