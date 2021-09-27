package sample;

public class GameState   {

    private int [] player1Side = new int [6];
    private int [] player2Side = new int [6];
    private int player1Score;
    private int player2Score;

    public GameState() {
        this.player1Score = 0;
        this.player2Score = 0;

        for (int i = 0; i < 6; i++) {
            this.player1Side[i] = 2;
            this.player2Side[i] = 2;
        }
    }

    public int retrieveStones(int location, int player) {
        if (player == 0)    {
            int stones = player1Side[location];
            player1Side[location] = 0;
            return stones;
        }
        else {
            int stones = player2Side[location];
            player2Side[location] = 0;
            return stones;
        }
    }

    public int getStonesInPocket(int location, int player)  {
        if (player ==0) {
            return player1Side[location];
        }
        else {
            return player2Side[location];
        }
    }

    public int getEndingStones(int player)  {
        int sum = 0;
        if (player == 0)  {
            for (int i = 0; i < 6; i++) {
                sum += player1Side[i];
            }
            return sum;
        }
        else {
            for (int i = 0; i < 6; i++) {
                sum += player2Side[i];
            }
            return sum;
        }
    }

    public int updateSide(int stones, int location, int playerSide) {
        // cycle through pockets to add stones
        for (int i = location; i < 6; i++) {
            if (stones == 0)
                return 0;
            this.incrementPlayerSide(i, playerSide);
            stones --;
            // check if the the turn is completing or not
            if (stones == 0 && this.getStonesInPocket(i, playerSide) > 1)  {
                stones = this.retrieveStones(i, playerSide);
            }
        }
        return stones;
    }

    public void incrementPlayerSide (int location, int player)    {
        if (player == 0) {
            player1Side[location]++;
        }
        else  {
            player2Side[location]++;
        }
    }

    public int updateScore(int stones, int player)    {
        if (stones == 0)    {
            return 0;
        }
        else {
            if (player == 0)    {
                player1Score++;
            }
            else {
                player2Score++;
            }
            return stones -1;
        }
    }

    // GET PLAYER SCORE
    public int getPlayerScore(int player)    {
        if (player == 0) {
            return player1Score;
        }
        else {
            return player2Score;
        }
    }

    //END GAME CONDITION //
    public boolean isSideEmpty()  {
        int sumOne = 0;
        int sumTwo = 0;
        for (int i = 0; i < 6; i++) {
            sumOne += player1Side[i];
            sumTwo += player2Side[i];
        }
        if (sumOne == 0 || sumTwo == 0) {
            return true;
        }
        return false;
    }

    public void setPlayerScore(int stones, int player)  {
        if (player == 0)    {
            player1Score += stones;
        }
        else  {
            player2Score += stones;
        }
    }

    public int [] getPlayerSide(int player) {
        if (player == 0)    {
            return this.player1Side;
        } else {
            return this.player2Side;
        }
    }

    public int getWinner()    {
        if (player1Score > player2Score)    {
            return 0;
        }
        else {
            return 1;
        }

    }

    public void printGameState() {
        System.out.print("Player 1 pockets ");

        for (int i = 0; i < 6; i++) {
            System.out.print(player1Side[i]);
        }
        System.out.println();
        System.out.println("Player 1 Score " + player1Score);
        System.out.print("Player 2 pockets ");

        for (int i = 0; i < 6; i++) {
            System.out.print(player2Side[i]);
        }

        System.out.println();
        System.out.println("Player 2 Score " + player2Score);
        System.out.println();
    }
}
