package transaction.controller;

import buyer.controller.BuyerController;
import game.controller.GameController;
import transaction.entity.TransactionDao;
import transaction.entity.TransactionEntity;
import transaction.entity.converter.TransactionConverter;
import transaction.entity.dto.TransactionDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
public class TransactionController {

    @EJB
    private TransactionDao transactionDao;

    @EJB
    private GameController gameController;

    @EJB
    private BuyerController buyerController;

    @EJB
    private TransactionConverter transactionConverter;

    /**
     * Gets the current datetime
     * Formats after a certain pattern
     * Creates a new TransactionEntity
     * Calls the persistTransaction method from dao
     *
     * @param gameId
     * @param buyerId
     */
    public void persistTransaction(Long gameId, Long buyerId) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String timestamp = myDateObj.format(myFormatObj);
        this.transactionDao.persistTransaction(new TransactionEntity(gameId, buyerId, timestamp));
    }

    /**
     * Calls getAllById method from dao
     *
     * @param id
     * @return
     */
    public List<TransactionEntity> getAllById(Long id) {
        return this.transactionDao.getAllById(id);
    }

    /**
     * Calls getAll method from dao
     *
     * @return
     */
    public List<TransactionEntity> getAll() {
        return this.transactionDao.getAll();
    }

    /**
     * Calls deleteTransaction from dao
     *
     * @param transactionDto
     */
    public void deleteTransaction(TransactionDto transactionDto) {
        TransactionEntity transactionEntity = transactionConverter.convertDtoToEntity(transactionDto);
        this.gameController.emptySpots(transactionEntity.getGameID(), this.buyerController.getSpots(transactionEntity.getBuyerID()));
        this.buyerController.deleteBuyer(transactionEntity.getBuyerID());
        this.transactionDao.deleteTransaction(transactionEntity);
    }
}
