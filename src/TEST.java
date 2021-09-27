package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;


public class TEST {

    private  Game game;
    @FXML
    private AnchorPane selectGameModeScene; // Select Game Mode Screen
    @FXML
    private AnchorPane player1StartsGameScene; // Player1 Starts Game Screen
    // @FXML
    private AnchorPane player1WinnerScene; // Admin Account Screen
    @FXML
    private AnchorPane player2StartsGameScene; // Player1 Starts Game Screen
    @FXML
    private AnchorPane player2WinnerScene; // Admin Account Screen
    @FXML
    private AnchorPane ExitCurrentGameModeScene; // Exit Confirmation Screen for the Traditional / Arcade Game Mode Scene

    // Pocket Identification
    Button player1Pocket0 = new Button();
    Button player1Pocket1 = new Button();
    Button player1Pocket2 = new Button();
    Button player1Pocket3 = new Button();
    Button player1Pocket4 = new Button();
    Button player1Pocket5 = new Button();

    Button player2Pocket0 = new Button();
    Button player2Pocket1 = new Button();
    Button player2Pocket2 = new Button();
    Button player2Pocket3 = new Button();
    Button player2Pocket4 = new Button();
    Button player2Pocket5 = new Button();


    // Getter & Setters
    public Game getGame() {

        return game;
    }
    public void setGame(Game game) {

        this.game = game;
    }

