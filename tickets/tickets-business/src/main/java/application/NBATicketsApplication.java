package application;

import buyer.boundary.BuyerResource;
import filter.CorsFilter;
import game.boundary.GameResource;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */

@ApplicationPath("tickets-api")
public class NBATicketsApplication extends Application {

    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<>();
        classes.add(GameResource.class);
        classes.add(BuyerResource.class);
        classes.add(CorsFilter.class);

        return super.getClasses();
    }

    @Override
    public Set<Object> getSingletons(){
        Set<Object> singletons = new HashSet<>();
        singletons.add(new JacksonJsonProvider());
        return super.getSingletons();
    }

}
