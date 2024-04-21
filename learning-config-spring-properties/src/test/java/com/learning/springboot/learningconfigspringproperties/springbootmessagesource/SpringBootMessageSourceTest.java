package com.learning.springboot.learningconfigspringproperties.springbootmessagesource;

import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import com.learning.springboot.learningconfigspringproperties.messagesource.MessageSourceTest.TestApplication;
import com.learning.springboot.learningconfigspringproperties.resourceloader.ResourceLoadertTest.TestApplication.SampleResource;

import lombok.Setter;

@SpringBootTest(classes = SpringBootMessageSourceTest.TestApplication.class)
public class SpringBootMessageSourceTest {

    @Autowired
    private TestApplication.SampleSource sampleSource;

    @Test
    void testHelloMessage() {
        Assertions.assertEquals("Hello Ahwan", sampleSource.helloAhwan(Locale.ENGLISH));
        Assertions.assertEquals("Halo Ahwan", sampleSource.helloAhwan(new Locale("in_ID")));
    }

    @SpringBootApplication
    public static class TestApplication {
        
        @Component
        public static class SampleSource implements MessageSourceAware {
        
            @Setter
            private MessageSource messageSource;

            public String helloAhwan(Locale locale){
                return messageSource.getMessage("hello", new Object[]{"Ahwan"}, locale);
            }
        }
    }
}
