package io.codeleaf.authn.example;

import io.codeleaf.authn.jaxrs.spi.JaxrsAuthenticationFilterFactory;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class MyApplication extends Application {

    public java.util.Set<java.lang.Object> getSingletons() {
        System.out.println("I am here!");
        Set<java.lang.Object> set = new HashSet<>();
        JaxrsAuthenticationFilterFactory factory = JaxrsAuthenticationFilterFactory.create();
        set.add(factory.createRequestFilter());
        set.add(factory.createResponseFilter());
        set.add(new MyService());
        return set;
    }
}

