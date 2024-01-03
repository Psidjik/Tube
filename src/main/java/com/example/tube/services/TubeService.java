package com.example.tube.services;

import com.example.tube.dto.TubeDto;
import com.example.tube.models.Tube;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TubeService {
    List<TubeDto> getAllTubes();

    void addTube(TubeDto tubeDto);

    TubeDto updateTubePrice(int length, int price);

    Integer fullPriceForOrder(int length);
}
