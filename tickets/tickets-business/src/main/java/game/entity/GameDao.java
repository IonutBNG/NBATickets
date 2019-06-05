package game.entity;

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
public class GameDao {

    @PersistenceContext(unitName = "tickets-persistence")
    private EntityManager entityManager;


    /**
     * @param -
     * Returns the entire list of games
     * @return <list>GameEntity</list>
     */
    public List<GameEntity> getAll(){
        return this.entityManager
                .createNamedQuery(GameEntity.SELECT_ALL, GameEntity.class)
                .getResultList();
    }

    /**
     * @param -
     * Returns the list of available games(Those who still have availableSpots > 0)
     * @return <list>GameEntity</list>
     */
    public List<GameEntity> getAllAvailable(){
        return this.entityManager
                .createNamedQuery(GameEntity.SELECT_ALL_AVAILABLE, GameEntity.class)
                .getResultList();
    }

    /**
     *
     * @param gameEntity
     * Persists in the database gameEntity
     */
    public void persistGame(GameEntity gameEntity){
        this.entityManager
                .persist(gameEntity);
    }

    /**
     * Deletes the entry in the table game that has the ID = id
     * @param id
     */
    public void deleteGame(Long id){
        this.entityManager
                .createNamedQuery(GameEntity.DELETE, GameEntity.class)
                .setParameter(GameEntity.ID, id)
                .executeUpdate();
    }

    /**
     * Sets the new price of the game
     * @param gameEntity
     */
    public void updatePrice(GameEntity gameEntity){
        this.entityManager
                .createNamedQuery(GameEntity.UPDATE, GameEntity.class)
                .setParameter(GameEntity.PRICE, gameEntity.getPrice())
                .setParameter(GameEntity.HOME_TEAM, gameEntity.getHomeTeam())
                .setParameter(GameEntity.AWAY_TEAM, gameEntity.getAwayTeam())
                .executeUpdate();
    }

    /**
     * Sets the new number of available spots based on the number of bought tickets
     * @param gameEntity
     * @param boughtTickets
     */
    public Long updateSpots(GameEntity gameEntity, int boughtTickets) {
        this.entityManager
                .createNamedQuery(GameEntity.UPDATE_SPOTS, GameEntity.class)
                .setParameter(GameEntity.BOUGHT_TICKETS, boughtTickets)
                .setParameter(GameEntity.HOME_TEAM, gameEntity.getHomeTeam())
                .setParameter(GameEntity.AWAY_TEAM, gameEntity.getAwayTeam())
                .executeUpdate();

        return this.entityManager
                .createNamedQuery(GameEntity.GET_ID, Long.class)
                .setParameter(GameEntity.HOME_TEAM, gameEntity.getHomeTeam())
                .setParameter(GameEntity.AWAY_TEAM, gameEntity.getAwayTeam())
                .getSingleResult();
    }

    /**
     * Finds an entity based on the id
     * @param id
     * @return
     */
    public GameEntity findById(Long id){
        return this.entityManager
                .createNamedQuery(GameEntity.FIND_BY_ID, GameEntity.class)
                .setParameter(GameEntity.ID, id)
                .getSingleResult();
    }

    public void emptySpots(Long id, int spots) {
        this.entityManager
                .createNamedQuery(GameEntity.EMPTY_SPOTS)
                .setParameter(GameEntity.EMPTIED_SPOTS, spots)
                .setParameter(GameEntity.ID, id)
                .executeUpdate();
    }
}
