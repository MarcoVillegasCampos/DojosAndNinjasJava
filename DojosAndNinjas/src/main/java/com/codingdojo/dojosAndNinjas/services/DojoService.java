package com.codingdojo.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosAndNinjas.models.Dojo;
import com.codingdojo.dojosAndNinjas.repositories.DojoRepository;



@Service
public class DojoService {
	
	

    private final DojoRepository dojoRepository;
    
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }

    public Dojo createDojo(Dojo l) {
        return dojoRepository.save(l);
    }
    
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalLanguage = dojoRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    

    }
}