    // Home Screen Menu
    public void SystemDirectory() throws Exception {

        // Builds the system home Screen
        Parent root = FXMLLoader.load(getClass().getResource("SystemDirectory.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Mancala Home");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Displays the Home Screen
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Load's the Traditional Game Mode Screen & Exits the Previous Screen
    public void loadTraditionalGameMode() {
        try {
            TraditionalGameMode();

            if(game.players[0].equals(game.currentPlayer)){
                player1StartsGame();

            } else {
                player2StartsGame();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Closes the Home Screen Menu
        Stage stage = new Stage();
        stage = (Stage) selectGameModeScene.getScene().getWindow();
        stage.close();
    }

    // Player 1 Starts Game Screen
    public void player1StartsGame() throws Exception {

        // Player 1 Starts Game Properties
        Parent root = FXMLLoader.load(getClass().getResource("Player1StartGame.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Player 1 Starts Game");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Displays the Player 1 Starts GameScreen
        stage.setScene(new Scene(root));
        stage.show();
    }

    // "Continue" Button on continue Player 1 Game screen
    public void continuePlayer1Game() {

        // Closes the Continue Player 1 Game screen
        Stage stage = new Stage();
        stage = (Stage) player1StartsGameScene.getScene().getWindow();
        System.out.println("Continue Player 1 Game");
        stage.close();
    }

    // Player 2 Starts Game Screen
    public void player2StartsGame() throws Exception {

        // Player 2 Starts Game Properties
        Parent root = FXMLLoader.load(getClass().getResource("Player2StartGame.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Player 2 Starts Game");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Displays the Player 2 Starts GameScreen
        stage.setScene(new Scene(root));
        stage.show();
    }

    // "Continue" Button on continue Player 1 Game screen
    public void continuePlayer2Game() {

        // Closes the "Exit Game" pop-up confirmation screen
        Stage stage = new Stage();
        stage = (Stage) player2StartsGameScene.getScene().getWindow();
        System.out.println("Continue Player 2 Game");
        stage.close();
    }

    // Traditional Game Mode Screen
    public void TraditionalGameMode() throws Exception {

        setSide(game.getPlayers(),game.getCurrentPlayer());

        // Traditional Screen Properties
        Parent root = FXMLLoader.load(getClass().getResource("TraditionalModeGame.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Traditional Game Mode");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Displays the Traditional Game Mode Screen
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Gets which Player is Winner Screen
    public void GameWinner() throws Exception {
        game.getWinner();

        Player winner = game.getWinner();

        JLabel Player1Label = new JLabel();

        player1Winner();
        player2Winner();
    }

    public void setSide(Player [] players, Player current) {

        if (current.equals(players[0])) {

            player2Pocket0.setDisable(true);
            player2Pocket1.setDisable(true);
            player2Pocket2.setDisable(true);
            player2Pocket3.setDisable(true);
            player2Pocket4.setDisable(true);
            player2Pocket5.setDisable(true);

            player1Pocket0.setDisable(false);
            player1Pocket1.setDisable(false);
            player1Pocket2.setDisable(false);
            player1Pocket3.setDisable(false);
            player1Pocket4.setDisable(false);
            player1Pocket5.setDisable(false);

        } else {

            player1Pocket0.setDisable(true);
            player1Pocket1.setDisable(true);
            player1Pocket2.setDisable(true);
            player1Pocket3.setDisable(true);
            player1Pocket4.setDisable(true);
            player1Pocket5.setDisable(true);

            player2Pocket0.setDisable(false);
            player2Pocket1.setDisable(false);
            player2Pocket2.setDisable(false);
            player2Pocket3.setDisable(false);
            player2Pocket4.setDisable(false);
            player2Pocket5.setDisable(false);
        }
    }

    public void player1Winner() throws Exception {
        // Player 1 Winner Screen Properties
        Parent root = FXMLLoader.load(getClass().getResource("Player1Winner.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Player 1 Winner");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Displays the Player 1 Winner Screen
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void exitPlayer1WinnerScreen() {
        try {
            SystemDirectory();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        EXIT THE TRADITIONAL GAME SCREEN before exiting the Player 2 Winner Screen
        */

        // Closes the Player 1 Winner Screen
        Stage stage = new Stage();
        stage = (Stage) player1WinnerScene.getScene().getWindow();
        stage.close();
    }

    public void player2Winner() throws Exception {
        // Player 2 Winner Screen Properties
        Parent root = FXMLLoader.load(getClass().getResource("Player2Winner.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Player 2 Winner");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Displays the Player 2 Winner Screen
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void exitPlayer2WinnerScreen() throws Exception {
        try {
            SystemDirectory();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        EXIT THE TRADITIONAL GAME SCREEN before exiting the Player 2 Winner Screen
        */
        // Closes the Player 2 Winner Screen
        Stage stage = new Stage();
        stage = (Stage) player2WinnerScene.getScene().getWindow();
        stage.close();
    }

    // "Yes" Button on Exit Current Game Confirmation Screen (Example: Traditional or Arcade Game Mode)
    public void YesExitCurrentGame() {

        try {
            SystemDirectory();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Closes the "Exit Game" pop-up confirmation screen
        Stage stage = new Stage();
        stage = (Stage) ExitCurrentGameModeScene.getScene().getWindow();
        System.out.println("Exited Quit Game Confirmation Screen");
        stage.close();
    }

    // "No" Button on Exit Current Game Confirmation Screen (Example: Traditional or Arcade Game Mode)
    public void noExitCurrentGame() {

        Stage stage = new Stage();
        stage = (Stage) ExitCurrentGameModeScene.getScene().getWindow();
        System.out.println("Continued the Current Game Mode");
        stage.close();
    }

    // Quit Current Game Mode Confirmation Screen
    public void quitCurrentGameModeConfirmation( )  throws Exception {

        // Quit Current Game Mode Screen Properties
        Parent root = FXMLLoader.load(getClass().getResource("quitCurrentGameModeConfirmation.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Quit Current Game");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Displays the Quit Current Game Mode Screen
        stage.setScene(new Scene(root));
        stage.show();

        /* Closes the Traditional Game Mode After Loading the Quit Game Confirmation Screen
              CODE GOES HERE
        */
    }

    //--------------------------- Traditional Game Mode Pocket Buttons ---------------------------\\

// These methods (pockets) will be executed only when their respected buttons are clicked on the screen

    // Player 1 Side Pockets
    public void player1Pocket0() throws Exception {

        // Takes in the current player & starting player
        System.out.println("Pocket 0 Selected" + "\n");
        int location = 0;
        boolean isGameInProgress = true;
        isGameInProgress = game.updateState(location);

        if(!isGameInProgress){
            GameWinner();
        }

        game.printCurrentState();
        System.out.println("\n");
    }
    public void player1Pocket1()  throws Exception {

        // Takes in the current player & starting player
        System.out.println("Pocket 1 Selected" + "\n");
        int location = 1;
        boolean isGameInProgress = true;
        isGameInProgress = game.updateState(location);

        if(!isGameInProgress){
            GameWinner();
        }

        game.printCurrentState();
        System.out.println("\n");

        setSide(game.getPlayers(),game.getCurrentPlayer());
    }
    public void player1Pocket2 ()  throws Exception  {

        // Takes in the current player & starting player
        System.out.println("Pocket 2 Selected" + "\n");
        int location = 2;
        boolean isGameInProgress = true;
        isGameInProgress = game.updateState(location);

        if(!isGameInProgress){
            GameWinner();
        }

        game.printCurrentState();
        System.out.println("\n");

        setSide(game.getPlayers(),game.getCurrentPlayer());
    }
    public void player1Pocket3()  throws Exception  {

        // Takes in the current player & starting player
        System.out.println("Pocket 3 Selected" + "\n");
        int location = 3;
        boolean isGameInProgress = true;
        isGameInProgress = game.updateState(location);

        if(!isGameInProgress){
            GameWinner();
        }

        game.printCurrentState();
        System.out.println("\n");

        setSide(game.getPlayers(),game.getCurrentPlayer());
    }
    public void player1Pocket4()  throws Exception  {

        // Takes in the current player & starting player
        System.out.println("Pocket 4 Selected" + "\n");
        int location = 4;
        boolean isGameInProgress = true;
        isGameInProgress = game.updateState(location);

        if(!isGameInProgress){
            GameWinner();
        }

        game.printCurrentState();
        System.out.println("\n");

        setSide(game.getPlayers(),game.getCurrentPlayer());    }
    public void player1Pocket5()  throws Exception  {

        // Takes in the current player & starting player
        System.out.println("Pocket 5 Selected" + "\n");
        int location = 5;
        boolean isGameInProgress = true;
        isGameInProgress = game.updateState(location);

        if(!isGameInProgress){
            GameWinner();
        }

        game.printCurrentState();
        System.out.println("\n");

        setSide(game.getPlayers(),game.getCurrentPlayer());
    }

    // Player 2 Side Pockets
    public void player2Pocket0 ()  throws Exception  {

        // Takes in the current player & starting player
        System.out.println("Pocket 0 Selected" + "\n");
        int location = 0;
        boolean isGameInProgress = true;
        isGameInProgress = game.updateState(location);

        if(!isGameInProgress){
            GameWinner();
        }

        game.printCurrentState();
        System.out.println("\n");

        setSide(game.getPlayers(),game.getCurrentPlayer());
    }
    public void player2Pocket1()  throws Exception  {

        // Takes in the current player & starting player
        System.out.println("Pocket 1 Selected" + "\n");
        int location = 1;
        boolean isGameInProgress = true;
        isGameInProgress = game.updateState(location);

        if(!isGameInProgress){
            GameWinner();
        }

        game.printCurrentState();
        System.out.println("\n");

        setSide(game.getPlayers(),game.getCurrentPlayer());
    }
    public void player2Pocket2 ()  throws Exception  {

        // Takes in the current player & starting player
        System.out.println("Pocket 2 Selected" + "\n");
        int location = 2;
        boolean isGameInProgress = true;
        isGameInProgress = game.updateState(location);

        if(!isGameInProgress){
            GameWinner();
        }

        game.printCurrentState();
        System.out.println("\n");

        setSide(game.getPlayers(),game.getCurrentPlayer());
    }
    public void player2Pocket3()  throws Exception  {

        // Takes in the current player & starting player
        System.out.println("Pocket 3 Selected" + "\n");
        int location = 3;
        boolean isGameInProgress = true;
        isGameInProgress = game.updateState(location);

        if(!isGameInProgress){
            GameWinner();
        }

        game.printCurrentState();
        System.out.println("\n");

        setSide(game.getPlayers(),game.getCurrentPlayer());
    }
    public void player2Pocket4()  throws Exception  {

        // Takes in the current player & starting player
        System.out.println("Button 4 Selected" + "\n");
        int location = 4;
        boolean isGameInProgress = true;
        isGameInProgress = game.updateState(location);

        if(!isGameInProgress){
            GameWinner();
        }

        game.printCurrentState();
        System.out.println("\n");

        setSide(game.getPlayers(),game.getCurrentPlayer());
    }
    public void player2Pocket5()  throws Exception  {

        // Takes in the current player & starting player
        System.out.println("Button 5 Selected" + "\n");
        int location = 5;
        boolean isGameInProgress = true;
        isGameInProgress = game.updateState(location);

        if(!isGameInProgress){
            GameWinner();
        }

        game.printCurrentState();
        System.out.println("\n");

        setSide(game.getPlayers(),game.getCurrentPlayer());
    }
}
