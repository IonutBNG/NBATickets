package transaction.entity;

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
@Table(name = "transaction")
@NamedQueries(
        {
                @NamedQuery(name = TransactionEntity.GET_ALL_BY_GAME_ID, query = "Select t from TransactionEntity t where t.gameID = :" + TransactionEntity.GAME_ID),
                @NamedQuery(name = TransactionEntity.SELECT_ALL, query = "Select t from TransactionEntity t"),
                @NamedQuery(name = TransactionEntity.ENTITY_DELETE, query = "Delete from TransactionEntity t where t.gameID = :" + TransactionEntity.GAME_ID + " and t.buyerID = :" + TransactionEntity.BUYER_ID)
        }
)
public class TransactionEntity extends BaseEntity<Long> {

    public static final String GAME_ID = "gameID";
    public static final String GET_ALL_BY_GAME_ID = "TransactionEntity.getAllByGameId";
    public static final String SELECT_ALL = "TransactionEntity.SelectAll";
    public static final String BUYER_ID = "buyerID";
    public static final String ENTITY_DELETE = "TransactionEntity.Delete";

    @Column(name = "gameID", nullable = false)
    private Long gameID;

    @Column(name = "buyerID", nullable = false)
    private Long buyerID;

    @Column(name = "timestamp", nullable = false)
    private String timestamp;

    public TransactionEntity() {
    }

    public TransactionEntity(Long gameID, Long buyerID, String timestamp) {
        this.gameID = gameID;
        this.buyerID = buyerID;
        this.timestamp = timestamp;
    }

    public Long getGameID() {
        return gameID;
    }

    public void setGameID(Long gameID) {
        this.gameID = gameID;
    }

    public Long getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(Long buyerID) {
        this.buyerID = buyerID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return Objects.equals(gameID, that.gameID) &&
                Objects.equals(buyerID, that.buyerID) &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameID, buyerID, timestamp);
    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "gameID=" + gameID +
                ", buyerID=" + buyerID +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
