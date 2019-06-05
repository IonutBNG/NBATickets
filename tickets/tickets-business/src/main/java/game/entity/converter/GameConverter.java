package game.entity.converter;

import game.entity.GameEntity;
import game.entity.dto.GameDto;
import game.gameStage.GameStage;

import javax.ejb.Stateless;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */

@Stateless
public class GameConverter {


    /**
     *
     * @param gameEntity
     * @return GameDto equivalent of the gameEntity
     */
    public GameDto convertEntityToDto(GameEntity gameEntity){
        return new GameDto(gameEntity.getId(),
                gameEntity.getHomeTeam(),
                            gameEntity.getAwayTeam(),
                gameEntity.getStage().getDisplayString(),
                            gameEntity.getPrice(),
                            gameEntity.getAvailableSpots());
    }


    /**
     *
     * @param gameDto
     * @return GameEntity equivalent of the gameDto
     */
    public GameEntity convertDtoToEntity(GameDto gameDto) {
        return new GameEntity(gameDto.getTeams()[0],
                                gameDto.getTeams()[1],
                GameStage.getGameStageByString(gameDto.getStage()),
                                gameDto.getPrice(),
                                gameDto.getAvailableSpots());
    }
}
