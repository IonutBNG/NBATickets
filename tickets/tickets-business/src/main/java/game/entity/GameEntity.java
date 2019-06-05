package game.entity;

import game.gameStage.GameStage;
import utils.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Entity
@Table(name = "game")
@NamedQueries(
        {
                @NamedQuery(name = GameEntity.SELECT_ALL, query = "Select g from GameEntity g "),
                @NamedQuery(name = GameEntity.SELECT_ALL_AVAILABLE, query = "Select g from GameEntity g where g.availableSpots > 0"),
                @NamedQuery(name = GameEntity.DELETE, query = "Delete from GameEntity g where g.id = :" + GameEntity.ID),
                @NamedQuery(name = GameEntity.FIND_BY_ID, query = "Select g from GameEntity g where g.id = :" + GameEntity.ID),
                @NamedQuery(name = GameEntity.UPDATE, query = "Update GameEntity g set g.price = :" + GameEntity.PRICE + " where g.homeTeam = :" + GameEntity.HOME_TEAM + " and g.awayTeam = :" + GameEntity.AWAY_TEAM),
                @NamedQuery(name = GameEntity.UPDATE_SPOTS, query = "Update GameEntity g set g.availableSpots = g.availableSpots - :" + GameEntity.BOUGHT_TICKETS + " where g.homeTeam = :" + GameEntity.HOME_TEAM + " and g.awayTeam = :" + GameEntity.AWAY_TEAM),
                @NamedQuery(name = GameEntity.EMPTY_SPOTS, query = "Update GameEntity g set g.availableSpots = g.availableSpots + :" + GameEntity.EMPTIED_SPOTS + " where g.id = :" + GameEntity.ID),
                @NamedQuery(name = GameEntity.GET_ID, query = "Select game.id from GameEntity game where game.homeTeam = :" + GameEntity.HOME_TEAM + " and game.awayTeam = :" + GameEntity.AWAY_TEAM)

        }
)

public class GameEntity extends BaseEntity<Long> {

    public static final java.lang.String SELECT_ALL = "GameEntity.selectAll";
    public static final java.lang.String SELECT_ALL_AVAILABLE = "GameEntity.selectAllAvailable";
    public static final String ID = "id";
    public static final String FIND_BY_ID = "GameEntity.findById";
    public static final String DELETE = "GameEntity.Delete";
    public static final String AWAY_TEAM = "awayTeam";
    public static final String HOME_TEAM = "homeTeam";
    public static final String PRICE = "price";
    public static final String UPDATE = "GameEntity.Update";
    public static final String UPDATE_SPOTS = "GameEntity.UpdateSpots";
    public static final String BOUGHT_TICKETS = "boughtTickets";
    public static final String EMPTIED_SPOTS = "emptiedSpots";
    public static final String EMPTY_SPOTS = "GameEntity.EmptySpots";
    public static final String GET_ID = "GameEntity.getId";


    @Column(name = "homeTeam", nullable = false)
    private String homeTeam;

    @Column(name = "awayTeam", nullable = false)
    private String awayTeam;

    @Enumerated(EnumType.STRING)
    @Column(name = "stage", nullable = false)
    private GameStage stage;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "availableSpots", nullable = false)
    private int availableSpots;

    public GameEntity() {
    }

    public GameEntity(String homeTeam, String awayTeam, GameStage stage, int price, int availableSpots) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stage = stage;
        this.price = price;
        this.availableSpots = availableSpots;
    }

    public java.lang.String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(java.lang.String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public java.lang.String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(java.lang.String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public GameStage getStage() {
        return stage;
    }

    public void setStage(GameStage stage) {
        this.stage = stage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public void setAvailableSpots(int availableSpots) {
        this.availableSpots = availableSpots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameEntity that = (GameEntity) o;
        return price == that.price &&
                availableSpots == that.availableSpots &&
                Objects.equals(homeTeam, that.homeTeam) &&
                Objects.equals(awayTeam, that.awayTeam) &&
                stage == that.stage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, stage, price, availableSpots);
    }
}
