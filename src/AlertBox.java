import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

    public static void display(String title, String message) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label labelAlert = new Label();
        labelAlert.setText(message);
        labelAlert.setLayoutX(75);
        labelAlert.setLayoutY(40);

        Button closeButtonAlert = new Button("Close");
        closeButtonAlert.setLayoutX(200);
        closeButtonAlert.setLayoutY(80);
        closeButtonAlert.setOnAction(e -> window.close());

        Pane layout3 = new Pane();
        layout3.getChildren().addAll(labelAlert,closeButtonAlert);


        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout3,350,130);
        window.setScene(scene);
        window.showAndWait();
    }

}