package com.pyruz.camel.validation;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class MessageValidator {

    // You can Write your own code, this method is a simple example that shows how to you can validate content of requests
    public boolean validation(Exchange exchange) {
        String message = exchange.getIn().getHeaders().get("message").toString();
        if (checkUSerExist(message.split(";")[1])) {
            System.out.println("Message is valid!");
            return true;
        } else {
            return false;
        }
    }

    private Boolean checkUSerExist(String userId) {
        // for example you can connect to DB and check user exist by userId
        if (userId.equals("USERNAME"))
            return true;
        else return false;
    }

}
