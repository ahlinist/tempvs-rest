package club.tempvs.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * This class to be extended with each particular microservice. Provides a pingable skeleton with context path: "api".
 */
@Path("api")
public class Api {

    /**
     * A method that is being exposed with URI <i>/api/ping</i>. Accepts GET HTTP-Request and responds with
     * <i>pong!</i> text.
     * @return "pong!" {@link String}
     */
    @GET
    @Path("ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPong() {
        return "pong!";
    }
}
