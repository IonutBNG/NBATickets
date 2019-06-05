package buyer.controller;

import buyer.entity.BuyerDao;
import buyer.entity.BuyerEntity;
import buyer.entity.converter.BuyerConverter;
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
public class BuyerController {

    @EJB
    private BuyerDao buyerDao;

    @EJB
    private BuyerConverter buyerConverter;

    /**
     * Creates buyer entity
     * Calls persistBuyer method from dao
     *
     * @param buyerDto
     * @return
     */
    public Long persistBuyer(BuyerDto buyerDto) {
        return this.buyerDao
                .persistBuyer(this.buyerConverter.convertDtoToEntity(buyerDto));
    }

    /**
     * Creates buyer entity
     * Calls persistBuyer method from dao
     *
     * @param name  the name of the buyer
     * @param spots the number of bought spots/tickets
     * @return
     */
    public Long persistBuyer(String name, int spots) {
        return this.buyerDao
                .persistBuyer(new BuyerEntity(name, spots));
    }

    /**
     * Calls getName method from dao
     * @param id
     * @return
     */
    public String getName(Long id){
        return this.buyerDao.getName(id);
    }

    public int getSpots(Long id) {
        return this.buyerDao.getSpots(id);
    }

    public void deleteBuyer(Long buyerID) {
        this.buyerDao.deleteBuyer(buyerID);
    }
}
