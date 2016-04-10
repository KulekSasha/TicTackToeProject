import java.util.Scanner;

/**
 * Created by SashaKulek on 07/04/2016.
 */

public class HumanPlayer extends Player {


    public HumanPlayer(Board board, CellContent playerSide) {
        super(board, playerSide);
    }

    @Override
    public int[] getNextMoves() {
        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();
        int j = scanner.nextInt();

        return new int[]{i,j};
    }
}
