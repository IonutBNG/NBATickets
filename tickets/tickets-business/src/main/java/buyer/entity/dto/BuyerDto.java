package buyer.entity.dto;

import java.util.Objects;

/**
 * @author Bungardean Tudor-Ionut
 * @since 19.1.2
 */
public class BuyerDto {

    private String name;

    private int spots;

    public BuyerDto() {
    }

    public BuyerDto(String name, int spots) {
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
        BuyerDto buyerDto = (BuyerDto) o;
        return spots == buyerDto.spots &&
                Objects.equals(name, buyerDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, spots);
    }

    @Override
    public String toString() {
        return "BuyerDto{" +
                "name='" + name + '\'' +
                ", spots=" + spots +
                '}';
    }
}
