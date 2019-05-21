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

    public Long persistBuyer(BuyerEntity buyerEntity){
        this.entityManager.persist(buyerEntity);
        this.entityManager.flush();
        return this.entityManager
                .createNamedQuery(BuyerEntity.GET_ID, Long.class)
                .getSingleResult();

    }

    public String getName(Long id) {
        return this.entityManager
                .createNamedQuery(BuyerEntity.GET_NAME, String.class)
                .setParameter(BuyerEntity.ID, id)
                .getSingleResult();
    }
}
