package game.boundary;

import game.controller.GameController;
import game.entity.dto.GameDto;

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
public class GameFacade {

    @EJB
    GameController gameController;

    public List<GameDto> getAll(){
        return this.gameController.getAll();
    }

    public List<GameDto> getAllAvailable(){
        return this.gameController.getAllAvailable();
    }

    public void persistGame(GameDto gameDto){
        this.gameController.persistGame(gameDto);
    }

    public void deleteGame(Long id){
        this.gameController.deleteGame(id);
    }

    public void updateGame(GameDto gameDto){
        this.gameController.updateGame(gameDto);
    }

    public void updateSpots(GameDto gameDto, int boughtTickets){
        this.gameController.updateSpots(gameDto, boughtTickets);
    }

    public GameDto findById(Long id){
        return this.gameController.findById(id);
    }
}
