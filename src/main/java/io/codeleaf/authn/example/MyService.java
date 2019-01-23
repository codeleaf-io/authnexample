package io.codeleaf.authn.example;

import io.codeleaf.authn.AuthenticationContext;
import io.codeleaf.authn.NotAuthenticatedException;

import javax.ws.rs.GET;

public class MyService {
    @GET
    public String getHelloWorld() {
        try {
            System.out.println("OK........");
            return AuthenticationContext.isAuthenticated() ?
                    AuthenticationContext.get().getIdentity() : "I am good!";
        } catch (NotAuthenticatedException e) {
            throw new IllegalStateException(e);
        }
    }
}
