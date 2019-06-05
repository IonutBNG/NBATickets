package buyer.boundary;

import buyer.entity.dto.BuyerDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Path("/buyer")
@Stateless
public class BuyerResource {

    @EJB
    BuyerFacade buyerFacade;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response persistBuyer(BuyerDto buyerDto) {
        return Response.ok(this.buyerFacade.persistBuyer(buyerDto)).build();
    }
}
