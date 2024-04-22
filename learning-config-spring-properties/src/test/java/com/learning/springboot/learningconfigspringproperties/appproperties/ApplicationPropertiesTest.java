package com.learning.springboot.learningconfigspringproperties.appproperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.learning.springboot.learningconfigspringproperties.springbootmessagesource.SpringBootMessageSourceTest.TestApplication;

@SpringBootTest(classes = ApplicationPropertiesTest.TestApplication.class)
public class ApplicationPropertiesTest {

    @Autowired
    private Environment environment;

    

    @Test
    void testApplicationProperties() {
        String message = environment.getProperty("application.name");
        Assertions.assertEquals("Learning Config Spring Properties", message);
    }



    @SpringBootApplication
    public static class TestApplication {
        
    }
}
