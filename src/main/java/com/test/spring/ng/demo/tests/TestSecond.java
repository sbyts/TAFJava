package com.test.spring.ng.demo.tests;

import com.test.spring.ng.demo.TestNGWithSpringApplication;
import com.test.spring.ng.demo.service.PetService;
import io.swagger.client.model.Pet;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ContextConfiguration(locations = {"classpath:spring/other-user-context.xml" })
public class TestSecond extends BasicTest {
    @Autowired PetService petService;
    protected static final List<String> EXPAND = new ArrayList<>(Collections.singletonList("pending"));

    @Test public void testSecond() {
        List<Pet> pets = petService.findByStatus(EXPAND);
    }
}
