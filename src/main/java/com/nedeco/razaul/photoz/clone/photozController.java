package com.nedeco.razaul.photoz.clone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpRequest;
import java.util.*;

@RestController
public class photozController {
    private Map<String, Photo> db = new HashMap<>(){{
        put("1",new Photo("hello.jpg","1" ));
    }};

    @GetMapping("/")
    public String helloMessage(){
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Collection<Photo> getPhoto(){
        return db.values();
    }

    @GetMapping("/photoz/{id}")
    public Photo getPhotos(@PathVariable String id){
    Photo photo = db.get(id);
    if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void DeletePhotos(@PathVariable String id){
        Photo photo = db.remove(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photoz/")
    public Photo create(@RequestBody Photo photo){
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(),photo);
        return photo;
    }
}
