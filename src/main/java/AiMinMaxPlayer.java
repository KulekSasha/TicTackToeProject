/**
 * Created by SashaKulek on 07/04/2016.
 */

public class AiMinMaxPlayer extends Player {
    private CellContent pleerSidde;
    private Board board;


    public AiMinMaxPlayer(CellContent playerSide ) {
        super(playerSide);

    }


    @Override
    public int[] getNextMoves() {




        return new int[]{0,0};
    }
}
