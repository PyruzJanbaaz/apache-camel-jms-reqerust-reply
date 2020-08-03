package com.pyruz.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Starter {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = SpringCamelContext.springCamelContext(new ClassPathXmlApplicationContext("camel-spring-configuration.xml"), false);
        camelContext.start();

    }
}
