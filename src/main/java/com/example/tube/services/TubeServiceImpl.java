package com.example.tube.services;

import com.example.tube.dto.TubeDto;
import com.example.tube.models.Tube;
import com.example.tube.repositories.TubeRepos;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TubeServiceImpl implements TubeService{

    private ModelMapper modelMapper;
    private TubeRepos tubeRepos;


    @Override
    public List<TubeDto> getAllTubes() {
        return tubeRepos.findAll().stream().map(tube -> modelMapper.map(tube, TubeDto.class)).collect(Collectors.toList());
    }

    @Override
    public void addTube(TubeDto tubeDto) {
        Tube tube = modelMapper.map(tubeDto, Tube.class);
        tube.setCoef((tube.getPrice())/(tube.getLength()));
        tubeRepos.save(tube);
    }

    @Override
    public TubeDto updateTubePrice(int length, int price) {
        Tube tube = tubeRepos.findTubeByLength(length).orElseThrow();
        tube.setPrice(price);
        tubeRepos.save(tube);
        return modelMapper.map(tube, TubeDto.class);
    }

    @Override
    public Integer fullPriceForOrder(int lengthTubeForOrder) {
        List<Tube> tubes = tubeRepos.allTubesByCoefASC();
        int allPrice = 0;
        for(int i = 0; i < tubes.size(); i++){
            while (tubes.get(i).getLength() <= lengthTubeForOrder)
            {
                lengthTubeForOrder = lengthTubeForOrder-tubes.get(i).getLength();
                allPrice += tubes.get(i).getPrice();
            }
        }

        return allPrice;
    }




    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Autowired
    public void setTubeRepos(TubeRepos tubeRepos) {
        this.tubeRepos = tubeRepos;
    }
}
