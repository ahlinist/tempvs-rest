package club.tempvs.rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * This class launches the tempvs-rest web application in an embedded Jetty container. This is the entry point to the
 * application. Extend this class to add more end-points to your REST-api.
 */
public class Main {

    private static final String WEBAPP_LOCATION = "src/main/webapp/";
    private static String webPort = System.getenv("PORT");

    public static void main(String[] args) throws Exception {
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        final Server server = new Server(Integer.valueOf(webPort));
        final WebAppContext root = new WebAppContext();

        root.setContextPath("/");
        // Parent loader priority is a class loader setting that Jetty accepts.
        // By default Jetty will behave like most web containers in that it will
        // allow your application to replace non-server libraries that are part of the
        // container. Setting parent loader priority to true changes this behavior.
        // Read more here: http://wiki.eclipse.org/Jetty/Reference/Jetty_Classloading
        root.setParentLoaderPriority(true);
        root.setResourceBase(WEBAPP_LOCATION);
        server.setHandler(root);
        server.start();
        server.join();
    }
}
