package com.test.spring.ng.demo.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:spring/user-context.xml" })
public class TestFirst extends BasicTest {
    @Test public void testFirst() {
        Assert.assertEquals(2 * 2, 4, "2x2 should be 4");
        System.out.println("Bingo");
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
    }
}
