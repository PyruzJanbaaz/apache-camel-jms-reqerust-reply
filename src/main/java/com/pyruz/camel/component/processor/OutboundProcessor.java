package com.pyruz.camel.component.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class OutboundProcessor implements Processor {

    public void process(Exchange exchange) {
        String message = exchange.getIn().getBody(String.class);
        exchange.getOut().setBody(message);
    }


}
