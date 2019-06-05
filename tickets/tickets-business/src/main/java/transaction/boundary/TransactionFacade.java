package transaction.boundary;

import transaction.controller.TransactionController;
import transaction.entity.TransactionEntity;
import transaction.entity.dto.TransactionDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
public class TransactionFacade {

    @EJB
    TransactionController transactionController;

    public void persistTransaction(Long gameId, Long buyerId) {
        this.transactionController.persistTransaction(gameId, buyerId);
    }

    public List<TransactionEntity> getAllById(Long id) {
        return this.transactionController.getAllById(id);
    }

    public List<TransactionEntity> getAll() {
        return this.transactionController.getAll();
    }

    public void deleteTransaction(TransactionDto transactionDto) {
        this.transactionController.deleteTransaction(transactionDto);
    }
}
