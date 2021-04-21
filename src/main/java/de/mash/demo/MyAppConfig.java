package de.mash.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.component.cxf.DataFormat;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {
    //https://camel.apache.org/camel-spring-boot/3.7.x/spring-boot.html
    //    @Autowired
    //    CamelContext camelContext;

    @Bean
    public ServletRegistrationBean disServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/cxf/*");
    }

//    @Autowired
//    private Bus bus;
//
//    @Bean(name = Bus.DEFAULT_BUS_ID)
//    public Bus springBus() {
//        return new SpringBus();
//    }
//
//    @Bean
//    public CxfEndpoint customerServiceEndpoint() {
//        CxfEndpoint cxfEndpoint = new CxfEndpoint();
////        cxfEndpoint.setAddress("http://127.0.0.1:8080/cxf/manuel");
//        cxfEndpoint.setAddress("/test");
//        cxfEndpoint.setBus(bus);
//        cxfEndpoint.setDataFormat(DataFormat.PAYLOAD);
//        return cxfEndpoint;
//    }
//
//    @Bean
//    RoutesBuilder first() {
//        return new RouteBuilder() {
//            @Autowired
//            private CxfEndpoint endpoint;
//
//            @Override
//            public void configure() throws Exception {
//                String url = endpoint.getPublishedEndpointUrl();
//                System.out.println(url);
//                from(endpoint).routeId("eager").bean(MyBean.class, "saySomething()").to("mock:result");
////                return new RouteBuilder() {
////                    @Override
////                    public void configure() throws Exception {
////                        from("timer:hello?period=1000").routeId("eager").bean(MyBean.class, "saySomething()").to("mock:result");
//                System.out.println(endpoint.getPublishedEndpointUrl());
//                System.out.println(endpoint.getPublishedEndpointUrl());
//            }
//
//        };
//    }
//
//    @Bean
//    RoutesBuilder second() {
//        return new RouteBuilder() {
//
//            @Override
//            public void configure() throws Exception {
//                from("timer:hello?period=100").routeId("lazy").noAutoStartup().bean(MyBean.class, "saySomething()").to("mock:result");
//            }
//
//        };
//    }

}
