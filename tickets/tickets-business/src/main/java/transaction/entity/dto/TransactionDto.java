package transaction.entity.dto;

/**
 * @author Bungardean Tudor-Ionut
 * @since 19.1.2
 */
public class TransactionDto {

    private Long gameID;

    private Long buyerID;

    private String timestamp;

    public TransactionDto() {
    }

    public TransactionDto(Long gameID, Long buyerID, String timestamp) {
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
}
