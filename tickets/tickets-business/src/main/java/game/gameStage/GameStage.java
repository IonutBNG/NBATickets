package game.gameStage;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
public enum GameStage {

    Playoff("Play off"),
    Semifinal1("Semifinal 1"),
    Semifinal2("Semifinal 2"),
    Final("Final");

    private java.lang.String displayString;

    GameStage(java.lang.String displayString) {
        this.displayString = displayString;
    }

    public java.lang.String getDisplayString(){
        return this.displayString;
    }

    public static GameStage getGameStageByString(java.lang.String value){
        for (GameStage stage : GameStage.values()){
            if (value.equals(stage.getDisplayString())){
                return stage;
            }
        }
        return null;
    }

}
