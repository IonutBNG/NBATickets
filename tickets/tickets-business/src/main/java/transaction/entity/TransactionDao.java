package transaction.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
public class TransactionDao {

    @PersistenceContext(unitName = "tickets-persistence")
    EntityManager entityManager;

    /**
     * Persists transaction into the database
     *
     * @param transactionEntity
     */
    public void persistTransaction(TransactionEntity transactionEntity) {
        this.entityManager
                .persist(transactionEntity);
    }

    /**
     * Extracts all the transactions from the database that validate the id
     *
     * @return <list>TransactionEntity</list>
     */
    public List<TransactionEntity> getAllById(Long id) {
        return this.entityManager
                .createNamedQuery(TransactionEntity.GET_ALL_BY_GAME_ID, TransactionEntity.class)
                .setParameter(TransactionEntity.GAME_ID, id)
                .getResultList();
    }

    /**
     * Extracts all the transactions from the database
     *
     * @return <list>TransactionEntity</list>
     */
    public List<TransactionEntity> getAll() {
        return this.entityManager
                .createNamedQuery(TransactionEntity.SELECT_ALL, TransactionEntity.class)
                .getResultList();
    }

    public void deleteTransaction(TransactionEntity transactionEntity) {
        this.entityManager
                .createNamedQuery(TransactionEntity.ENTITY_DELETE, TransactionEntity.class)
                .setParameter(TransactionEntity.GAME_ID, transactionEntity.getGameID())
                .setParameter(TransactionEntity.BUYER_ID, transactionEntity.getBuyerID())
                .executeUpdate();
    }
}
