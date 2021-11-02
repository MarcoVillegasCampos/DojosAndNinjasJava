package com.codingdojo.dojosAndNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosAndNinjas.models.Ninja;
import com.codingdojo.dojosAndNinjas.repositories.NinjaRepository;


@Service
public class NinjaService {


    private final NinjaRepository ninjaRepository;
    
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
 
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }

    public Ninja createNinja(Ninja l) {
        return ninjaRepository.save(l);
    }
    
}
