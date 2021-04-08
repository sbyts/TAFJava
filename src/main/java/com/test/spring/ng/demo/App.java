package com.test.spring.ng.demo;

import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        TestNG runner=new TestNG();
        List<String> suitefiles= new ArrayList<>();

        suitefiles.add(args[0]);

        // now set xml file for execution
        runner.setTestSuites(suitefiles);
        runner.run();
    }
}
