package transaction.entity.converter;

import transaction.entity.TransactionEntity;
import transaction.entity.dto.TransactionDto;

import javax.ejb.Stateless;

/**
 * @author Bungardean Tudor-Ionut
 * @since 19.1.2
 */
@Stateless
public class TransactionConverter {

    public TransactionEntity convertDtoToEntity(TransactionDto transactionDto) {
        return new TransactionEntity(transactionDto.getGameID(), transactionDto.getBuyerID(), transactionDto.getTimestamp());
    }
}
