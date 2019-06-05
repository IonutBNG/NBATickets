package transaction.boundary;

import transaction.entity.TransactionEntity;
import transaction.entity.dto.TransactionDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Bungardean Tudor-Ionut
 * @since 19.1.2
 */

@Path("/transaction")
@Stateless
public class TransactionResource {

    @EJB
    private TransactionFacade transactionFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TransactionEntity> getAll() {
        return this.transactionFacade.getAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TransactionEntity> getAllByGameId(@PathParam("id") Long id) {
        return this.transactionFacade.getAllById(id);
    }

    @PUT
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteTransaction(TransactionDto transactionDto) {
        this.transactionFacade.deleteTransaction(transactionDto);
        return Response.ok().build();
    }


}
