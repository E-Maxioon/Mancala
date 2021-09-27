package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Player extends User {

    private int userID;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;
    private double winPercentage;
    private ArrayList<Player> favouritePlayers = new ArrayList<Player>();

    // add an equals method for comparing IDs???

    // update player statistics

    public Player(String userName, String password, String firstName, String lastName, int userID) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
    }

    public ArrayList<Player> getFavouritePlayers() {
        return favouritePlayers;
    }

    public void setFavouritePlayers(ArrayList<Player> favouritePlayers) {
        this.favouritePlayers = favouritePlayers;
    }

    public void addFavouritePlayer(Player player) {
        favouritePlayers.add(player);
    }

    public void removeFavouritePlayer(Player player) {
        favouritePlayers.remove(player);
    }

    public int getGamesPlayed() {
        return this.gamesPlayed;
    }

    public void setGamesPlayed(int games) {
        this.gamesPlayed = games;
    }

    public void incrementGamesPlayed() {
        this.gamesPlayed++;
    }

    public int getGamesWon() {
        return this.gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public void incrementGamesWon() {
        this.gamesWon++;
    }

    public int getGamesLost() {
        return this.gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public void incrementGamesLost() {
        this.gamesLost++;
    }

    public double getWinPercentage() {
        return this.winPercentage;
    }

    public void setWinPercentage() {
        this.winPercentage = ((double) this.gamesWon) / ((double) this.gamesPlayed);
    }

    public int getID() {
        return this.userID;
    }

    public boolean equals(Player player) {
        return this.userID == player.getID();
    }

    public void printPlayerID() {
        System.out.println("Current Player: " + this.userID);
    }

}
