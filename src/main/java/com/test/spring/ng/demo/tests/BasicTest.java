package com.test.spring.ng.demo.tests;

import com.test.spring.ng.demo.TestNGWithSpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@PropertySource({"classpath:/application.properties" })
@SpringBootTest(classes = TestNGWithSpringApplication.class)
public class BasicTest extends AbstractTestNGSpringContextTests {
}
