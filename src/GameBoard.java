public class GameBoard {

    private Field[][] gameBoard;
    private int n;
    private int m;
    public GameBoard(int n, int m) {


        gameBoard = new Field[n][m];
        this.n = n;
        this.m = m;
        for (int i= 0; i<gameBoard.length; i++){
            for (int j=0; j<gameBoard[i].length; j++)
                gameBoard[i][j] = new Field();
        }

    }

    public Boolean checkVertical(){
        int i = 1;
        for (int j=0; j< gameBoard[i-1].length; j++){ // 7
            int count = 0;

            for (i=1; i<gameBoard.length; i++){ // 6
                String tempColor = gameBoard[i-1][j].getColor();
                if (tempColor.equals(gameBoard[i][j].getColor()) && !tempColor.equals("none"))
                    count++;
                else {
                    count = 0;

                }
                if (count == 3) return true;
            }
        }
        return false;
    }


    public Boolean checkHorizontal(){
        for (int j=0; j< gameBoard.length; j++){
            int count = 0;
            for (int i=1 ; i< gameBoard[j].length; i++){
               String tempColor = gameBoard[j][i-1].getColor();
               if (tempColor.equals(gameBoard[j][i].getColor()) && !tempColor.equals("none"))
                   count ++;
               else{
                   count = 0;

               }
               if (count==3) return true;
            }
        }
        return false;
    }

    public Boolean checkIfGameEnds(){
        if (checkHorizontal() || checkVertical())
            return true;
        return false;
    }

    public Boolean checkIfColumnFull(int column){
        if (gameBoard[0][column].getColor().equals("none")) return false;
        return true;

    }

    public void insertToken(int colNum, int playerID){

        for (int row = gameBoard.length-1; row>=0; row--){
            if (gameBoard[row][colNum].getColor().equals("none")) {
                if (playerID == 1)
                    gameBoard[row][colNum].setColor("red");
                else
                    gameBoard[row][colNum].setColor("blu");
                break;
            }
        }
    }

    @Override
    public String toString() {
        for (int i = 0 ; i < gameBoard.length; i++){
            for (int j = 0 ; j <gameBoard[i].length; j++){
                System.out.print(gameBoard[i][j].getColor()+ " ");
            }
            System.out.println();
        }
        return "";
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }
}
