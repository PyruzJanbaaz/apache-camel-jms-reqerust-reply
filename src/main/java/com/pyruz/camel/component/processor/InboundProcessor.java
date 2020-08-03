package com.pyruz.camel.component.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class InboundProcessor implements Processor {

    public void process(Exchange exchange) {
        String message = exchange.getIn().getHeaders().get("message").toString();
        if (exchange.getIn().getHeaders().get("message").toString().startsWith("#")) {
            exchange.getOut().setBody(message + "XX");
        } else {
            exchange.getOut().setBody(message + "YY");
        }
    }

}
