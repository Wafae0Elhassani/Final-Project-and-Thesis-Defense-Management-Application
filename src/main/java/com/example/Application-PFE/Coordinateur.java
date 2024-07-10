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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;

import javax.print.PrintException;
import java.awt.*;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.ResourceBundle;

public class Coordinateur implements Initializable {


    @FXML
    private ImageView image;

    @FXML
    private ImageView image1;

    @FXML
    private Button acceuil1;

    @FXML
    private Button affecter1;


    @FXML
    private Button jurés;

    @FXML
    private AnchorPane pnmenu;

    @FXML
    private AnchorPane pn1;

    @FXML
    private Label soutenance;

    @FXML
    private AnchorPane affecternote;

    @FXML
    private AnchorPane acceuil;

    @FXML
    private TextField n11;

    @FXML
    private TextField n12;

    @FXML
    private TextField n2;

    @FXML
    private TextField n3;

    @FXML
    private TextField etd;

    @FXML
    private TableColumn<etd, String> etudiant;

    @FXML
    private TableView<etd> table;

    @FXML
    private  TableColumn<etd, String>note1;

    @FXML
    private TableColumn<etd, String> note2;

    @FXML
    private TableColumn<etd, String>note3;

    @FXML
    private TableColumn<etd, String> note4;

    @FXML
    private TableColumn<etd, String> note5;

    @FXML
    private TableColumn<etd, String> note6;

    public ObservableList<etd> data= FXCollections.observableArrayList();

    public ObservableList<etd> data1= FXCollections.observableArrayList();

    public ObservableList<jurés> data2= FXCollections.observableArrayList();


    public ObservableList<salle> data4= FXCollections.observableArrayList();


    @FXML
    private AnchorPane pnjurés;

    @FXML
    private AnchorPane pnsoutenance;

    @FXML
    private Button btnsoutenance;
    @FXML
    private TableView<jurés> tablejurés;

    @FXML
    private TableColumn<jurés, String > président;

    @FXML
    private TableColumn<jurés, String > rap1;

    @FXML
    private TableColumn<jurés, String > rap2;

    @FXML
    private TableView<etd> tableetd;

    @FXML
    private Button btnrésultat;


    public ObservableList<resultat> data3= FXCollections.observableArrayList();
    public ObservableList<soutenance> data5= FXCollections.observableArrayList();

    @FXML
    private AnchorPane pnacceuil;

    @FXML
    private TableView<resultat> tablerésultat;
    @FXML
    private TableColumn<resultat,String> moyenneresultat;
    @FXML
    private TableColumn<resultat, String> etudiantresultat;

    @FXML
    private AnchorPane pnrésultat;

    @FXML
    private AnchorPane pnprofile;


    @FXML
    private TableColumn<salle, Integer> salleplan;


    @FXML
    private TableView<salle> tablesalleplan;

    @FXML
    private TableView<etd> tableetdplan;

    @FXML
    private TableColumn<etd, String> etdplan;
    @FXML
    private TableColumn<etd, String> etdjurés;

    @FXML
    private TableView<etd> tableetdjurés;

    @FXML
    private Button ajouter;

    @FXML
    private AnchorPane pnajouter;
    @FXML
    private TextField dateemb;
    @FXML
    private TextField prof;

    @FXML
    private AnchorPane coordinateur;

    private Parent fxml;

    @FXML
    private TextField t1;

    @FXML
    private TextField t2;

    @FXML
    private TextField t3;

    @FXML
    private TextField t4;

    @FXML
    private TextField t5;

    @FXML
    private TextField t6;
    @FXML
    private TextField heuredebut;

    @FXML
    private TextField heurefin;
    @FXML
    private TextField min1;

    @FXML
    private TextField min2;
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

    public Coordinateur() {
    }

