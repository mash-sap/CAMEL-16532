package de.mash.demo;

import org.apache.camel.impl.event.ExchangeCompletedEvent;
import org.apache.camel.spi.CamelEvent;
import org.apache.camel.support.EventNotifierSupport;

public class MyNotifier extends EventNotifierSupport {

    public MyNotifier(){
        System.out.println("Notifier created");
    }

    @Override
    public void notify(CamelEvent event) throws Exception {
        System.out.println("Exchange Notifier event " + event.getClass());
        if (event instanceof ExchangeCompletedEvent) {
            System.out.println("ExchangeCompletedEvent");
        }
    }
}
