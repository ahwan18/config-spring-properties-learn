package com.learning.springboot.learningconfigspringproperties.messagesource;

import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.context.support.ResourceBundleMessageSource;

public class MessageSourceTest {

    private ApplicationContext applicationContext;

    private MessageSource messageSource;

    @Test
    void testDefaultLocale() {
        String message = messageSource.getMessage("hello", new Object[]{"Ahwan"}, Locale.ENGLISH);
        Assertions.assertEquals("Hello Ahwan", message);
    }

    @Test
    void testIndonesianLocale() {
        String message = messageSource.getMessage("hello", new Object[]{"Ahwan"}, new Locale("in_ID"));
        Assertions.assertEquals("Halo Ahwan", message);
    }

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestApplication.class);
        messageSource = applicationContext.getBean(MessageSource.class);
    }

    @SpringBootApplication
    public static class TestApplication {
        
        @Bean
        public MessageSource messageSource(){
            ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
            messageSource.setBasenames("my");
            return messageSource;
        }
    }
}
