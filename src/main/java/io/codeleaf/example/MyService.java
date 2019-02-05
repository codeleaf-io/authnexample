package io.codeleaf.example;

import io.codeleaf.authn.jaxrs.Authentication;
import io.codeleaf.authn.jaxrs.AuthenticationPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Path("")
@Produces("application/json")
@Consumes("application/json")
public class MyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyService.class);

    @Context
    private SecurityContext securityContext;

    @GET
    @Path("/nozone")
    public String getNoZone() {
        System.out.println("hello no zone!");
        LOGGER.info("Are we authenticated? " + (securityContext.getUserPrincipal() != null));
        return securityContext.getUserPrincipal() != null ? securityContext.getUserPrincipal().getName() : "I am good!";
    }

    @GET
    @Path("/annotation")
    @Authentication(value = AuthenticationPolicy.REQUIRED, authenticator = "basic")
    public String getAnnotation() {
        System.out.println("hello annotation!");
        LOGGER.info("Are we authenticated? " + (securityContext.getUserPrincipal() != null));
        return securityContext.getUserPrincipal() != null ? securityContext.getUserPrincipal().getName() : "I am good!";
    }

    @GET
    @Path("/public")
    public String getHelloWorldPublic() {
        return "Hello public world!";
    }

    @GET
    @Path("/hello")
    public String getHelloWorld() {
        System.out.println("hello console out!");
        LOGGER.info("Are we authenticated? " + (securityContext.getUserPrincipal() != null));
        return securityContext.getUserPrincipal() != null ? securityContext.getUserPrincipal().getName() : "I am good!";
    }

    @GET
    @Path("/admin")
    public String getHelloWorldAdmin() {
        System.out.println("hello admin!!");
        return "Welcome admin " + securityContext.getUserPrincipal().getName();
    }
}
