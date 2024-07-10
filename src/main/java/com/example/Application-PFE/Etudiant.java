package com.example.chatapplication;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.chatapplication.Connection_MySQL.getConnection;

public class Etudiant implements Initializable
{

    @FXML
    private Button affecter;

    @FXML
    private Button btnacceuil;

    @FXML
    private Button btnpfe;

    @FXML
    private Button btnplan;


    @FXML
    private Button btnresultat;


    @FXML
    private ImageView image;

    @FXML
    private ImageView image1;

    @FXML
    private AnchorPane pnacceuil;

    @FXML
    private AnchorPane pnmenu;

    @FXML
    private AnchorPane pnpfe;

    @FXML
    private AnchorPane pnplannification;

    @FXML
    private AnchorPane pnrésultat;

    public ObservableList<resultat> data= FXCollections.observableArrayList();


    @FXML
    private Label label1;

    @FXML
    private Label label2;
    @FXML
    private TableView<resultat> tablerésultat;
    @FXML
    private TableColumn<resultat,String> moyenneresultat;
    @FXML
    private TableColumn<resultat, String> etudiantresultat;

    FileChooser f = new FileChooser();

    @FXML
    private TableColumn<soutenance,String > heure;

    @FXML
    private TableColumn<soutenance,String> jour;
    @FXML
    private TableColumn<soutenance,String> minute;

    @FXML
    private TableColumn<soutenance,String> mois;
    @FXML
    private TableColumn<soutenance,String> année;

    @FXML
    private TableView<soutenance> tablesoutenance;


    @FXML
    private TableColumn<soutenance, String> etdsoutenance;

    @FXML
    private TableColumn<soutenance, String> salle;

    public ObservableList<soutenance> data5= FXCollections.observableArrayList();

    @FXML
    private AnchorPane Etudiant;

    private Parent fxml;


    @FXML
    void action(ActionEvent event)
    {

        if(event.getSource()==btnacceuil){

            pnacceuil.setVisible(true);
            pnrésultat.setVisible(false);
            pnpfe.setVisible(false);
            pnplannification.setVisible(false);

        }
        else if(event.getSource()==btnpfe){
            pnacceuil.setVisible(false);
            pnrésultat.setVisible(false);
            pnpfe.setVisible(true);
            pnplannification.setVisible(false);


        }
        else if(event.getSource()==btnplan){
            pnacceuil.setVisible(false);
            pnrésultat.setVisible(false);
            pnpfe.setVisible(false);
            pnplannification.setVisible(true);

        }

        else if(event.getSource()==btnresultat){
            pnacceuil.setVisible(false);
            pnrésultat.setVisible(true);
            pnpfe.setVisible(false);
            pnplannification.setVisible(false);
        }


    }

    @FXML
    void menu(MouseEvent event)
    {

        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(pnmenu);
        slide.setToX(-800);
        slide.play();
        pnmenu.setTranslateX(-233);
        image.setVisible(false);
        image1.setVisible(true);

    }

    @FXML
    void menu1(MouseEvent event)
    {

        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(pnmenu);
        slide.setToX(0);
        slide.play();
        pnmenu.setTranslateX(233);
        image.setVisible(true);
        image1.setVisible(false);

    }

    public void get(MouseEvent mouseEvent) {

        f.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF file","*pdf"));

        File file = f.showOpenDialog(new Stage());

        label1.setText(file.getName());

    }

    public void get1(MouseEvent mouseEvent) {

        f.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF file", "*pdf"));

        File file = f.showOpenDialog(new Stage());

        label2.setText(file.getName());

    }
    public void resultat()
    {
        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = con.prepareStatement("SELECT nom,Moyenne FROM projet_java.notes;");
            rs = stat.executeQuery();
            while (rs.next())
            {

                data.add(new resultat(rs.getString(1),rs.getString(2)));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        etudiantresultat.setCellValueFactory(new PropertyValueFactory<>("nom"));
        moyenneresultat.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
        tablerésultat.setItems(data);
    }


    public void affecter_soutenance() {
        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = con.prepareStatement("select nom,jour,mois,année,salle,heure,minute_1 from (select * from etudiants_1 e inner join soutenance1 s on e.id_1=s.id  ) as tableview1;");
            rs = stat.executeQuery();
            while (rs.next() ) {


                data5.add(new soutenance(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        }

        etdsoutenance.setCellValueFactory(new PropertyValueFactory<>("nom"));
        jour.setCellValueFactory(new PropertyValueFactory<>("jour"));
        mois.setCellValueFactory(new PropertyValueFactory<>("mois"));
        année.setCellValueFactory(new PropertyValueFactory<>("année"));
        salle.setCellValueFactory(new PropertyValueFactory<>("salle"));
        heure.setCellValueFactory(new PropertyValueFactory<>("heure"));
        minute.setCellValueFactory(new PropertyValueFactory<>("minute"));
        tablesoutenance.setItems(data5);

    }


    @FXML
    void déconnexion(ActionEvent event) {


        Etudiant.getScene().getWindow().hide();
        Stage home = new Stage();


        try{

            fxml = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Login.fxml"))));
            //home.getIcons().add(new Image("profile-icon-login-head-icon-vector.jpg"));
            Scene scene = new Scene(fxml);
            home.setScene(scene);
            home.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        resultat();

        affecter_soutenance();

    }
}

