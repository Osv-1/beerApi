package com.br.beerapi.mapper;

import com.br.beerapi.dto.BeerDTO;
import com.br.beerapi.model.Beer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    Beer toModel(BeerDTO beerDTO);

    BeerDTO toDTO(Beer beer);

}