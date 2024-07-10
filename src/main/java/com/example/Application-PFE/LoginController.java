package com.example.chatapplication;

import com.example.chatapplication.Connection_MySQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Label label1;

    @FXML
    private Label label11;

    @FXML
    private PasswordField p1;

    @FXML
    private PasswordField p2;

    @FXML
    private AnchorPane pn1;

    @FXML
    private AnchorPane pn2;

    @FXML
    private AnchorPane pn21;

    @FXML
    private AnchorPane pnmot;

    @FXML
    private AnchorPane pnsign;

    @FXML
    private StackPane stack;

    @FXML
    private TextField t0;

    @FXML
    private TextField t01;

    @FXML
    private TextField t1;


    @FXML
    private PasswordField t2;

    @FXML
    private Label label3;

    private Parent fxml;


    @FXML
    void label2(MouseEvent event) {

        pnsign.setVisible(false);
        pnmot.setVisible(true);

    }

    @FXML
    void valider(ActionEvent event) {

        PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = Connection_MySQL.getConnection();
        try {

            if (p1.getText().equals(p2.getText()) && !p1.getText().isEmpty() && (!p2.getText().isEmpty()) && (!t0.getText().isEmpty()) && (!t01.getText().isEmpty())) {

                if (tester()) {

                    st = con.prepareStatement("UPDATE  login SET password = ? WHERE username=?");
                    st.setString(1, p1.getText());
                    st.setString(2, t0.getText());
                    st.executeUpdate();

                    pnmot.setVisible(false);
                    pnsign.setVisible(true);
                }

            } else {
                if (!p1.getText().equals(p2.getText()))
                    label3.setText("Entrer le même mot de passe ");
                if (p1.getText().isEmpty())
                    label3.setText("Entrer le mot passe ");
                if (p2.getText().isEmpty())
                    label3.setText("Confirmer le mot passe ");
                if (t0.getText().isEmpty())
                    label3.setText("Entrer le CNE");
                if (t01.getText().isEmpty())
                    label3.setText("Entrer le CIN");
            }
        } catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    private boolean tester() {

        PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = Connection_MySQL.getConnection();

        try {
            st = con.prepareStatement("SELECT * FROM login WHERE username =? AND password =?");
            st.setString(1, t0.getText());
            st.setString(2, t01.getText());
            rs = st.executeQuery();
            if (rs.next()) {

                return true;

            } else {

                label3.setText("le CNE ou CIN est incorrect");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    @FXML
    void connecte(ActionEvent event) {


        PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = Connection_MySQL.getConnection();
        try {
            st = con.prepareStatement("SELECT * FROM login WHERE username =? AND password =?");
            st.setString(1,t1.getText());
            st.setString(2,t2.getText());
            rs = st.executeQuery();
            if (rs.next()){

                label1.setText("");

                stack.getScene().getWindow().hide();

                if(t1.getText().equals("admin") && t2.getText().equals("admin")){


                    Stage home = new Stage();



                    try{

                        fxml = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Coordinateur.fxml"))));
                        //home.getIcons().add(new Image("profile-icon-login-head-icon-vector.jpg"));
                        Scene scene = new Scene(fxml);
                        home.setScene(scene);
                        home.show();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                else{
                    Stage home1 = new Stage();

                    fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Etudiant.fxml")));
                    //home1.getIcons().add(new Image("C:\\Users\\wafae\\IdeaProjects\\Project1\\target\\classes\\com\\example\\project1\\profile-icon-login-head-icon-vector.jpg"));
                    Scene scene = new Scene(fxml);
                    home1.setScene(scene);
                    home1.show();
                }

            }
            else{

                label1.setText("Nom d'utilisateur ou Mot de passe est invalide");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}























//package com.example.chatapplication;
//import java.io.File;
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//
//
//public class LoginController{
//
//    public AnchorPane pnPlan;
//    FileChooser f = new FileChooser();
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private Label lab1;
//
//    @FXML
//    private Label lab2;
//
//
//    @FXML
//    private Button btnAcceuil;
//
//    @FXML
//    private Button btnPFE;
//
//    @FXML
//    private Button btnPlanification;
//
//    @FXML
//    private Button btnProfile;
//
//    @FXML
//    private Button btnResultat;
//
//    @FXML
//    private ImageView image1;
//
//    @FXML
//    private ImageView image3;
//
//    @FXML
//    private ImageView image4;
//
//    @FXML
//    private ImageView image5;
//
//    @FXML
//    private Label l1;
//
//    @FXML
//    private Label l2;
//
//    @FXML
//    private TextField t1;
//
//    @FXML
//    private AnchorPane pnAcceuil;
//
//    @FXML
//    private AnchorPane pnPFE;
//
//
//
//    @FXML
//    void action(ActionEvent event) {
//
//        if(event.getSource()==btnAcceuil){
//
//            pnAcceuil.setVisible(true);
//            pnPFE.setVisible(false);
//            pnPlan.setVisible(false);
//        }
//        else if(event.getSource()==btnPFE){
//            pnPFE.setVisible(true);
//            pnAcceuil.setVisible(false);
//            pnPlan.setVisible(false);
//        }
//        else if(event.getSource()==btnPlanification){
//
//            pnPFE.setVisible(false);
//            pnAcceuil.setVisible(false);
//            pnPlan.setVisible(true);
//        }
//        else if(event.getSource()==btnProfile){
//
//            pnPlan.setVisible(false);
//
//            pnPFE.setVisible(false);
//            pnAcceuil.setVisible(false);
//
//        }
//        else if(event.getSource()==btnResultat){
//
//            pnPlan.setVisible(false);
//            pnPFE.setVisible(false);
//            pnAcceuil.setVisible(false);
//
//        }
//    }
//
//
//
//
//    @FXML
//    void initialize() {
//
//        f.setInitialDirectory(new File("C:\\Users\\wafae\\OneDrive\\Bureau"));
//
//    }
//
//
//    public void get(MouseEvent mouseEvent) {
//
//        f.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF file","*pdf"));
//
//        File file = f.showOpenDialog(new Stage());
//
//        lab1.setText(file.getName());
//
//    }
//
//    public void get1(MouseEvent mouseEvent) {
//
//        f.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF file", "*pdf"));
//
//        File file = f.showOpenDialog(new Stage());
//
//        lab2.setText(file.getName());
//
//
//
//    }
//
//}
