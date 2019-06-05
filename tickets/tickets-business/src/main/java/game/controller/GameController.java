package game.controller;

import buyer.controller.BuyerController;
import game.entity.GameDao;
import game.entity.GameEntity;
import game.entity.converter.GameConverter;
import game.entity.dto.GameDto;
import transaction.controller.TransactionController;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */

@Stateless
public class GameController {

    @EJB
    private GameDao gameDao;

    @EJB
    private GameConverter gameConverter;

    @EJB
    private TransactionController transactionController;

    @EJB
    private BuyerController buyerController;


    /**
     *
     * @return <list>GameDto</list>
     */
    public List<GameDto> getAll(){

        return this.gameDao.getAll().stream().map(this.gameConverter::convertEntityToDto).collect(Collectors.toList());
    }


    /**
     *
     * @return <list>GameDto</list>
     */
    public List<GameDto> getAllAvailable(){

        return this.gameDao.getAllAvailable().stream().map(this.gameConverter::convertEntityToDto).collect(Collectors.toList());
    }

    /**
     * Converts the dto to entity
     * Sends the entity to dao to be persisted
     * @param gameDto
     */
    public void persistGame(GameDto gameDto){
        this.gameDao.persistGame(this.gameConverter.convertDtoToEntity(gameDto));
    }


    /**
     * Calls the delete method from dao
     * @param id
     */
    public void deleteGame(Long id){
        this.gameDao.deleteGame(id);
    }

    /**
     * Calls the update method from dao
     * @param gameDto
     */
    public void updateGame(GameDto gameDto){

        this.gameDao.updatePrice(this.gameConverter.convertDtoToEntity(gameDto));
    }

    /**
     * Validates the input
     * Calls the updateSpots method from dao
     * @param gameDto
     * @param boughtTickets
     */
    public void updateSpots(GameDto gameDto, int boughtTickets, String name) {
        if (gameDto.getAvailableSpots() - boughtTickets <= 0) {
            throw null;
        }
        this.transactionController
                .persistTransaction(this.gameDao.updateSpots(this.gameConverter.convertDtoToEntity(gameDto), boughtTickets),
                        this.buyerController.persistBuyer(name, boughtTickets));
    }

    /**
     * Finds an entity by id
     * Converts the entity to dto
     * returns the dto
     * @param id
     * @return gameDto
     */
    public GameDto findById(Long id){
        GameEntity gameEntity = this.gameDao.findById(id);
        return this.gameConverter.convertEntityToDto(gameEntity);
    }

    public void emptySpots(Long id, int spots) {
        this.gameDao.emptySpots(id, spots);
    }


}
