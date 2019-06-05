package buyer.entity;

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
@Table(name = "buyer")
@NamedQueries(
        {
                @NamedQuery(name = BuyerEntity.GET_ID, query = "Select MAX (buyer.id) from BuyerEntity buyer"),
                @NamedQuery(name = BuyerEntity.GET_NAME, query = "Select buyer.name from BuyerEntity buyer where buyer.id = :" + BuyerEntity.ID),
                @NamedQuery(name = BuyerEntity.GET_SPOTS, query = "Select buyer.spots from BuyerEntity buyer where buyer.id =:" + BuyerEntity.ID),
                @NamedQuery(name = BuyerEntity.DELETE_BUYER, query = "Delete from BuyerEntity buyer where buyer.id = :" + BuyerEntity.ID)

        }
)
public class BuyerEntity extends BaseEntity<Long> {

    public static final String GET_ID = "BuyerEntity.getId";
    public static final String ID = "id";
    public static final String GET_NAME = "BuyerEntity.getName";
    public static final String GET_SPOTS = "BuyerEntity.getSpots";
    public static final String DELETE_BUYER = "BuyerEntity.DeleteBuyer";

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "spots", nullable = false)
    private int spots;

    public BuyerEntity() {
    }

    public BuyerEntity(String name, int spots) {
        this.name = name;
        this.spots = spots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpots() {
        return spots;
    }

    public void setSpots(int spots) {
        this.spots = spots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyerEntity that = (BuyerEntity) o;
        return spots == that.spots &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, spots);
    }

    @Override
    public String toString() {
        return "BuyerEntity{" +
                "name='" + name + '\'' +
                ", spots=" + spots +
                '}';
    }
}
