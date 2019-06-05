package buyer.boundary;

import buyer.controller.BuyerController;
import buyer.entity.dto.BuyerDto;

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

    /**
     * Calls persistBuyer method from controller
     *
     * @param buyerDto
     * @return
     */
    public Long persistBuyer(BuyerDto buyerDto) {
        return this.buyerController.persistBuyer(buyerDto);
    }

    /**
     * Calls getName method from controller
     * @param id
     * @return
     */
    public String getName(Long id){
        return this.buyerController.getName(id);
    }


}
