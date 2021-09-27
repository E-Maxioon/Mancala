package sample;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.*;
import java.lang.*;
import java.lang.*;
import java.lang.Math;
import java.util.Scanner;

public class Game {

    static Scanner myScanner = new Scanner(System.in);
    protected GameState currentState;
    protected Player [] players = new Player[2];
    protected Player currentPlayer;
    protected Player winner;
    protected Date date;

    // CLASS THAT INTERACTS WITH BUTTONS //
    public static int readScanner()    {
        System.out.println("Please select a new location to pick up stones");
        int location = myScanner.nextInt();
        System.out.print(location);
        return location;
    }

    // NEW CONSTRUCTOR //
    public Game(Player player1, Player player2)   {
        this.currentState = new GameState();
        this.players[0] = player1;
        this.players[1] = player2;
        this.currentPlayer = setStartingPlayer(players);
        Date date = new Date();
    }

    // BASIC GETTER AND SETTER METHODS
    //Setter and getter for date
    public int [] getPlayerSide(int player)   {
        return this.getPlayerSide(player);
    }

    public Date getDate(){
        return date;
    }

    //Choose starting player
    public static Player setStartingPlayer(Player[] players) {
        if (Math.random() < 0.5)	{
            System.out.println("Player 1 started");
            return players[0];

        }
        System.out.println("Player 2 started");
        return players[1];
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public Player [] getPlayers()   {
        return this.players;
    }
    public void printCurrentState() {

        currentState.printGameState();
    }

    public static int changePlayerSide(int side) {
        if (side == 0) return 1;
        return 0;
    }

    public void swapCurrentPlayer() {
        if (currentPlayer.equals(players[0])) {
            currentPlayer = players[1];
        }
        else
            currentPlayer = players[0];
    }

    public Player getWinner() {
        return this.winner;
    }

////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

    public boolean updateState(int location) {
        int playerSide;
        if (currentPlayer.equals(players[0]))  {
            playerSide = 0;
        }
        else {
            playerSide = 1;
        }
        System.out.println(playerSide + " this playerside");
        int stones;

        //retrieve stones from the chosen location
        stones = currentState.retrieveStones(location, playerSide);
        System.out.println("stones: "+ stones);
        System.out.println("location: "+ location);
        location++;
        System.out.println("location: "+ location);
        // check if there are any stones in the chosen location.
        if (stones == 0) {
            // LEAVE UPDATE STATE AND CHOOSE AGAIN
        }
        //this.printCurrentState();
        while (stones > 0) {
            // moves stones round the board and update stones.
            stones = currentState.updateSide(stones, location, playerSide);
            location = 0;

            if (stones == 0) {
                break;
            }
            //this.printCurrentState();
            // add 1 stone to player score (Big Pocket).
            stones = currentState.updateScore(stones, playerSide);
            //this.printCurrentState();
            // check if the TURN is over.
            if (stones == 0) {
                System.out.println("Exit 1");
                return true;
            }
            // switch sides.
            playerSide = changePlayerSide(playerSide);
            // move stones round the board and update stones
            stones = currentState.updateSide(stones, location, playerSide);
            //this.printCurrentState();
            // switch sides.
            playerSide = changePlayerSide(playerSide);
        }
        // check if side is empty (game is over)
        if (currentState.isSideEmpty()) {
            // retrieve stones from 1 side
            stones = currentState.getEndingStones(playerSide);
            currentState.setPlayerScore(stones, playerSide);
            // switch side
            playerSide = changePlayerSide(playerSide);
            // retrieve stones from other side
            stones = currentState.getEndingStones(playerSide);
            currentState.setPlayerScore(stones, playerSide);

            // identify which player wins,
            // identify corresponding player Object
            winner = players[currentState.getWinner()];


            // update records
            winner.incrementGamesPlayed();
            winner.incrementGamesWon();
            winner.setWinPercentage();
            if (winner.equals(players[0]))  {
                players[1].incrementGamesPlayed();
                players[1].incrementGamesLost();
                players[1].setWinPercentage();
            }
            else {
                players[0].incrementGamesPlayed();
                players[0].incrementGamesLost();
                players[0].setWinPercentage();
            }
            // finsh updatestate method with game finished condition
            System.out.println("Exit 2");
            return false;
        }
        System.out.println("Exit 3");
        currentPlayer.printPlayerID();
        this.swapCurrentPlayer();
        currentPlayer.printPlayerID();
        return true;
    }
}
