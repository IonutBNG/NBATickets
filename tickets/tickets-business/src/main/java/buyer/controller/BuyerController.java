package buyer.controller;

import buyer.entity.BuyerDao;
import buyer.entity.BuyerEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
public class BuyerController {

    @EJB
    BuyerDao buyerDao;

    public Long persistBuyer(String name, int spots){
        BuyerEntity buyerEntity = new BuyerEntity(name, spots);
        return this.buyerDao.persistBuyer(buyerEntity);
    }

    public String getName(Long id){
        return this.buyerDao.getName(id);
    }
}
