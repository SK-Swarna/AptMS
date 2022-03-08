/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aptms;

import aptms.utils.Bundle;
import aptms.utils.DBConnect;
import aptms.utils.TableLoader;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author shabbir
 */
public class FlatDetailsController implements Initializable {

    @FXML
    private Label flatID_label;

    @FXML
    private Label vacancyStatus_label;
    @FXML
    private Label rent_label;
    @FXML
    private TextField editProperties_tf;
    @FXML
    private Button update_btn;
    @FXML
    private Label gas_label;
    @FXML
    private Label electricity_label;
    @FXML
    private Label lift_label;
    @FXML
    private Label generator_label;
    @FXML
    private Label sft_label;
    @FXML
    private Label bed_label;
    @FXML
    private Label bath_label;
    @FXML
    private Label level_label;
    @FXML
    private Label address_label;
    @FXML
    private MenuButton edit_menubtn;
    String qry;
    boolean num = false;
    @FXML
    private AnchorPane vacancy_anchor;
    @FXML
    private Button giveItOnRent_btn;
    @FXML
    private TableView<?> vacancyPpl_tv;
    TableLoader tableLoader = new TableLoader();
    boolean closeRent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        Object s = flats_tv.getSelectionModel().getSelectedItems().get(0);
//
//        System.out.println(s.toString().split(", ")[1].substring(1));
//
//        String flatID = s.toString().split(", ")[0].substring(1); //got the 1st column of selected row -> first col = course id
//        System.out.println("flat id : " + flatID);

//        try {
//            DBConnect dbcon = new DBConnect();
//            dbcon.connectToDB();
//
//            ResultSet flats = dbcon.queryToDB("select * from Flats where FlatID = " + Bundle.UID),
//                    fullAddress = dbcon.queryToDB("select * from FullAddress where FlatID = " + Bundle.UID),
//                    flatServices = dbcon.queryToDB("select * from FlatServices where FlatID = " + Bundle.UID),
//                    flatDetails = dbcon.queryToDB("select * from FlatDetails where FlatID = " + Bundle.UID);
//            flats.next();
//            fullAddress.next();
//            flatServices.next();
//            flatDetails.next();
//            System.out.println(flats.getString("vacancy_st") + " ::: " + String.valueOf(flatDetails.getDouble("Area")));
//
//            vacancyStatus_label.setText(flats.getString("vacancy_st"));
//            rent_label.setText(String.valueOf(flats.getDouble("MonthlyRent")));
//
//            bath_label.setText(String.valueOf(flatDetails.getInt("Bath")));
//            sft_label.setText(String.valueOf(flatDetails.getDouble("Area")));
//            bed_label.setText(String.valueOf(flatDetails.getInt("Bed")));
//            level_label.setText(":(");
//            gas_label.setText(flatServices.getString("Gas"));
//            electricity_label.setText(flatServices.getString("Electricity"));
//            lift_label.setText(flatServices.getString("lift"));
//            generator_label.setText(flatServices.getString("Generator"));
//            address_label.setText("wait");
//            closeRent = false;
//            System.out.println("init :::::::: faltDetails");
//            System.out.println(flats.getString("vacancy_st").equalsIgnoreCase("vacant"));
//            if (flats.getString("vacancy_st").equalsIgnoreCase("vacant")) {
//                //if vacant -> select * from regpeople
//                String q = "select * from RegPeople";
//                tableLoader.loadTable(q, vacancyPpl_tv);
//
//                giveItOnRent_btn.setText("Give it on Rent");
//            } else if (flats.getString("vacancy_st").equalsIgnoreCase("occupied")) {
//                //if occupied -> who is the resident?
//                giveItOnRent_btn.setText("Close Rental Agreement");
//                String q = "select * from RegPeople where ResID in (select ResID from CurrentRentals where FlatID = " + flats.getString("FlatID") + ")";
//                System.out.println(q);
//
//                tableLoader.loadTable(q, vacancyPpl_tv);
//
//                closeRent = true;
//            }
//
//        } catch (Exception e) {
//            System.out.println("uh oh: " + e);
//        }
//
//        flatID_label.setText(Bundle.UID);
//        System.out.println(Bundle.UID);
        init();

    }

    private void init() {
        try {
            DBConnect dbcon = new DBConnect();
            dbcon.connectToDB();

            ResultSet flats = dbcon.queryToDB("select * from Flats where FlatID = " + Bundle.UID),
                    fullAddress = dbcon.queryToDB("select * from FullAddress where FlatID = " + Bundle.UID),
                    flatServices = dbcon.queryToDB("select * from FlatServices where FlatID = " + Bundle.UID),
                    flatDetails = dbcon.queryToDB("select * from FlatDetails where FlatID = " + Bundle.UID);
            flats.next();
            fullAddress.next();
            flatServices.next();
            flatDetails.next();
            System.out.println(flats.getString("vacancy_st") + " ::: " + String.valueOf(flatDetails.getDouble("Area")));

            vacancyStatus_label.setText(flats.getString("vacancy_st"));
            rent_label.setText(String.valueOf(flats.getDouble("MonthlyRent")));

            bath_label.setText(String.valueOf(flatDetails.getInt("Bath")));
            sft_label.setText(String.valueOf(flatDetails.getDouble("Area")));
            bed_label.setText(String.valueOf(flatDetails.getInt("Bed")));
            level_label.setText(":(");
            gas_label.setText(flatServices.getString("Gas"));
            electricity_label.setText(flatServices.getString("Electricity"));
            lift_label.setText(flatServices.getString("lift"));
            generator_label.setText(flatServices.getString("Generator"));
            address_label.setText("Flat No # " + fullAddress.getString("FlatNo") + ", HouseNo#" + fullAddress.getString("HouseNo") + ", Road: " + fullAddress.getString("Road") + ", Block: " + fullAddress.getString("Block") + ", " + fullAddress.getString("Thana") + ", " + fullAddress.getString("Zilla") + ", " + fullAddress.getString("Division"));
            closeRent = false;
            System.out.println("init :::::::: faltDetails");
            System.out.println(flats.getString("vacancy_st").equalsIgnoreCase("vacant"));
            if (flats.getString("vacancy_st").equalsIgnoreCase("vacant")) {
                //if vacant -> select * from regpeople
                String q = "select * from RegPeople";
                tableLoader.loadTable(q, vacancyPpl_tv);

                giveItOnRent_btn.setText("Give it on Rent");
            } else if (flats.getString("vacancy_st").equalsIgnoreCase("occupied")) {
                //if occupied -> who is the resident?
                giveItOnRent_btn.setText("Close Rental Agreement");
                String q = "select * from RegPeople where ResID in (select ResID from CurrentRentals where FlatID = " + flats.getString("FlatID") + ")";
                System.out.println(q);

                tableLoader.loadTable(q, vacancyPpl_tv);

                closeRent = true;
            }

        } catch (Exception e) {
            System.out.println("uh oh: " + e);
        }

        flatID_label.setText(Bundle.UID);
        System.out.println(Bundle.UID);

    }

    @FXML
    private void onClickUpdate_btn(ActionEvent event) {
        if (num) {
            qry += editProperties_tf.getText() + "";
        } else {
            qry += editProperties_tf.getText() + "'";
        }

        qry += " where FlatID = " + Bundle.UID;

        System.out.println("bug::::::::::::::::::" + qry);
        try {
            DBConnect dbcon = new DBConnect();
            dbcon.connectToDB();
            dbcon.insertDataToDB(qry);

            if (num) {
                rent_label.setText(editProperties_tf.getText());
            } else {
                vacancyStatus_label.setText(editProperties_tf.getText());
            }
        } catch (Exception e) {
            System.out.println(":(");
        }
    }

    @FXML
    private void onClickMonthyRent_mi(ActionEvent event) {
        edit_menubtn.setText("Monthly Rent ");
        qry = "update Flats Set MonthlyRent=";
        num = true;
    }

    @FXML
    private void onClickVacancySt_mi(ActionEvent event) {
        edit_menubtn.setText("Vacancy Status ");
        qry = "update Flats Set vacancy_st = '";
        num = false;
    }

    @FXML
    private void onClickOpenCloseRent_btn(ActionEvent event) {
        if (closeRent) {
            //close rent

            try {
                DBConnect dbcon = new DBConnect();
                dbcon.connectToDB();

                dbcon.insertDataToDB("delete from CurrentRentals where FlatID = " + Bundle.UID);
                dbcon.insertDataToDB("update Flats set vacancy_st = 'vacant' where FlatID = " + Bundle.UID);
            } catch (Exception e) {
                System.out.println(e);
            }

            //update flat data
        } else {
            //insert into agreement

            Object s = vacancyPpl_tv.getSelectionModel().getSelectedItems().get(0);

            System.out.println(s.toString().split(", ")[1].substring(1));

            String resID = s.toString().split(", ")[0].substring(1); //got the 1st column of selected row -> first col = course id

            String newAgr = "insert into CurrentRentals values(" + resID + ", " + Bundle.UID + ")";
            System.out.println(newAgr);
            try {
                DBConnect dbcon = new DBConnect();
                dbcon.connectToDB();

                dbcon.insertDataToDB(newAgr);
                dbcon.insertDataToDB("update Flats set vacancy_st = 'occupied' where FlatID = " + Bundle.UID);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        init();
    }

}
