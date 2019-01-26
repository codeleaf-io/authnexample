package io.codeleaf.example;

import io.codeleaf.authn.AuthenticationContext;
import io.codeleaf.authn.NotAuthenticatedException;
import io.codeleaf.authn.jaxrs.Authentication;
import io.codeleaf.authn.jaxrs.AuthenticationPolicy;
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
    @Path("/public")
    public String getHelloWorld_Required() {
        LOGGER.info("Are we authenticated? " + AuthenticationContext.isAuthenticated());
        return "Hello public world!";
    }

    @GET
    @Path("/hello")
    public String getHelloWorld() {
        try {
            System.out.println("hello console out!");
            LOGGER.info("Are we authenticated? " + AuthenticationContext.isAuthenticated());
            return AuthenticationContext.isAuthenticated() ?
                    AuthenticationContext.get().getIdentity() : "I am good!";
        } catch (NotAuthenticatedException e) {
            throw new IllegalStateException(e);
        }
    }

    @GET
    @Path("/admin")
    public String getHelloWorldAdmin() {
        try {
            System.out.println("hello admin!!");
            LOGGER.info("Are we authenticated? " + AuthenticationContext.isAuthenticated());
            return AuthenticationContext.isAuthenticated() ?
                    AuthenticationContext.get().getIdentity() : "I am good!";
        } catch (NotAuthenticatedException e) {
            throw new IllegalStateException(e);
        }
    }

}
