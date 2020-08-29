import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class app extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub

        GridPane root = new GridPane();
        Scene scene = new Scene(root, 500, 300);
        MenuBar menubar = new MenuBar();
        Menu FileMenu = new Menu("File");
        MenuItem filemenu1 = new MenuItem("Clear Messages");
        MenuItem filemenu2 = new MenuItem("Clear Forms");
        MenuItem filemenu3 = new MenuItem("Exit Portal");
        MenuItem filemenu4 = new MenuItem("Save credentials");
        Menu EditMenu = new Menu("Edit");
        Menu subMenu1 = new Menu("Cut");
        Menu subMenu2 = new Menu("Copy");
        Menu subMenu3 = new Menu("Paste");
        MenuItem menuItem11 = new MenuItem("Cut Username");
        MenuItem menuItem12 = new MenuItem("Cut Password");
        MenuItem menuItem21 = new MenuItem("Copy Username");
        MenuItem menuItem22 = new MenuItem("Copy Password");
        MenuItem menuItem31 = new MenuItem("Paste in Username");
        MenuItem menuItem32 = new MenuItem("Paste in Password");

        root.setStyle("-fx-padding: 8;" + "-fx-border-style: solid inside;" + "-fx-border-width: 4;"
                + "-fx-border-radius: 6;" + "-fx-border-color: green;");
        menubar.setStyle("-fx-border-color: blue;");
        subMenu1.getItems().addAll(menuItem11,menuItem12);
        subMenu2.getItems().addAll(menuItem21,menuItem22);
        subMenu3.getItems().addAll(menuItem31,menuItem32);
        EditMenu.getItems().addAll(subMenu1, subMenu2, subMenu3);
        root.setVgap(50);
        root.addRow(0, menubar);
        FileMenu.getItems().addAll(filemenu1, filemenu2, filemenu3, filemenu4);
        menubar.getMenus().addAll(FileMenu, EditMenu);
        Text text = new Text();

        text.setText("Welcome to Portal");
        text.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
        primaryStage.setTitle("JavaFX Login");
        Label name = new Label("UserName");
        Label pass = new Label("Password");
        TextField tf1 = new TextField();
        PasswordField tf2 = new PasswordField();
        Button Submit = new Button("Submit");

        root.addRow(1, text);
        root.setVgap(10);
        root.addRow(2, name, tf1);
        root.setVgap(10);
        root.addRow(3, pass, tf2);
        root.setVgap(10);
        root.addRow(4, Submit);
        root.setVgap(10);
     
        
        primaryStage.setScene(scene);
        primaryStage.show();
        // Button Events and Menu events here
        String s[]= new String[1];
        Text t = new Text();
        menuItem11.setOnAction(e -> {
            System.out.println("Cut");
            s[0]=tf1.getText();
            tf1.setText("");
        });
        menuItem12.setOnAction(e -> {
            System.out.println("Cut");
            s[0]=tf2.getText();
            tf2.setText("");
        });
        menuItem21.setOnAction(e -> {
            System.out.println("Copy");
            s[0]=tf1.getText();
        });
       
        menuItem22.setOnAction(e -> {
            System.out.println("Copy");
            s[0]=tf2.getText();
        });
        menuItem31.setOnAction(e -> {
            System.out.println("Paste");
            tf1.setText(tf1.getText()+s[0]);
        });
        menuItem32.setOnAction(e -> {
            System.out.println("Paste");
            tf2.setText(tf2.getText()+s[0]);
        });
        filemenu1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if (t.getText().isEmpty() == false) {
                    root.getChildren().remove(t);
                }
            }
        });
        filemenu3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.exit(0);
            }
        });
        filemenu2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                tf1.setText("");
                tf2.setText("");
            }
        });
        filemenu4.setOnAction(new EventHandler<ActionEvent>(){
            int i=8;
            @Override
            public void handle(ActionEvent arg0) {
                Label ll=new Label();
                ll.setText("Username: "+tf1.getText()+'\n'+"Password: "+tf2.getText());
                root.addRow(i,ll);
                i=i+1;
            }
        });
        Submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (tf1.getText().isEmpty()) {
                    if (t.getText().isEmpty() == false) {
                        root.getChildren().remove(t);
                    }
                    t.setText("Form Error! Please enter your name");
                    root.addRow(5, t);
                    return;
                }
                if (tf2.getText().isEmpty()) {
                    if (t.getText().isEmpty() == false) {
                        root.getChildren().remove(t);
                    }
                    t.setText("Form Error! Please enter your password");
                    root.addRow(6, t);
                    return;
                }
                if (t.getText().isEmpty() == false) {
                    root.getChildren().remove(t);
                }
                t.setText("Registration Successful!" + " Welcome " + tf1.getText());
                root.addRow(7, t);
            }
        });
    } 
    public static void main(String[] args) {
        launch(args);
    }
}