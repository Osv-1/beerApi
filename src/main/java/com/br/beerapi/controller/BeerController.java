package com.br.beerapi.controller;


import com.br.beerapi.dto.BeerDTO;
import com.br.beerapi.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/beers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerController {

    private BeerService beerService;

    @GetMapping
    public List<BeerDTO> listBeers() {
        return beerService.listAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerDTO createBeer(@RequestBody @Valid BeerDTO beerDTO) {
        return beerService.createBeer(beerDTO);
    }


}