    @FXML
    void menu(MouseEvent event) {

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
    void menu1(MouseEvent event) {

        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(pnmenu);
        slide.setToX(0);
        slide.play();
        pnmenu.setTranslateX(233);
        image.setVisible(true);
        image1.setVisible(false);

    }

    @FXML
    void action(ActionEvent event) {

        if(event.getSource()==acceuil1){

            pnacceuil.setVisible(true);
            pnjurés.setVisible(false);
            affecternote.setVisible(false);
            pnsoutenance.setVisible(false);
            pnrésultat.setVisible(false);
            pnajouter.setVisible(false);
        }
        else if(event.getSource()==affecter1){
            pnjurés.setVisible(false);
            affecternote.setVisible(true);
            pnacceuil.setVisible(false);
            pnsoutenance.setVisible(false);
            pnrésultat.setVisible(false);
            pnajouter.setVisible(false);

        }
        else if(event.getSource()==jurés){
            affecternote.setVisible(false);
            pnacceuil.setVisible(false);
            pnjurés.setVisible(true);
            pnsoutenance.setVisible(false);
            pnrésultat.setVisible(false);
            pnajouter.setVisible(false);

        }

        else if(event.getSource()==btnsoutenance){
            affecternote.setVisible(false);
            pnacceuil.setVisible(false);
            pnjurés.setVisible(false);
            pnsoutenance.setVisible(true);
            pnrésultat.setVisible(false);
            pnajouter.setVisible(false);
        }
        else if(event.getSource()==btnrésultat){
            affecternote.setVisible(false);
            pnacceuil.setVisible(false);
            pnjurés.setVisible(false);
            pnsoutenance.setVisible(false);
            pnrésultat.setVisible(true);
            pnajouter.setVisible(false);
        }
        else if(event.getSource()==ajouter) {
            affecternote.setVisible(false);
            pnacceuil.setVisible(false);
            pnjurés.setVisible(false);
            pnsoutenance.setVisible(false);
            pnrésultat.setVisible(false);
            pnajouter.setVisible(true);
        }



    }

    @FXML
    void remplir(ActionEvent event) {

        double a = Double.parseDouble(n11.getText());
        double d = Double.parseDouble(n12.getText());
        double b = Double.parseDouble(n2.getText());
        double c = Double.parseDouble(n3.getText());
        double co = a*0.6+d*0.4;
        double m = co*0.5+b*0.2+c*0.3;

        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;

        float nd1 = Float.parseFloat(n11.getText());
        float nd2 = Float.parseFloat(n12.getText());
        float nd3 = Float.parseFloat(n2.getText());
        float nd4 = Float.parseFloat(n3.getText());
        if(nd1>0 && nd1<20 && nd2>0 && nd2<20 && nd3>0 && nd3<20 && nd4>0 && nd4<20){


            try {
                stat = con.prepareStatement("INSERT INTO projet_java.notes(nom,note_de_contenu,note_du_mémoire,note_de_la_soutenance,Moyenne,note_e_i,note_e_ex)VALUES(?,?,?,?,?,?,?)");
                stat.setString(1, etd.getText());
                stat.setString(2, String.valueOf(co));
                stat.setString(3, n2.getText());
                stat.setString(4, n3.getText());
                stat.setString(5, String.valueOf(m));
                stat.setString(6, n11.getText());
                stat.setString(7, n12.getText());
                stat.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information");
            alert.setHeaderText(null);
            alert.setContentText("la note est invalide");
            alert.showAndWait();
        }

        remplir_table();
        clear();

    }

    @FXML
    void remplir_table() {

        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = con.prepareStatement("INSERT INTO projet_java.etudiants_1(nom)VALUES(?)");
            stat.setString(1, etd.getText());
            stat.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void remplir_prof(ActionEvent event) {

        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;


        try {

            stat = con.prepareStatement("INSERT INTO  projet_java.jurés(Professeur,Date_emb)VALUES(?,?)");
            stat.setString(1, prof.getText());
            stat.setString(2, dateemb.getText());
            stat.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

       prof.setText("");
        dateemb.setText("");

    }



    @FXML
    void déconnexion(ActionEvent event) {


        coordinateur.getScene().getWindow().hide();
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

    @FXML
    void actualiser(ActionEvent event) {

        for ( int i = 0; i<table.getItems().size(); i++) {
            table.getItems().clear();
        }

        Remplirtable();

    }

    public void Remplirtable(){

        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;


        try {
            stat = con.prepareStatement("SELECT nom,note_e_i,note_e_ex,note_du_mémoire,note_de_la_soutenance FROM projet_java.notes;");
            rs = stat.executeQuery();
            while (rs.next()){

                data.add(new etd(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        etudiant.setCellValueFactory(new PropertyValueFactory<>("nom"));
        note5.setCellValueFactory(new PropertyValueFactory<>("note5"));
        note6.setCellValueFactory(new PropertyValueFactory<>("note6"));
        note2.setCellValueFactory(new PropertyValueFactory<>("note2"));
        note3.setCellValueFactory(new PropertyValueFactory<>("note3"));

        table.setItems(data);

    }

    public void clear(){
        etd.setText("");
        n11.setText("");
        n12.setText("");
        n2.setText("");
        n3.setText("");
    }

    @FXML
    void modifier(ActionEvent event) {


        String name= String.valueOf(table.getSelectionModel().getSelectedItem().getNom());
        String note_2= String.valueOf(table.getSelectionModel().getSelectedItem().getNote2());
        String note_3= String.valueOf(table.getSelectionModel().getSelectedItem().getNote3());
        String note_5= String.valueOf(table.getSelectionModel().getSelectedItem().getNote5());
        String note_6= String.valueOf(table.getSelectionModel().getSelectedItem().getNote6());

        etd.setText(name);
        n2.setText(note_2);
        n3.setText(note_3);
        n11.setText(note_5);
        n12.setText(note_6);
        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());

        supprimer();

    }

    public void supprimer(){

        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = con.prepareStatement("DELETE FROM projet_java.notes where nom = ?");
            stat.setString(1, etd.getText());
            stat.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//jurés Etudiants

    @FXML
    void affecter_nomEtd() {
        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = con.prepareStatement("SELECT nom FROM projet_java.notes;");
            rs = stat.executeQuery();
            while (rs.next())
            {

                data1.add(new etd(rs.getString(1)));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        etdjurés.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tableetdjurés.setItems(data1);

    }

    public void affecter_jurés() {
        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            //stat = con.prepareStatement("SELECT e1.Professeur,e2.Professeur,e3.Professeur FROM projet_java.jurés e1, projet_java.jurés e2,projet_java.jurés e3 join (select DISTINCT nom from projet_java.notes group by nom) as etd  where e1.Professeur!=e2.Professeur and e2.Professeur!=e3.Professeur and e1.Professeur!=e3.Professeur  order by rand() limit "+tableetdjurés.getItems().size());
            stat = con.prepareStatement("select nom,président,rapporteur1,rapporteur2 from (select * from etudiants_1 e inner join etudiants_jurés_1  j on e.id_1=j.id  ) as tableview;");
            rs = stat.executeQuery();
            while (rs.next() ) {
                data2.add(new jurés(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        }

        etdjurés.setCellValueFactory(new PropertyValueFactory<>("nom"));
        président.setCellValueFactory(new PropertyValueFactory<>("pres"));
        rap1.setCellValueFactory(new PropertyValueFactory<>("rap1"));
        rap2.setCellValueFactory(new PropertyValueFactory<>("rap2"));
        tablejurés.setItems(data2);

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
    void affecter_sout(ActionEvent event) {

        affecter_soutenance_test();
        affecter_soutenance();

    }

    public void affecter_juréstest() {
        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;


        try {
            stat = con.prepareStatement("INSERT INTO projet_java.etudiants_jurés_1(Président,rapporteur1,rapporteur2) SELECT e1.Professeur,e2.Professeur,e3.Professeur FROM projet_java.jurés e1, projet_java.jurés e2,projet_java.jurés e3 join (select DISTINCT nom from projet_java.notes group by nom) as etd  where e1.Professeur!=e2.Professeur and e2.Professeur!=e3.Professeur and e1.Professeur!=e3.Professeur  order by rand()");
            stat.executeUpdate();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    public void affecter_soutenance_test() {
        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;


        try {
            stat = con.prepareStatement("INSERT INTO soutenance1(salle,heure,minute_1,jour,mois,année)(SELECT s1.num_salle,h1.heure,h1.minute_1,j1.jour,j1.moins,j1.année FROM salle s1,salle s2,heure h1,heure h2,date_1 j1,date_1 j2 join (select nom from notes) as d where(s1.num_salle!=s2.num_salle or h1.heure!=h2.heure && h1.minute_1 !=h2.minute_1 or j1.jour!=j2.jour )order by rand());");
            stat.executeUpdate();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }

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

                data3.add(new resultat(rs.getString(1),rs.getString(2)));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        etudiantresultat.setCellValueFactory(new PropertyValueFactory<>("nom"));
        moyenneresultat.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
        tablerésultat.setItems(data3);
    }

    @FXML
    void moy(ActionEvent event) {

        for ( int i = 0; i<tablerésultat.getItems().size(); i++) {
            tablerésultat.getItems().clear();
        }
        resultat();
    }

    @FXML
    void affecter(ActionEvent event) {


        affecter_juréstest();
        affecter_jurés();

    }



    void affecter_etdplan() {
        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = con.prepareStatement("SELECT nom FROM projet_java.notes;");
            rs = stat.executeQuery();
            while (rs.next())
            {

                data.add(new etd(rs.getString(1)));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        etdplan.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tableetdplan.setItems(data);

    }

    void affecter_salleplan() {
        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = con.prepareStatement("SELECT num_salle FROM projet_java.salle order by rand();");
            rs = stat.executeQuery();
            while (rs.next())
            {

                data4.add(new salle(rs.getString(1)));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        salleplan.setCellValueFactory(new PropertyValueFactory<>("salleplan"));
        tablesalleplan.setItems(data4);

    }
@FXML
    void affecter_salle(ActionEvent event){

        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;

    int c = Integer.parseInt(t2.getText());
    int d = Integer.parseInt(t5.getText());
    int ex = Integer.parseInt(t3.getText());
    int f = Integer.parseInt(t6.getText());
    int a = Integer.parseInt(t4.getText());
    int b = Integer.parseInt(t1.getText());



            while (b!=(a+1)) {


                try {
                    stat = con.prepareStatement("INSERT INTO projet_java.date_1(jour,moins,année)values(?,?,?);");
                    stat.setString(1, String.valueOf(b));
                    stat.setString(2,t2.getText());
                    stat.setString(3,t3.getText());
                    stat.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                b++;


            }

    t1.setText("");
    t2.setText("");
    t3.setText("");
    t4.setText("");
    t5.setText("");
    t6.setText("");
    affecter_heure();

    }

    @FXML
    void affecter_heure(){

        Connection con = Connection_MySQL.getConnection();
        PreparedStatement stat = null;

        int a = Integer.parseInt(heuredebut.getText());
        int b = Integer.parseInt(heurefin.getText());

        int c = Integer.parseInt(min1.getText());
        int d = Integer.parseInt(min2.getText());


            while (a!=b) {

                if (c < 60) {


                    try {
                        stat = con.prepareStatement("INSERT INTO projet_java.heure(heure,minute_1)values(?,?);");
                        stat.setString(1, String.valueOf(a));
                        stat.setString(2, String.valueOf(c));
                        stat.executeUpdate();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    c +=30;


                }
                else{
                    a++;
                    c= 60-c;

                    try {
                        stat = con.prepareStatement("INSERT INTO projet_java.heure(heure,minute_1)values(?,?);");
                        stat.setString(1, String.valueOf(a));
                        stat.setString(2, String.valueOf(c));
                        stat.executeUpdate();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    c+=30;

                }
            }
        heuredebut.setText("");
        heurefin.setText("");
        min1.setText("");
        min2.setText("");


    }

    @FXML
    void print(ActionEvent event) {

        PrinterJob printerJob = PrinterJob.createPrinterJob();
        Stage primaryStage = null;
        if (printerJob.showPrintDialog(primaryStage) && printerJob.printPage(tablejurés))
        {
            printerJob.endJob();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Remplirtable();
        resultat();
        //affecter_etdplan();
        //affecter_salleplan();
    }

}

