package club.tempvs.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("api")
public class Api {

    @HeaderParam("token")
    private String token;

    @GET
    @Path("ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPong() {
        return "pong!";
    }
}
