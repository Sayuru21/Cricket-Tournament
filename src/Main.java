import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.text.Element;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Main extends Application {

     ArrayList<String> playerNameArr,playerNumberArr,schoolTeamArr,ageArr,roleArr;
     ArrayList<String> playerNameArr1,playerNumberArr1,matchScoreArr,boundariesArr,
             ballsFacedTeamArr,venueArr;
     int i,j ;
     String playerName,schoolTeam,role,playerNumber,age;
     String playerNameColumn,schoolTeamColumn,playerRoleColumn,playerNumberColumn,
             playerAgeColumn;
     String playerNameColumn1,playerNumberColumn1,scoreColumn,boundariesColumn,ballsColumn,
              venueColumn;
     TextField scene2BPSPTF1,scene2BPSPTF3,scene2BPSPTF4,scene2BPSPTF5,scene2BPSPTF6;
     Label scene2BPSPLb7;
     int playerNameIndex;
     boolean isExist;
     VBox scene2BPVAPVb,scene2BPISDVb;
     TableView<Product> table;
     TableView<Product1> table1;
     Stage window;
     Scene scene1,scene2;
     BorderPane layout2;
    private Object ImageView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {



        window = primaryStage;

        Button scene1Button1 = new Button("Next");
        scene1Button1.setLayoutX(400);
        scene1Button1.setLayoutY(450);
        scene1Button1.setOnAction(e -> window.setScene(scene2));

        Label scene1Label1 = new Label("ABC cricket tournament ");
        scene1Label1.setLayoutX(50);
        scene1Label1.setLayoutY(10);
        scene1Label1.setStyle("-fx-font-size: 40px");

        FileInputStream input = new FileInputStream("Welcome-Speech-for-Cricket.png");
        javafx.scene.image.Image image = new Image(input);

        javafx.scene.image.ImageView imageView = new ImageView(image);
        imageView.setFitHeight(500);
        imageView.setFitWidth(500);
        HBox hbox = new HBox(imageView);

        Pane layout1 = new Pane();
        layout1.getChildren().addAll(hbox,scene1Label1,scene1Button1);
        scene1 = new Scene(layout1,500,500);

        Button scene2Home = new Button("Home");
        scene2Home.setOnAction(e -> window.setScene(scene1));

        Label scene2BPIPLb1 = new Label("Player name");
        TextField scene2BPIPTF1 = new TextField();

        Label scene2BPIPLb3 = new Label("Player number");
        TextField scene2BPIPTF3 = new TextField();

        Label scene2BPIPLb4 = new Label("School team");
        ChoiceBox<String> scene2BPIPCB1 = new ChoiceBox<>();
        scene2BPIPCB1.getItems().addAll("CCC","NCC","PCC","SSC","BFC","BRC","RCP",
                "MMV","STC","MCP");

        Label scene2BPIPLb5 = new Label("Age");
        TextField scene2BPIPTF5 = new TextField();

        Label scene2BPIPLb6 = new Label("Role");
        ChoiceBox<String> scene2BPIPCB2 = new ChoiceBox<>();
        scene2BPIPCB2.getItems().addAll("Captain","Vice-captain","Wicket-keeper",
                "Batsman","Bowler","All rounder");

        Button scene2BPIPBtn2 = new Button("Clear all");
        scene2BPIPBtn2.setLayoutX(310);
        scene2BPIPBtn2.setLayoutY(300);
        scene2BPIPBtn2.setOnAction(e -> {

            scene2BPIPTF1.setText("");
            scene2BPIPTF3.setText("");
            scene2BPIPTF5.setText("");
        });

        Button scene2BPIPBtn1 = new Button("Add");
        scene2BPIPBtn1.setLayoutX(250);
        scene2BPIPBtn1.setLayoutY(300);

        scene2BPIPBtn1.setOnAction(e -> {

            String insertPlayerName,insertPlayerNumber,insertSchoolTeam,insertAge,
                    insertRole;

            insertPlayerName = scene2BPIPTF1.getText();
            insertPlayerNumber = scene2BPIPTF3.getText();
            insertSchoolTeam = scene2BPIPCB1.getValue();
            insertAge = scene2BPIPTF5.getText();
            insertRole = scene2BPIPCB2.getValue();
            int insertAgeInt = 12;
            int insertPlayerNumberInt = 0 ;

                if (insertPlayerName.equals("") || insertPlayerNumber.equals("") ||
                        insertSchoolTeam.equals("") ||
                        insertAge.equals("") || insertRole.equals("")) {

                    AlertBox.display("AlertBox", "Please fill all inputs");

                }
                try {
                    insertPlayerNumberInt = Integer.parseInt(insertPlayerNumber);
                }
                catch (Exception e2) {

                    AlertBox.display("AlertBox", "Please enter valid number");
                }

                try {

                        insertAgeInt = Integer.parseInt(insertAge);
                    }
                catch (Exception e2){

                        AlertBox.display("AlertBox", "Please enter valid age");
                }

                if ( !( 0 < insertPlayerNumberInt && insertPlayerNumberInt < 100)){

                    AlertBox.display("AlertBox", "Player number is out of range");
                }

            if ( !( 12 < insertAgeInt && insertAgeInt< 19)){

                AlertBox.display("AlertBox", "Age is out of range");
            }

            if (!(insertPlayerName.equals("") || insertPlayerNumber.equals("") ||
                    insertSchoolTeam.equals("") || insertAge.equals("") || insertRole.equals("")) &&
                    0 < insertPlayerNumberInt && insertPlayerNumberInt < 100 &&
                    12 < insertAgeInt && insertAgeInt< 19) {


                playerNameArr.add(insertPlayerName);
                playerNumberArr.add(insertPlayerNumber);
                schoolTeamArr.add(insertSchoolTeam);
                ageArr.add(insertAge);
                roleArr.add(insertRole);

                System.out.println(playerNameArr);
                System.out.println(playerNumberArr);
                System.out.println(schoolTeamArr);
                System.out.println(ageArr);
                System.out.println(roleArr);

                TableColumn<Product, String> nameColumn = new TableColumn<>("Player name");
                nameColumn.setMinWidth(200);
                nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));


                TableColumn<Product, String> numberColumn = new TableColumn<>("Player number");
                numberColumn.setMinWidth(100);
                numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));


                TableColumn<Product, String> teamColumn = new TableColumn<>("School team");
                teamColumn.setMinWidth(100);
                teamColumn.setCellValueFactory(new PropertyValueFactory<>("team"));

                TableColumn<Product, String> ageColumn = new TableColumn<>("Age");
                ageColumn.setMinWidth(100);
                ageColumn.setCellValueFactory(new PropertyValueFactory<>("playerAge"));

                TableColumn<Product, String> roleColumn = new TableColumn<>("Role");
                roleColumn.setMinWidth(100);
                roleColumn.setCellValueFactory(new PropertyValueFactory<>("playerRole"));



                table = new TableView<>();
                table.setItems(getProduct());
                table.getColumns().addAll(nameColumn,numberColumn,teamColumn,ageColumn,roleColumn);

                scene2BPVAPVb = new VBox();
                scene2BPVAPVb.getChildren().addAll(table);
            }
        });

        VBox scene2BPIPVb1 = new VBox();
        scene2BPIPVb1.setSpacing(30);
        scene2BPIPVb1.setLayoutX(50);
        scene2BPIPVb1.setLayoutY(60);
        scene2BPIPVb1.getChildren().addAll(scene2BPIPLb1,scene2BPIPLb3
                ,scene2BPIPLb4,scene2BPIPLb5,scene2BPIPLb6);


        VBox scene2BPIPVb2 = new VBox();
        scene2BPIPVb2.setSpacing(20);
        scene2BPIPVb2.setLayoutX(150);
        scene2BPIPVb2.setLayoutY(60);
        scene2BPIPVb2.getChildren().addAll(scene2BPIPTF1,scene2BPIPTF3
                ,scene2BPIPCB1,scene2BPIPTF5,scene2BPIPCB2);

        Pane scene2BPIPPane = new Pane();
        scene2BPIPPane.getChildren().addAll(scene2BPIPVb1,scene2BPIPVb2,scene2BPIPBtn1,
                scene2BPIPBtn2);

        Button scene2InsertPlayerDetails = new Button("Insert Player details");
        scene2InsertPlayerDetails.setOnAction(e -> layout2.setCenter(scene2BPIPPane));


        playerNameArr = new ArrayList<String>();
        playerNumberArr = new ArrayList<String>();
        schoolTeamArr =  new ArrayList<String>();
        ageArr = new ArrayList<String>();
        roleArr = new ArrayList<String>();

        playerNameArr1 = new ArrayList<String>();
        playerNumberArr1 = new ArrayList<String>();
        matchScoreArr = new ArrayList<String>();
        boundariesArr =  new ArrayList<String>();
        ballsFacedTeamArr = new ArrayList<String>();
        venueArr = new ArrayList<String>();



        Label scene2BPSPLb1 = new Label("Enter player's name");
        scene2BPSPLb1.setLayoutX(80);
        scene2BPSPLb1.setLayoutY(50);

        scene2BPSPTF1 = new TextField();
        scene2BPSPTF1 .setLayoutX(200);
        scene2BPSPTF1 .setLayoutY(50);
        scene2BPSPTF1.setPrefWidth(200);

        Label scene2BPSPLb3 = new Label("Player number");
        scene2BPSPTF3 = new TextField();

        Label scene2BPSPLb4 = new Label("School team");
        scene2BPSPTF4 = new TextField();

        Label scene2BPSPLb5 = new Label("Age");
        scene2BPSPTF5 = new TextField();

        Label scene2BPSPLb6 = new Label("Role");
        scene2BPSPTF6 = new TextField();

        scene2BPSPLb7 = new Label("");
        scene2BPSPLb7.setLayoutX(100);
        scene2BPSPLb7.setLayoutY(350);

        Button scene2BPSPBtn2 = new Button("Clear name");
        scene2BPSPBtn2.setLayoutX(450);
        scene2BPSPBtn2.setLayoutY(50);
        scene2BPSPBtn2.setOnAction(e -> scene2BPSPTF1.setText(""));

        Button scene2BPSPBtn1 = new Button("Search");
        scene2BPSPBtn1.setLayoutX(250);
        scene2BPSPBtn1.setLayoutY(300);
        scene2BPSPBtn1.setOnAction(e -> searchPlayer());


        VBox scene2BPVb1 = new VBox();
        scene2BPVb1.setSpacing(30);
        scene2BPVb1.setLayoutX(50);
        scene2BPVb1.setLayoutY(110);
        scene2BPVb1.getChildren().addAll(scene2BPSPLb3
                ,scene2BPSPLb4,scene2BPSPLb5,scene2BPSPLb6);


        VBox scene2BPVb2 = new VBox();
        scene2BPVb2.setSpacing(20);
        scene2BPVb2.setLayoutX(150);
        scene2BPVb2.setLayoutY(110);
        scene2BPVb2.getChildren().addAll(scene2BPSPTF3
                ,scene2BPSPTF4,scene2BPSPTF5,scene2BPSPTF6);

        Pane scene2BPSPPane = new Pane();
        scene2BPSPPane.getChildren().addAll(scene2BPVb1,scene2BPVb2,scene2BPSPLb1,
                scene2BPSPTF1,scene2BPSPLb7,scene2BPSPBtn1,scene2BPSPBtn2);

        Button scene2SearchPlayer = new Button("Search Player");
        scene2SearchPlayer.setOnAction(e -> layout2.setCenter(scene2BPSPPane));



        Button scene2AllPlayers = new Button("View all players");
        scene2AllPlayers.setOnAction(e -> layout2.setCenter(scene2BPVAPVb));

        Button scene2MatchInformation = new Button("Match information");

        Label scene2BPISDLb6 = new Label("Player name");
        TextField scene2BPISDTF6 = new TextField();

        Label scene2BPISDLb7 = new Label("Player number");
        TextField scene2BPISDTF7 = new TextField();

        Label scene2BPISDLb1 = new Label("Runs");
        TextField scene2BPISDTF1 = new TextField();

        Label scene2BPISDLb3 = new Label("Boundaries");
        TextField scene2BPISDTF3 = new TextField();

        Label scene2BPISDLb4 = new Label("Balls faced");
        TextField scene2BPISDTF4 = new TextField();

        Label scene2BPISDLb5 = new Label("Venue");
        ChoiceBox<String> scene2BPISDCB2 = new ChoiceBox<>();
        scene2BPISDCB2.getItems().addAll("R. Premadasa stadium",
                "Suriyawewa cricket stadium","Bloomfield cricket ground","Panadura sports stadium");

        Button scene2BPISDBtn2 = new Button("Clear all");
        scene2BPISDBtn2.setLayoutX(310);
        scene2BPISDBtn2.setLayoutY(350);
        scene2BPISDBtn2.setOnAction(e -> {

            scene2BPISDTF1.setText("");
            scene2BPISDTF3.setText("");
            scene2BPISDTF4.setText("");
            scene2BPISDTF6.setText("");
            scene2BPISDTF7.setText("");
        });

        Button scene2BPISDBtn1 = new Button("Add");
        scene2BPISDBtn1.setLayoutX(250);
        scene2BPISDBtn1.setLayoutY(350);
        scene2BPISDBtn1.setOnAction(e -> {

            String insertMatchScore,insertBoundaries,insertBallsFaced,insertVenue,
                    insertPlayerNumber1,insertPlayerName1;

            insertMatchScore = scene2BPISDTF1.getText();
            insertBoundaries = scene2BPISDTF3.getText();
            insertBallsFaced = scene2BPISDTF4.getText();
            insertVenue = scene2BPISDCB2.getValue();
            insertPlayerNumber1 = scene2BPISDTF7.getText();
            insertPlayerName1 = scene2BPISDTF6.getText();

            int insertMatchScoreInt = 0,insertBoundariesInt = 0,
                    insertBallsFacedInt = 0,insertPlayerNumberInt1 = 0;

            if (insertPlayerName1.equals("") || insertPlayerNumber1.equals("") || insertMatchScore.equals("") || insertBoundaries.equals("") ||
                    insertBallsFaced.equals("") ||
                    insertVenue.equals("")) {

                AlertBox.display("AlertBox", "Please fill all inputs");

            }
            try {
                insertMatchScoreInt = Integer.parseInt(insertMatchScore);
            }
            catch (Exception e1) {

                AlertBox.display("AlertBox", "Please enter valid score");
            }

            try {

                insertBoundariesInt = Integer.parseInt(insertBoundaries);
            }
            catch (Exception e2){

                AlertBox.display("AlertBox", "Please enter valid boundaries");
            }

            try {

                insertBallsFacedInt = Integer.parseInt(insertBallsFaced);
            }
            catch (Exception e3){

                AlertBox.display("AlertBox", "Please enter the valid number of balls");
            }

            try {
                insertPlayerNumberInt1 = Integer.parseInt(insertPlayerNumber1);
            }
            catch (Exception e4) {

                AlertBox.display("AlertBox", "Please enter valid number");
            }

            if ( !( 0 < insertPlayerNumberInt1 && insertPlayerNumberInt1 < 100)){

                AlertBox.display("AlertBox", "Player number is out of range");
            }

            if ( !( -1 < insertMatchScoreInt )){

                AlertBox.display("AlertBox", "Score is out of range");
            }

            if ( !( -1 < insertBoundariesInt)){

                AlertBox.display("AlertBox", "Boundaries are out of range");
            }

            if (  !( -1 < insertBallsFacedInt)){

                AlertBox.display("AlertBox", "Balls are out of range");
            }


            if (!(insertMatchScore.equals("") || insertBoundaries.equals("") ||
                    insertBallsFaced.equals("") ||
                    insertVenue.equals(""))  && 0 < insertPlayerNumberInt1 && insertPlayerNumberInt1 < 100
                    && -1 < insertMatchScoreInt  && -1 < insertBoundariesInt &&
                    -1 < insertBallsFacedInt) {

                playerNameArr1.add(insertPlayerName1);
                playerNumberArr1.add(insertPlayerNumber1);
                matchScoreArr.add(insertMatchScore);
                boundariesArr.add(insertBoundaries);
                ballsFacedTeamArr.add(insertBallsFaced);
                venueArr.add(insertVenue);

                System.out.println(playerNameArr1);
                System.out.println(playerNumberArr1);
                System.out.println(matchScoreArr);
                System.out.println(boundariesArr);
                System.out.println(ballsFacedTeamArr);
                System.out.println(venueArr);

                TableColumn<Product1, String> nameColumn1 = new TableColumn<>("Player name");
                nameColumn1.setMinWidth(200);
                nameColumn1.setCellValueFactory(new PropertyValueFactory<>("name1"));

                TableColumn<Product1, String> numberColumn1 = new TableColumn<>("Player number");
                numberColumn1.setMinWidth(100);
                numberColumn1.setCellValueFactory(new PropertyValueFactory<>("number1"));

                TableColumn<Product1, String> scoreColumn = new TableColumn<>("Match score");
                scoreColumn.setMinWidth(100);
                scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));


                TableColumn<Product1, String> boundariesColumn = new TableColumn<>("Boundaries");
                boundariesColumn.setMinWidth(100);
                boundariesColumn.setCellValueFactory(new PropertyValueFactory<>("boundaries"));


                TableColumn<Product1, String> ballsColumn = new TableColumn<>("Balls faced");
                ballsColumn.setMinWidth(100);
                ballsColumn.setCellValueFactory(new PropertyValueFactory<>("balls"));

                TableColumn<Product1, String> venueColumn = new TableColumn<>("Venue");
                venueColumn.setMinWidth(200);
                venueColumn.setCellValueFactory(new PropertyValueFactory<>("venue"));


                table1 = new TableView<>();
                table1.setItems(getProduct1());
                table1.getColumns().addAll(nameColumn1,numberColumn1,scoreColumn,boundariesColumn,ballsColumn,venueColumn);

                scene2BPISDVb = new VBox();
                scene2BPISDVb.getChildren().addAll(table1);
            }});

        VBox scene2BPISDVb1 = new VBox();
        scene2BPISDVb1.setSpacing(30);
        scene2BPISDVb1.setLayoutX(50);
        scene2BPISDVb1.setLayoutY(60);
        scene2BPISDVb1.getChildren().addAll(scene2BPISDLb6,scene2BPISDLb7,scene2BPISDLb1,scene2BPISDLb3
                ,scene2BPISDLb4,scene2BPISDLb5);


        VBox scene2BPISDVb2 = new VBox();
        scene2BPISDVb2.setSpacing(20);
        scene2BPISDVb2.setLayoutX(150);
        scene2BPISDVb2.setLayoutY(60);
        scene2BPISDVb2.getChildren().addAll(scene2BPISDTF6,scene2BPISDTF7,scene2BPISDTF1,scene2BPISDTF3
                ,scene2BPISDTF4,scene2BPISDCB2);

        Pane scene2BPISDPane = new Pane();
        scene2BPISDPane.getChildren().addAll(scene2BPISDVb1,scene2BPISDVb2,scene2BPISDBtn1,
                scene2BPISDBtn2);



        Button scene2InsertData = new Button("Insert score data");
        scene2InsertData.setOnAction(e -> layout2.setCenter(scene2BPISDPane));

        Button scene2AllWinners = new Button("Winners");
        scene2AllWinners.setOnAction(e -> layout2.setCenter(scene2BPISDVb));

        HBox scene2BPHB = new HBox();
        scene2BPHB.getChildren().addAll(scene2Home,scene2InsertPlayerDetails,scene2SearchPlayer,
                scene2AllPlayers,scene2MatchInformation,scene2InsertData,scene2AllWinners);
        scene2BPHB.setSpacing(10);

        layout2 = new BorderPane();
        layout2.setTop(scene2BPHB);



        scene2 = new Scene(layout2,850,500);

        window.setScene(scene1);
        window.setTitle("ABC cricket tournament");
        window.show();


    }

    public void searchPlayer(){

        playerName = scene2BPSPTF1.getText();

        isExist = playerNameArr.contains(playerName);

        if (isExist == true){

            playerNameIndex = playerNameArr.indexOf(playerName);

            playerNumber = playerNumberArr.get(playerNameIndex);
            schoolTeam = schoolTeamArr.get(playerNameIndex);
            age = ageArr.get(playerNameIndex);
            role = roleArr.get(playerNameIndex);

            scene2BPSPTF3.setText(playerNumber);
            scene2BPSPTF4.setText(schoolTeam);
            scene2BPSPTF5.setText(age);
            scene2BPSPTF6.setText(role);

        }
        else if (playerName.equals("")){

            scene2BPSPLb7.setText("Please enter a name");
        }
        else{

            scene2BPSPLb7.setText("Player is not found");
        }

    }

    //Get all of the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();

        for (i = 0;i < playerNameArr.size();i++){

            playerNameColumn = playerNameArr.get(i);
            playerNumberColumn = playerNumberArr.get(i);
            schoolTeamColumn = schoolTeamArr.get(i);
            playerAgeColumn = ageArr.get(i);
            playerRoleColumn = roleArr.get(i);

            products.add(new Product(playerNameColumn,playerNumberColumn,schoolTeamColumn
                    ,playerAgeColumn,playerRoleColumn));

            if (i == 10 || i == 21 || i == 32 || i == 43){

                products.add(new Product("","","","",""));
                products.add(new Product("","","","",""));
            }
        }

        return products;
    }

    public ObservableList<Product1> getProduct1(){

        ObservableList<Product1> products1 = FXCollections.observableArrayList();

        int scoreColumnInt,maximumScore;

        for (j = 0;j < playerNameArr1.size();j++){

            playerNameColumn1 = playerNameArr1.get(j);
            playerNumberColumn1 = playerNumberArr1.get(j);
            scoreColumn = matchScoreArr.get(j);
            boundariesColumn = boundariesArr.get(j);
            ballsColumn = ballsFacedTeamArr.get(j);
            venueColumn = venueArr.get(j);

             scoreColumnInt = Integer.parseInt(scoreColumn);
             maximumScore = 0;
             maximumScore += scoreColumnInt;

            if(venueColumn.equals("R. Premadasa stadium")){

                if (maximumScore < scoreColumnInt){

                    maximumScore = scoreColumnInt;


                }
            }

        }
        products1.add(new Product1(playerNameColumn1,playerNumberColumn1,scoreColumn,
                boundariesColumn,ballsColumn,venueColumn));
        System.out.println(products1);
        return products1;

    }
}
