package pis.hue1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class CodecGui extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Verschlüssungsverfahren \"Ceasar und Würfel\"");
        //TextArea textArea = new TextArea("Entscheiden Sie welche Verschlüssungsmethode Sie verwenden wollen");
        Text text = new Text("Entscheiden Sie welche Verschlüssungsmethode Sie verwenden wollen");
        Text text2=new Text("Entscheiden Sie welche Verschlüssungsmethode Sie verwenden wollen");
        Text heading1= new Text("Verschlüssung");
        Text heading2= new Text("Entschlüssung");
        Text verschluessung_loesung=new Text();
        Text entschluessung_loesung=new Text();

        heading1.setFont(Font.font(20));
        heading2.setFont(Font.font(20));

        TextArea textArea=new TextArea();
        TextField textField=new TextField();
        TextArea textArea2=new TextArea();
        TextField textField2=new TextField();
        textArea.setPrefColumnCount(15);
        textField.setPrefColumnCount(15);
        textArea2.setPrefColumnCount(15);
        textField2.setPrefColumnCount(15);

        GridPane root=new GridPane();
        HBox hbox =new HBox();
        HBox hbox2=new HBox();
        Button wuerfeln=new Button("Wuefel");
        Button caesar=new Button("Caesar");
        Button wuerfeln2=new Button("Wuefel");
        Button caesar2=new Button("Caesar");
        Button beenden=new Button("Beenden");
        hbox.getChildren().addAll(wuerfeln,caesar);
        hbox2.getChildren().addAll(wuerfeln2,caesar2);
        hbox.setSpacing(90);
        hbox2.setSpacing(90);

        root.setHgap(5);
        root.setVgap(5);
        root.addRow(0,heading1);
        root.addRow(1,text);
        root.addRow(2, new Label("Klartext eingeben:"), textArea);
        root.addRow(3, new Label("Schlüssel eingeben:"), textField);
        root.addRow(4,hbox);
        root.addRow(5,verschluessung_loesung);
        root.addRow(6,heading2);
        root.addRow(7,text2);
        root.addRow(8, new Label("Klartext eingeben:"), textArea2);
        root.addRow(9, new Label("Schlüssel eingeben:"), textField2);
        root.addRow(10,hbox2);
        root.addRow(11,entschluessung_loesung);
        root.addRow(12,beenden);
        root.setMinSize(350, 250);
        root.setStyle("-fx-padding: 0;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 5;" +
                "-fx-border-color: white;"+
                "-fx-border-insets: 10;" +
                "-fx-border-radius: 10;" +
                "-fx-font-size: 11;"+
                "-fx-background-color:#e0e0e0"
                );
//Kkodieren________________________________________________________________________________________________
        wuerfeln.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String klartext= textArea.getText();
                String schluessel=textField.getText();
                if(schluessel==""){
                    schluessel="Schwarzwald";
                }
                Codec codec1=new Wuerfel(schluessel);
                String loesungWort= codec1.kodiere(klartext);
                verschluessung_loesung.setText("GEHEIMTEXT: " +loesungWort );

            }
        });
        caesar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String klartext= textArea.getText();
                Codec codec1=new Caesar();
                String schluessel=textField.getText();
                if(schluessel==""){
                    schluessel="THM";
                }
                codec1.setzeLosung(schluessel);
                String loesungWort= codec1.kodiere(klartext);
                verschluessung_loesung.setText("GEHEIMTEXT: " +loesungWort );

            }
        });
        //dekodieren__________________________________________________________________________

        wuerfeln2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String geheimtext= textArea2.getText();
                String schluessel=textField2.getText();
                if(schluessel==""){
                    schluessel="Schwarzwald";
                }
                Codec codec1=new Wuerfel(schluessel);
                String loesungWort= codec1.dekodiere(geheimtext);
                entschluessung_loesung.setText("KLARTEXT: " +loesungWort );

            }
        });
        caesar2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String geheimtext= textArea2.getText();
                Codec codec1=new Caesar();
                String schluessel=textField2.getText();
                codec1.setzeLosung(schluessel);
                if(schluessel==""){
                    schluessel="THM";
                }
                String loesungWort= codec1.dekodiere(geheimtext);
                entschluessung_loesung.setText("KLARTEXT: " +loesungWort );

            }
        });
        beenden.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        
        Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
