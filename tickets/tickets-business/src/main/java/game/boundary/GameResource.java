package game.boundary;

import game.entity.dto.GameDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */

@Path("/game")
@Stateless
public class GameResource {

    @EJB
    GameFacade gameFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<GameDto> getAll(){
        return this.gameFacade.getAll();
    }

    @GET
    @Path("/available")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GameDto> getAllAvailable(){
        return this.gameFacade.getAllAvailable();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response persistGame(GameDto gameDto){
        this.gameFacade.persistGame(gameDto);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteGame(@PathParam("id") Long id){
        this.gameFacade.deleteGame(id);
        return Response.ok().build();
    }

    @PUT
    @Path("{boughtTickets}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSpots(@PathParam("boughtTickets") int boughtTickets, GameDto gameDto){
        this.gameFacade.updateSpots(gameDto, boughtTickets);
        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id){
        return Response.ok(this.gameFacade.findById(id)).build();
    }



}
