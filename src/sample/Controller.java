package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller  {

    Player player1 = new Player("absolue", "password", "first", "last", 0);
    Player player2 = new Player("absolue", "password", "first", "last", 1);

    Game game = new Game(player1, player2);

    private ArrayList<String> usernameList = new ArrayList<>();
    private ArrayList<String> passwordList = new ArrayList<>();
    private ArrayList<String> FirstNameList = new ArrayList<>();
    private ArrayList<String> SurnameList = new ArrayList<>();

    @FXML private AnchorPane ExitGameScene; // Exit Game Scene
    @FXML private AnchorPane startScreenScene; // Start Screen
    @FXML private AnchorPane loginScreenScene; // Login Screen
    @FXML private AnchorPane leaderboardScene; // Leaderboard Screen
    @FXML private AnchorPane settingScene; // Setting Screen
    @FXML private AnchorPane PlayerProfileScene; // Player Profile Screen
    @FXML private AnchorPane CreateNewUserScreenScene; // Create New User Screen
    @FXML private AnchorPane HomeScreenMenu; // Home Screen
    @FXML private AnchorPane howToPlayScreenScene; // How To Play Screen
    @FXML private AnchorPane InvalidUsernameScreenScene; // Invalid Username Screen
    @FXML private AnchorPane selectGameModeScene; // Select Game Mode Screen
    @FXML private AnchorPane InvalidUsernameAndPasswordSScene; // No Username or Password Input Error Screen
    @FXML private AnchorPane usernameAlreadyExistScene; // No Username Already Exist Input Error Screen
    @FXML private AnchorPane shortLongPasswordScene; // Long Password Error
    @FXML private AnchorPane incorrectUserAccountScene2; // Incorrect User Count Selected
    @FXML private AnchorPane TraditionalGameModeScene; // Traditional Game Mode Scene
    @FXML private AnchorPane ArcadeGameModeScene; // Arcade Game Mode Scene
    @FXML private AnchorPane ExitCurrentGameModeScene; // Exit Confirmation Screen for the Traditional / Arcade Game Mode Scene
    @FXML private AnchorPane incorrectUserAccountScreen; // Create New User Start Screen
    @FXML private AnchorPane Player2LoginScreenScene; // Player 2 Login Screen
    @FXML private AnchorPane AdminAccountScene; // Admin Account Screen
    @FXML private AnchorPane player1StartsGameScene; // Player1 Starts Game Screen
    @FXML private AnchorPane player1WinnerScene; // Admin Account Screen
    @FXML private AnchorPane player2StartsGameScene; // Player1 Starts Game Screen
    @FXML private AnchorPane player2WinnerScene; // Admin Account Screen

    @FXML private RadioButton playerAccountButton; // "Back" Button on the login Screen
    @FXML private RadioButton adminAccountButton; // "Back" Button on the login Screen

    @FXML private Circle Player2OfflineLight = new Circle(); // Player 2 Login Confirmation Light

    // Player 1 Side Pockets
    private Boolean Player1SidePocketSelection = true;
    private Boolean Player2SidePocketSelection = true;

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

    // login Screen Input attributes
    @FXML
    private TextField username;
    @FXML
    private TextField newUsername;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField newPassword;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField Surname;

    //--------------------------- Start & Home Screen Methods ---------------------------\\

    // Load's the Start Screen
    private void StartScreen() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Mancala");
        stage.setResizable(false);

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Displays the Start Screen
        stage.setScene(new Scene(root));
        stage.show();
        stage.setOnCloseRequest(e -> Platform.exit());
    }

    // "Exit" Button on Start Screen
    public void ExitGameButton() {

        Stage stage = new Stage();
        stage = (Stage) startScreenScene.getScene().getWindow();
        System.out.println("Game Exited!");
        stage.close();
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

    // Exit Game Confirmation Screen after quit Button
    public void quit() throws Exception {

        // Exit Game Confirmation Screen properties
        Parent root = FXMLLoader.load(getClass().getResource("quitConfirmation.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Quit");

        // Hides the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Display the Exit Game Confirmation Screen
        stage.setScene(new Scene(root));
        stage.show();
    }

    // "Yes" Button on Exit Game Confirmation Screen
    public void YesExitGame() {

        // Closes the "Exit Game" pop-up confirmation screen
        Stage stage = new Stage();
        stage = (Stage) ExitGameScene.getScene().getWindow();
        System.out.println("Successfully Exited the Game");
        stage.close();
    }

    // "No" Button on Exit Game Confirmation Screen
    public void noExitGame() {
        try {
            SystemDirectory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage = (Stage) ExitGameScene.getScene().getWindow();
        System.out.println("Successfully continued the Game");
        stage.close();
    }

    // Close's the Home Screen
    public void exitHomeScreen() {
        try {
            quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Closes the Home Screen Menu
        Stage stage = new Stage();
        stage = (Stage) HomeScreenMenu.getScene().getWindow();
        stage.close();
    }

    //--------------------------- Admin Account Methods ---------------------------\\

    // Load's the Traditional Game Mode Screen & Exits the Previous Screen
    public void loadAdminAccount() {
        try {
            AdminAccount();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Closes the Home Screen Menu
        Stage stage = new Stage();
        stage = (Stage) settingScene.getScene().getWindow();
        stage.close();
    }

    // Admin Account Screen
    public void  AdminAccount() throws Exception {

        // Admin Account Properties
        Parent root = FXMLLoader.load(getClass().getResource("AdminUser.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Admin Account");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Displays the Admin Account Screen
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Close's the Admin Account Screen
    public void exitAdminScreen() {
        try {
            Setting();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Closes the Admin Account Screen
        Stage stage = new Stage();
        stage = (Stage) AdminAccountScene.getScene().getWindow();
        stage.close();
    }

    //--------------------------- Traditional Game Mode Screen Methods ---------------------------\\

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

    //--------------------------- Login Methods ---------------------------\\

    // Load's the login Screen & Exits the Previous Screen
    public void loadLogin() {
        try {
            login();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Closes the Home Screen Menu
        Stage stage = new Stage();
        stage = (Stage) startScreenScene.getScene().getWindow();
        stage.close();
    }

    // login Screen
    public void login() throws Exception {

        // Login Menu Screen Properties
        Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Login");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Displays the Login Screen
        stage.setScene(new Scene(root));
        stage.show();
    }

    // No Username & password Input
    public void validLoginInput() throws Exception {

        // If No input in the Username & Password TextField
        if (username.getLength() == 0 && password.getLength() == 0) {
            System.out.println("Login Error");
            EmptyUsernameAndPassword();

            // If Username & Password Input TextField is Invalid
        } else if (username.getLength() < 3 || username.getLength() > 10 || password.getLength() < 8 || password.getLength() > 20) {
            System.out.println("Login Error");
            EmptyUsernameAndPassword();

        } else {

            // Builds the Home Screen
            SystemDirectory();

            // Close's the Login Screen when the select Game Mode screen is created
            Stage stage = new Stage();
            stage = (Stage) loginScreenScene.getScene().getWindow();
            System.out.println("Login Screen Exited");
            stage.close();

        }
    }

    // "Back" Button on the login Screen
    public void loginBackButton() {
        try {
            StartScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Login Menu GUI properties
        Stage stage = new Stage();
        stage = (Stage) loginScreenScene.getScene().getWindow();
        System.out.println("Login Screen Exited");
        stage.close();
    }

    // Get Username Input
    public  void getUsername(){
        username.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("\n" + "Username Entered: " + username.getText()); // Confirmation of username Text Input

                // Username length verification (Long/Short)
                if(username.getLength() < 3){

                    System.out.println("Password Length: " + username.getLength());
                    try {
                        tooShortUsername();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (username.getLength() > 10){

                    System.out.println("Password Length: " + username.getLength());
                    try {
                        tooLongUsername();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    // Too Short Username Error method
    public void tooShortUsername() throws Exception {

        // Too Short Username GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("tooShortUsername.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Invalid Input");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Display the too short Username GUI
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Too Long Username Error method
    public void tooLongUsername() throws Exception {

        // Too Long Username GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("tooLongUsername.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Invalid Input");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Display the too Long Username GUI
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Get input password
    public  void getPassword(){
        password.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("\n" + "Password Entered: " + password.getText()); // Confirmation of password Text Input

                // Password length verification (Long/Short)
                if(password.getLength() < 8){

                    System.out.println("Password Length: " + password.getLength());
                    try {
                        tooShortPassword();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (password.getLength() > 20){

                    System.out.println("Password Length: " + password.getLength());
                    try {
                        tooLongPassword();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    // Too Short Password Error method
    public void tooShortPassword() throws Exception {

        // Exit Game Confirmation GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("tooShortPassword.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Invalid Input");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Display the Exit Game Confirmation GUI
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Too Long Password Error method
    public void tooLongPassword() throws Exception {

        // Exit Game Confirmation GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("tooLongPassword.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Invalid Input");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Display the Exit Game Confirmation GUI
        stage.setScene(new Scene(root));
        stage.show();
    }

    // "OK" Button on Too Short Password Error Screen
    public void passwordReattemptOKButton() {

        Stage stage = new Stage();
        stage = (Stage) shortLongPasswordScene.getScene().getWindow();
        System.out.println("Password Re-attempt");
        stage.close();
    }

    // "Ok" Button on the Invalid Username Screen
    public void InvalidUsernameOkButton() {

        // Invalid Username GUI properties
        Stage stage = new Stage();
        stage = (Stage) InvalidUsernameScreenScene.getScene().getWindow();
        System.out.println("Username Re-attempt");
        stage.close();
    }

    //--------------------------- No Username & Password Screen Methods ---------------------------\\

    // Error Screen When No Username & Password
    public void EmptyUsernameAndPassword() throws Exception {

        // No User Input properties
        Parent root = FXMLLoader.load(getClass().getResource("NoUserInput.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Invalid Input");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Display the No User Input Screen
        stage.setScene(new Scene(root));
        stage.show();
    }

    // The 'OK' Button on the Invalid Username & Password Reattempt Screen
    public void LoginAndCreateNewUserReattempt(){

        Stage stage = new Stage();
        stage = (Stage) InvalidUsernameAndPasswordSScene.getScene().getWindow();
        System.out.println("Login Re-Attempt Executed");
        stage.close();
    }

    // The 'OK' Button on the Username Already Exist Reattempt Screen
    public void UsernameAlreadyExistReattemptButton(){

        Stage stage = new Stage();
        stage = (Stage) usernameAlreadyExistScene.getScene().getWindow();
        System.out.println("Re-Attempt Executed");
        stage.close();
    }

    //   Account Type Selected Reattempt Screen
    public void incorrectUserAccount()  throws Exception{

        // No Account Type Selected Input properties
        Parent root = FXMLLoader.load(getClass().getResource("incorrectUserAccount.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Invalid Input");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Display the No Account Type Selected Screen
        stage.setScene(new Scene(root));
        stage.show();
    }

    //   Account Type Selected Reattempt Start Screen
    public void incorrectUserAccountStartScreen()  throws Exception{

        // No Account Type Selected Input properties
        Parent root = FXMLLoader.load(getClass().getResource("incorrectUserAccountStartScreen.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Invalid Input");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Display the No Account Type Selected Screen
        stage.setScene(new Scene(root));
        stage.show();
    }

    // The 'OK' Button on the No Account Type Selected Reattempt Screen
    public void incorrectUserAccountButton(){

        Stage stage = new Stage();
        stage = (Stage) incorrectUserAccountScreen.getScene().getWindow();
        System.out.println("Re-Attempt Executed");
        stage.close();
    }

    // The 'OK' Button on the No Account Type Selected Reattempt Start Screen
    public void incorrectUserAccountButtonStartScreen(){
        try {
            createNewUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage = (Stage) incorrectUserAccountScene2.getScene().getWindow();
        System.out.println("Re-Attempt Executed");
        stage.close();
    }

    //--------------------------- How to Play Screen Methods ---------------------------\\

    // Load's the How To Play Screen & Exits the Previous Screen
    public void loadHowToPlay() {
        try {
            howToPlay();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Closes the Home Screen Menu
        Stage stage = new Stage();
        stage = (Stage) HomeScreenMenu.getScene().getWindow();
        stage.close();
    }

    // How to Play Screen
    public void howToPlay() throws Exception {

        // How to Play Menu GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("howToPlay.fxml"));
        Stage stage = new Stage();
        stage.setTitle("How To Play");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Displays the How to Play Screen
        stage.setScene(new Scene(root));
        stage.show();
    }

    // "Back" Button on How To Play Screen
    public void exitHowToPlay() {
        try {
            SystemDirectory();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage = (Stage) howToPlayScreenScene.getScene().getWindow();
        System.out.println("How To Play Screen Exited");
        stage.close();
    }

    //--------------------------- Create New User Screen Methods ---------------------------\\

    // Load's the Create New User Screen & Exits the Login Screen
    public void loadCreateNewUserLoginScreen() {
        try {
            createNewUser();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Closes the Home Screen Menu
        Stage stage = new Stage();
        stage = (Stage) loginScreenScene.getScene().getWindow();
        stage.close();
    }

    // Load's the Create New User Screen & Exits the Previous Screen
    public void loadCreateNewUser() {
        try {
            createNewUser();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Closes the Home Screen Menu
        Stage stage = new Stage();
        stage = (Stage) startScreenScene.getScene().getWindow();
        stage.close();
    }

    // Create New User Screen
    public void createNewUser() throws Exception {

        // Builds the system home Screen
        Parent root = FXMLLoader.load(getClass().getResource("CreateNewUser.fxml"));
        Stage stage = new Stage();
        stage.setTitle("New User");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Displays the Create New User Screen
        stage.setScene(new Scene(root));
        stage.show();

    }

    // New User, No Username & password valid Input
    public void validCreateNewUserInput() throws Exception {

        // If No input in the First Name, Surname, Username & Password TextField Error Message
        if (FirstName.getLength() == 0 && Surname.getLength() == 0 && newUsername.getLength() == 0 && newPassword.getLength() == 0){
            System.out.println("Data Input Error");
            EmptyUsernameAndPassword();

            // If Username & Password Input TextField is Invalid
        } else if (FirstName.getLength() < 1 || FirstName.getLength() > 10 && Surname.getLength() < 1 || Surname.getLength() > 20 || newUsername.getLength() < 3 || newUsername.getLength() > 10 && newPassword.getLength() < 8 || newPassword.getLength() > 20) {
            System.out.println("Data Input Error");
            EmptyUsernameAndPassword();

        } else if (playerAccountButton.isSelected() && adminAccountButton.isSelected()) {
            System.out.println("Both Account Type Selected");
            incorrectUserAccountStartScreen();

        } else if (!playerAccountButton.isSelected() && !adminAccountButton.isSelected()) {
            System.out.println("No Account Type Selected");
            incorrectUserAccountStartScreen();

        } else {

            FirstNameList.add(FirstName.getText());
            SurnameList.add(Surname.getText());
            usernameList.add(newUsername.getText());
            passwordList.add(newPassword.getText());
            System.out.println("New User Information Added to Database");

            //  New Account Verification



            // Builds the Home Screen
            SystemDirectory();

            // Close's the Create New User Screen, when the select Game Mode screen is created
            Stage stage = new Stage();
            stage = (Stage) CreateNewUserScreenScene.getScene().getWindow();
            System.out.println("Create New User Screen Exited");
            stage.close();
        }
    }

    // Get input Username
    public  void getNewUsername(){
        newUsername.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("\n" + "Username Entered: " + newUsername.getText()); // Confirmation of username Text Input

                // Username length verification (Long/Short)
                int usernameLength = newUsername.getLength();

                if(usernameLength < 3){

                    System.out.println("Password Length: " + usernameLength);
                    try {
                        tooShortNewUsername();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (usernameLength > 10){

                    System.out.println("Password Length: " + usernameLength);
                    try {
                        tooLongNewUsername();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    // Too Short New Username Error method
    public void tooShortNewUsername() throws Exception {

        // Too Short New Username GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("tooShortUsername.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Invalid Input");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("gfghjgfjfg.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Display the too short New Username GUI
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Too Long Username Error method
    public void tooLongNewUsername() throws Exception {

        // Too Long Username GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("tooLongUsername.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Invalid Input");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("gfghjgfjfg.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Display the too Long Username GUI
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Get New password input
    public  void getNewPassword(){
        newPassword.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("\n" + "Password Entered: " + newPassword.getText()); // Confirmation of password Text Input

                // Password length verification (Long/Short)
                int passwordLength = newPassword.getLength();
                if(passwordLength < 8){

                    System.out.println("Password Length: " + passwordLength);
                    try {
                        tooShortNewPassword();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (passwordLength > 20){

                    System.out.println("Password Length: " + passwordLength);
                    try {
                        tooLongNewPassword();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    // Too Short New Password Error method
    public void tooShortNewPassword() throws Exception {

        // Exit Game Confirmation GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("tooShortPassword.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Invalid Input");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("gfghjgfjfg.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Display the Exit Game Confirmation GUI
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Too Long New Password Error method
    public void tooLongNewPassword() throws Exception {
        // Exit Game Confirmation GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("tooLongPassword.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Invalid Input");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("gfghjgfjfg.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Display the Exit Game Confirmation GUI
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Exits the Create the New User Screen Back to the Login Screen
    public void exitCreateNewUserScreen() throws Exception {
        try {
            StartScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create New User Screen properties
        Stage stage = new Stage();
        stage = (Stage) CreateNewUserScreenScene.getScene().getWindow();
        System.out.println("Screen Exited");
        stage.close();
    }

    //--------------------------- Select Game Mode Screen Methods ---------------------------\\

    // Load's the Home Screen
    public void loadSelectGameMode() {
        try {
            selectGameMode();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Closes the Home Screen Menu
        Stage stage = new Stage();
        stage = (Stage) HomeScreenMenu.getScene().getWindow();
        stage.close();
    }

    // Select Game Mode Screen
    public void selectGameMode() throws Exception {

        // Select Game Mode GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("selectGameMode.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Game Mode");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Select Game Mode GUI to visible
        stage.setScene(new Scene(root));
        stage.show();

    }

    // Exits the select Game Mode Screen Back to the Home Screen
    public void exitSelectGameMode() {
        try {
            SystemDirectory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Create New User GUI properties
        Stage stage = new Stage();
        stage = (Stage) selectGameModeScene.getScene().getWindow();
        System.out.println("Select Game Mode Screen Exited");
        stage.close();
    }

    //--------------------------- Setting Screen Methods ---------------------------\\

    // Load's the Setting Screen & Exits the Previous Screen
    public void loadSetting() {
        try {
            Setting();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Closes the Home Screen Menu
        Stage stage = new Stage();
        stage = (Stage) HomeScreenMenu.getScene().getWindow();
        stage.close();
    }

    // Setting Screen
    public void Setting() throws Exception {

        // Setting Menu GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("Setting.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Setting");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        stage.setScene(new Scene(root));
        stage.show();

    }

    // Exits the Setting Screen Back to the Home Screen
    public void exitSetting() {
        try {
            SystemDirectory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Setting GUI properties
        Stage stage = new Stage();
        stage = (Stage) settingScene.getScene().getWindow();
        System.out.println("Setting Screen Exited");
        stage.close();
    }

    //--------------------------- leaderboard Screen Methods ---------------------------\\

    // Load's the leaderboard Screen & Exits the Previous Screen
    public void loadLeaderboard() {
        try {
            leaderboard();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Closes the Home Screen Menu
        Stage stage = new Stage();
        stage = (Stage) HomeScreenMenu.getScene().getWindow();
        stage.close();
    }

    // leaderboard Screen
    public void leaderboard() throws Exception {

        // Setting Menu GUI properties
        Parent root = FXMLLoader.load(getClass().getResource("leaderboard.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Leaderboard");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        stage.setScene(new Scene(root));
        stage.show();

    }

    // Ranked Players based on Total Wins
    public void TotalWinsRank() {
    }

    // Ranked Players based on Total Wins Percentage
    public void TotalWinsRankPercentage() {
    }

    // Exits the leaderboard Screen Back to the Home Screen
    public void exitLeaderboard() {
        try {
            SystemDirectory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // leaderboard GUI properties
        Stage stage = new Stage();
        stage = (Stage) leaderboardScene.getScene().getWindow();
        System.out.println("Leaderboard Screen Exited");
        stage.close();
    }

    //--------------------------- Player Profile Screen Methods ---------------------------\\

    // Load's the leaderboard Screen & Exits the Previous Screen
    public void loadViewPlayerProfile() {
        try {
            viewPlayerProfile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Closes the Home Screen Menu
        Stage stage = new Stage();
        stage = (Stage) leaderboardScene.getScene().getWindow();
        stage.close();
    }

    // Player Profile Screen
    public void viewPlayerProfile() throws Exception {

        // Player Profile Screen properties
        Parent root = FXMLLoader.load(getClass().getResource("PlayerProfile.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Player Profile");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Display's Player Profile Screen
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Exits the Player Profile Screen Back to the Home Screen
    public void exitPlayerProfile() {
        try {
            leaderboard();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Player Profile Screen properties
        Stage stage = new Stage();
        stage = (Stage) PlayerProfileScene.getScene().getWindow();
        System.out.println("Player Profile Screen Exited");
        stage.close();
    }

    //--------------------------- Login Player 2 Methods ---------------------------\\

    // Load's the Player 2 login Screen & Exits the Previous Screen
    public void loadPlayer2Login() {
        try {
            Player2login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Player 2 login Screen
    public void Player2login() throws Exception {

        // Player 2  Login Menu Screen Properties
        Parent root = FXMLLoader.load(getClass().getResource("Player2LoginScreen.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Player 2 Login");

        // Removes the Minimize, Maximize & Close window buttons
        stage.resizableProperty().setValue(false);
        stage.initStyle(StageStyle.UNDECORATED);

        // Screen Icon properties
        Image systemIcon = new Image("Icon.png"); // Select a Icon image for the Display top left conner of the screen
        stage.getIcons().add(systemIcon);

        // Sets the screen resizability to false
        stage.setResizable(false);

        // Displays the Player 2 Login Screen
        stage.setScene(new Scene(root));
        stage.show();
    }

    // No Player 2 Username & password Input
    public void validPlayer2LoginInput() throws Exception {

        // If No input in the Username & Password TextField
        if (username.getLength() == 0 && password.getLength() == 0) {
            System.out.println("Login Error");
            EmptyUsernameAndPassword();

            // If Username & Password Input TextField is Invalid
        } else if (username.getLength() < 3 || username.getLength() > 10 || password.getLength() < 8 || password.getLength() > 20) {
            System.out.println("Login Error");
            EmptyUsernameAndPassword();

        } else {

            // Player 2 Online Confirmation
            Player2OfflineLight.setOpacity(0);

            // Closes the Home Screen Menu
            Stage stage = new Stage();
            stage = (Stage) Player2LoginScreenScene.getScene().getWindow();
            stage.close();
        }
    }

    // "Back" Button on the Player 2 login Screen
    public void Player2loginBackButton() {

        // Login Menu GUI properties
        Stage stage = new Stage();
        stage = (Stage) Player2LoginScreenScene.getScene().getWindow();
        System.out.println("Login Screen Exited");
        stage.close();
    }

}