package com.richasha.musicpostbackend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping
    public String testGet() {
        return "Hello";
    }

    @PostMapping
    public void testPost(@RequestBody String posting) {
        System.out.println(posting);
    }
}
