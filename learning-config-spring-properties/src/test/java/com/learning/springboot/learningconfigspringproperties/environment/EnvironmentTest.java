package com.learning.springboot.learningconfigspringproperties.environment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = EnvironmentTest.TestApplication.class)
public class EnvironmentTest {

    @Autowired
    private Environment environment;

    

    @Test
    void testEnvironment() {
        String mavenHome = environment.getProperty("MAVEN_HOME");
        Assertions.assertEquals("C:\\Program Files\\Maven\\apache-maven-3.9.6", mavenHome);
    }



    @SpringBootApplication
    public static class TestApplication {
        
    }
}
