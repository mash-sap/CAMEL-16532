package de.mash.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("######################################## processor called ####################################");
    }
}
