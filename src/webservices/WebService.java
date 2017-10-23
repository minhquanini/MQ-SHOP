package webservices;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath ("/ws")
public class WebService extends ResourceConfig{

	public WebService() {
        // register(JacksonFeature.class);
        packages(this.getClass().getPackage().getName());
	}
}
