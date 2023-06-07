package com.nedeco.razaul.photoz.clone;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.*;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class photozController {
    private final PhotozService photozService;

    public photozController(PhotozService photozService) {
        this.photozService = photozService;
    }

    @GetMapping("/")
    public String helloMessage() {
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Collection<Photo> getPhoto() {
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo getPhotos(@PathVariable String id) {
        Photo photo = photozService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void DeletePhotos(@PathVariable String id) {
        Photo photo = photozService.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {

        Photo photo = photozService.save(file.getOriginalFilename(), file.getBytes());
        return photo;
    }
}
