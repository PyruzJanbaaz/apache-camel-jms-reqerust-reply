package com.pyruz.camel.validation;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class MessageFilter {

    // You can Write your own code, this method is a simple example that shows how to you can filter junk requests
    public boolean filter(Exchange exchange) {
            String message = exchange.getIn().getHeaders().get("message").toString();
            if (message.length() <= 60 && message.contains("-")) {
                    exchange.getIn().getHeaders().get("message").toString();
                    return true;
            } else {
                System.out.println("Message has not passing through the filter layer: ");
                System.out.println("Message is invalid : " + message);
                System.out.println();
                return false;
            }
    }

}
