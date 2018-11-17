import java.util.Scanner;

public class Game {
    private GameBoard board;
    private int playerID ;
    private Scanner in;
    public void startGame(){
        board = new GameBoard(6,7);
        playerID = 1;
        in = new Scanner(System.in);
        for (int i = board.getM()*board.getN(); i >= 0; i--){

            System.out.println("Ruch gracza nr "+playerID);

            System.out.println("Proszę podaj kolumnę do którego wrzucasz żeton");
            int column = in.nextInt();
            while (board.checkIfColumnFull(column)) {
                System.out.println("Kolumna pełna. Podaj inna kolumne");
                column = in.nextInt();
            }
            board.insertToken(column, playerID);
            System.out.println(board);
            if (board.checkIfGameEnds()) {
                System.out.println("Koniec gry . Wygral gracz : " + playerID);
                break;
            }
            else
            {
               int zmienna = (playerID == 1) ? 2 : 1;
               playerID = zmienna;

            }
        }

    }

}
