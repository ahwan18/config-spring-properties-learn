package com.learning.springboot.learningconfigspringproperties.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import com.learning.springboot.learningconfigspringproperties.appproperties.ApplicationPropertiesTest.TestApplication;

import lombok.Getter;

@SpringBootTest(classes = ValueTest.TestApplication.class)
public class ValueTest {

    @Autowired
    private TestApplication.PropertiesTest properties;

    @Autowired
    private TestApplication.SystemProperties environmet;

    @Test
    void testValue() {
        
        Assertions.assertEquals("Learning Config Spring Properties", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertEquals(false, properties.isProductionMode());
        Assertions.assertEquals("C:\\Program Files\\Maven\\apache-maven-3.9.6", environmet.getMavenHome());

    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        @Getter
        public static class SystemProperties {
            
            @Value("${MAVEN_HOME}")
            private String mavenHome;
        }

        @Component
        @Getter
        public static class PropertiesTest{

            @Value("${application.name}")
            private String name;

            @Value("${application.version}")
            private Integer version;

            @Value("${application.production-mode}")
            private boolean productionMode;
        }
    }
}
