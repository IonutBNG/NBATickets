package buyer.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
public class BuyerDao {

    @PersistenceContext(unitName = "tickets-persistence")
    EntityManager entityManager;

    /**
     * Persists a buyer
     * Returns the id
     *
     * @param buyerEntity
     * @return
     */
    public Long persistBuyer(BuyerEntity buyerEntity){
        this.entityManager.persist(buyerEntity);
        this.entityManager.flush();
        return this.entityManager
                .createNamedQuery(BuyerEntity.GET_ID, Long.class)
                .getSingleResult();

    }

    /**
     * Extracts the name from the database
     * @param id
     * @return
     */
    public String getName(Long id) {
        return this.entityManager
                .createNamedQuery(BuyerEntity.GET_NAME, String.class)
                .setParameter(BuyerEntity.ID, id)
                .getSingleResult();
    }

    public int getSpots(Long id) {
        return this.entityManager
                .createNamedQuery(BuyerEntity.GET_SPOTS, Integer.class)
                .setParameter(BuyerEntity.ID, id)
                .getSingleResult();
    }

    public void deleteBuyer(Long buyerID) {
        this.entityManager
                .createNamedQuery(BuyerEntity.DELETE_BUYER)
                .setParameter(BuyerEntity.ID, buyerID)
                .executeUpdate();
    }
}
