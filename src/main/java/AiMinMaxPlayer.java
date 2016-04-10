import java.util.List;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public class AiMinMaxPlayer extends Player {
    //private CellContent playerSidde;
    // private Board board;
    private int depthLevel;
    private CellContent oppositePlayer = getOppositePlayer(playerSide);

    public AiMinMaxPlayer(Board board, CellContent playerSide) {
        super(board, playerSide);
    }

    @Override
    public int[] getNextMoves() {
        int[] result = minimaxCross(1, this.playerSide);
        return new int[]{result[1], result[2]};
    }


    private int[] minimaxCross(int depth, CellContent player) {
        List<Cell> emptyCells = this.board.getEmptyCells();

        board.qty++;

        int[] tmp = new int[3]; // score, row, col
        int[] result = new int[3];
        result[0] = (this.playerSide == player) ? Integer.MIN_VALUE : Integer.MAX_VALUE; //best score
        int currentScore;

        if (board.isWin(player)) {
            if (playerSide == player){
                return new int[]{1};
            }else {
                return new int[]{-1};
            }
        }else if (!board.hasEmptyCell()){
            return new int[]{0};
        }

        for (Cell cell : emptyCells) {
            cell.setContent(player); // do new step

            if (playerSide == player) {
                tmp[0] = minimaxCross(depth +1, oppositePlayer)[0];
                if (tmp[0] > result[0]) {
                    result[0] = tmp[0];
                    result[1] = cell.getRow();
                    result[2] = cell.getCol();
                }
            } else if (playerSide != player){
                tmp[0] = minimaxCross(depth +1, playerSide)[0];
                if (tmp[0] < result[0]) {
                    result[0] = tmp[0];
                    result[1] = tmp[1];
                    result[2] = tmp[2];
                }
            }

            cell.setContent(CellContent.EMPTY); //roll-back
        }


        return result;
    }

    private CellContent getOppositePlayer(CellContent player) {
        return player == CellContent.CROSS ? CellContent.ZERO : CellContent.CROSS;
    }
}
