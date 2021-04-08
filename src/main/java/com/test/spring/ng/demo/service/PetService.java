package com.test.spring.ng.demo.service;

import com.test.spring.ng.demo.integration.ApiPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final ApiPet petApi;

    public PetService(ApiPet petApi) {
        this.petApi = petApi;
    }

    //    @Autowired
//    public PetService(ApiPet petApi) {
//        this.petApi = petApi;
//    }

    public List<io.swagger.client.model.Pet> findByStatus(List<String> tags) {
        return petApi.findByStatus(tags);
    }
}
