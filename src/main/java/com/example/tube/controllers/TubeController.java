package com.example.tube.controllers;

import com.example.tube.dto.TubeDto;
import com.example.tube.models.Tube;
import com.example.tube.services.TubeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tube")
public class TubeController {

    private TubeService tubeService;

    @PostMapping("/add")
    public HttpEntity<HttpStatus> addTube(@Valid @RequestBody TubeDto tubeDto){
        tubeService.addTube(tubeDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/all")
    List<TubeDto> getAllTubes(){
        return tubeService.getAllTubes();
    }

    @PostMapping("/update/{length}/{price}")
    TubeDto updatePrice(@PathVariable int length, @PathVariable int price){
        return tubeService.updateTubePrice(length, price);
    }

    @GetMapping("/shop/{length}")
    Integer order(@PathVariable int length){
        return tubeService.fullPriceForOrder(length);
    }

    @Autowired
    public void setTubeService(TubeService tubeService) {
        this.tubeService = tubeService;
    }
}
