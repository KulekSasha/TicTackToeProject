/**
 * Created by SashaKulek on 07/04/2016.
 */

public abstract class Player {
    private CellContent playerSide;


    public Player(CellContent playerSide) {
        this.playerSide = playerSide;

    }

    public abstract int[] getNextMoves();

    public CellContent getPlayerSide() {
        return playerSide;
    }
}


enum PlayerType {
    AI, HUMAN
}