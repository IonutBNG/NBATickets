package game.entity.dto;

import java.util.Objects;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
public class GameDto {

    private String match;

    private String stage;

    private int price;

    private int availableSpots;

    public GameDto() {
    }

    public GameDto(String homeTeam, String awayTeam, String stage, int price, int availableSpots) {
        this.match = createMatch(homeTeam, awayTeam);
        this.stage = stage;
        this.price = price;
        this.availableSpots = availableSpots;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String[] getTeams(){
        return this.match.split(" vs. ");
    }

    public String createMatch(String homeTeam, String awayTeam){
        return homeTeam + " vs. " + awayTeam;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
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
        GameDto gameDto = (GameDto) o;
        return price == gameDto.price &&
                availableSpots == gameDto.availableSpots &&
                Objects.equals(match, gameDto.match) &&
                Objects.equals(stage, gameDto.stage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(match, stage, price, availableSpots);
    }
}
