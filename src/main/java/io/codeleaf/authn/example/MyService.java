package io.codeleaf.authn.example;

import io.codeleaf.authn.AuthenticationContext;
import io.codeleaf.authn.NotAuthenticatedException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("")
@Produces("application/json")
@Consumes("application/json")
public class MyService {

    @GET
    @Path("/auth")
    public String getHelloWorld() {
        try {
            return AuthenticationContext.isAuthenticated() ?
                    AuthenticationContext.get().getIdentity() : "I am good!";
        } catch (NotAuthenticatedException e) {
            throw new IllegalStateException(e);
        }
    }
}
