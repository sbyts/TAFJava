package com.test.spring.ng.demo.tests;

import com.test.spring.ng.demo.service.PetService;
import com.test.spring.ng.demo.utils.MultiThreadRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ContextConfiguration(locations = {"classpath:spring/user-context.xml" })
public class TestParallel extends BasicTest {
    @Autowired
    PetService petService;
    protected static final List<String> EXPAND = new ArrayList<>(Collections.singletonList("pending"));

    @Test
    public void testParallel() {
        Runnable request = () -> petService.findByStatus(EXPAND);
        new MultiThreadRunner(2, 2).fireIt(request);
    }
}
