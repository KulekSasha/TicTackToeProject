/**
 * Created by SashaKulek on 07/04/2016.
 */

public class Game {
    private Board board;
    private Player playerCross;
    private Player playerZero;


    public Game(Board board) {
        this.board = board;
    }


    public void startGame() {
        setUpPleers();


    }


    private void setUpPleers() {
        //ask user about side
        CellContent answer = CellContent.ZERO;
        //--------------

        if (answer == CellContent.CROSS) {
            playerCross = new HumanPlayer(CellContent.CROSS);
            playerZero = new AiMinMaxPlayer(CellContent.ZERO);
        } else {
            playerCross = new AiMinMaxPlayer(CellContent.CROSS);
            playerZero = new HumanPlayer(CellContent.ZERO);
        }
    }

    private GameState checkGameStatus() {


        return GameState.DRAW;
    }

}

enum GameState {
    PLAYING, DRAW, CROSS_WIN, ZERO_WIN
}
