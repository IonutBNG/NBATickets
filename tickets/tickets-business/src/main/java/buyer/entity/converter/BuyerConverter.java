package buyer.entity.converter;

import buyer.entity.BuyerEntity;
import buyer.entity.dto.BuyerDto;

import javax.ejb.Stateless;

/**
 * @author Bungardean Tudor-Ionut
 * @since 19.1.2
 */

@Stateless
public class BuyerConverter {

    public BuyerEntity convertDtoToEntity(BuyerDto buyerDto) {
        return new BuyerEntity(buyerDto.getName(), buyerDto.getSpots());
    }
}
