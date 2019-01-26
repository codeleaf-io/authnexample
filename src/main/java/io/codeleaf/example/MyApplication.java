package io.codeleaf.example;

import io.codeleaf.authn.jaxrs.SecureApplication;
import io.codeleaf.logging.core.LogBindings;

import java.util.Collections;
import java.util.Set;

public class MyApplication extends SecureApplication {

    static {
        LogBindings.init();
    }

    public Set<Class<?>> getSecureClasses() {
        return Collections.singleton(MyService.class);
    }
}

