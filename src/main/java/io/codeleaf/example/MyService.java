package io.codeleaf.example;

import io.codeleaf.authn.AuthenticationContext;
import io.codeleaf.authn.NotAuthenticatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("")
@Produces("application/json")
@Consumes("application/json")
public class MyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyService.class);

    @GET
    @Path("/auth")
    public String getHelloWorld() {
        try {
            System.out.println("hello console out!");
            System.err.println("hello console err!");
            LOGGER.info("Are we authenticated? " + AuthenticationContext.isAuthenticated());
            return AuthenticationContext.isAuthenticated() ?
                    AuthenticationContext.get().getIdentity() : "I am good!";
        } catch (NotAuthenticatedException e) {
            throw new IllegalStateException(e);
        }
    }
}
