package com.test.spring.ng.demo.integration;

import com.test.spring.ng.demo.integration.client.ClientConfiguration;
import io.swagger.client.ApiException;
import io.swagger.client.api.PetApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ApiPet {
    private PetApi petApi;

    @Autowired
    private ClientConfiguration clientConfiguration;

    @PostConstruct
    public void initClientConfiguration() {
        this.petApi = new PetApi(clientConfiguration.getApiClient());;
    }

//    @Autowired
//    private void setApiPet(ClientConfiguration clientConfiguration) {
//        this.petApi = new PetApi(clientConfiguration.getApiClient());
//    }

    public List<io.swagger.client.model.Pet> findByStatus(List<String> tags) {
        try {
            return petApi.findPetsByStatus(tags);
        } catch (ApiException e) {
            throw new AssertionError("False to find pet", e);
        }
    }
}

