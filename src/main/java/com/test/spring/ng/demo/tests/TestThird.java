package com.test.spring.ng.demo.tests;

import com.test.spring.ng.demo.service.PetService;
import io.swagger.client.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ContextConfiguration(locations = {"classpath:spring/user-context.xml" })
public class TestThird extends BasicTest {
    @Autowired
    PetService petService;
    protected static final List<String> EXPAND = new ArrayList<>(Collections.singletonList("pending"));

    @Test public void testThird() {

        List<Pet> pets = petService.findByStatus(EXPAND);
    }
}
