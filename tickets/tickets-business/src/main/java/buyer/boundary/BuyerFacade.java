package buyer.boundary;

import buyer.controller.BuyerController;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */

@Stateless
public class BuyerFacade {

    @EJB
    BuyerController buyerController;

    public Long persistBuyer(String name, int spots){

        return this.buyerController.persistBuyer(name, spots);
    }

    public String getName(Long id){
        return this.buyerController.getName(id);
    }


}
