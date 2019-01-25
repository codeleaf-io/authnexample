package io.codeleaf.example;

import io.codeleaf.authn.jaxrs.spi.JaxrsAuthenticationFilterFactory;
import io.codeleaf.logging.core.LogBindings;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class MyApplication extends Application {

    static {
        LogBindings.init();
    }

    public java.util.Set<java.lang.Object> getSingletons() {
        Set<java.lang.Object> set = new HashSet<>();
        JaxrsAuthenticationFilterFactory factory = JaxrsAuthenticationFilterFactory.create();
        set.add(factory.createRequestFilter());
        set.add(factory.createResponseFilter());
        set.add(new MyService());
        return set;
    }
}

