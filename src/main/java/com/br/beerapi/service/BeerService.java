package com.br.beerapi.service;

import com.br.beerapi.dto.BeerDTO;
import com.br.beerapi.mapper.BeerMapper;
import com.br.beerapi.model.Beer;
import com.br.beerapi.repository.BeerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerService {

    private  BeerRepository beerRepository;
    private  BeerMapper beerMapper = BeerMapper.INSTANCE;


    public List<BeerDTO> listAll() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BeerDTO createBeer(BeerDTO beerDTO)  {
        Beer beer = beerMapper.toModel(beerDTO);
        Beer savedBeer = beerRepository.save(beer);
        return beerMapper.toDTO(savedBeer);
    }


}
