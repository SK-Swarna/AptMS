/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aptms;

import aptms.utils.DBConnect;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shabbir
 */
public class AddNewFlatController implements Initializable {

    @FXML
    private MenuButton vacancy_menubtn;
    @FXML
    private TextField rent_tf;
    @FXML
    private MenuButton gas_menubtn;
    @FXML
    private MenuItem gasYes_mi;
    @FXML
    private MenuItem gasNo_mi;
    @FXML
    private MenuButton electricity_menubtn;
    @FXML
    private MenuItem elecYes_mi;
    @FXML
    private MenuItem elecNo_mi;
    @FXML
    private MenuButton lift_menubtn;
    @FXML
    private MenuItem liftYes_mi;
    @FXML
    private MenuItem liftNo_mi;
    @FXML
    private MenuButton generator_menubtn;
    @FXML
    private MenuItem genYes_mi;
    @FXML
    private MenuItem genNo_mi;
    @FXML
    private TextField area_tf;
    @FXML
    private TextField bed_tf;
    @FXML
    private TextField bath_tf;
    @FXML
    private TextField level_tf;
    @FXML
    private TextField flatNo_tf;
    @FXML
    private TextField houseNo_tf;
    @FXML
    private TextField road_tf;
    @FXML
    private TextField block_tf;
    @FXML
    private TextField thana_tf;
    @FXML
    private TextField zilla_tf;
    @FXML
    private TextField division_tf;
    @FXML
    private Button save_btn;
    @FXML
    private MenuItem vacancy_vacant_mi;
    @FXML
    private MenuItem vacancy_occ_mi;
    String vacancySt,
            gas,
            elec,
            gen,
            lift;
    @FXML
    private TextField balcony_tf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void onClickVacancy_vacant_mi(ActionEvent event) {
        this.vacancySt = "vacant";
        vacancy_menubtn.setText("Vacant");
    }

    @FXML
    private void onClickVacancy_occ_mi(ActionEvent event) {
        this.vacancySt = "occupied";
        vacancy_menubtn.setText("Occupied");
    }

    @FXML
    private void onClickGasYes_mi(ActionEvent event) {
        this.gas = "yes";
        gas_menubtn.setText("Yes");
    }

    @FXML
    private void onClickGasNo_mi(ActionEvent event) {
        this.gas = "no";
        gas_menubtn.setText("No");
    }

    @FXML
    private void onClickElecYes_mi(ActionEvent event) {
        this.elec = "yes";
        electricity_menubtn.setText("Yes");
    }

    @FXML
    private void onClickElecNo_mi(ActionEvent event) {
        this.elec = "no";
        electricity_menubtn.setText("No");
    }

    @FXML
    private void onClickLiftYes_mi(ActionEvent event) {
        this.lift = "yes";
        lift_menubtn.setText("Yes");
    }

    @FXML
    private void onClickLiftNo_mi(ActionEvent event) {
        this.lift = "no";
        lift_menubtn.setText("No");
    }

    @FXML
    private void onClickGenYes_mi(ActionEvent event) {
        this.gen = "yes";
        generator_menubtn.setText("Yes");
    }

    @FXML
    private void onClickGenNo_mi(ActionEvent event) {
        this.gen = "no";
        lift_menubtn.setText("No");
    }

    @FXML
    private void onClickSave_btn(ActionEvent event) {
        System.out.println("save button pressed");
        boolean t1 = false,
                t2 = false,
                t3 = false,
                t4 = false;
        try {
            
            DBConnect dbcon = new DBConnect();
            dbcon.connectToDB();
            
            String query_Flats = "insert into Flats (vacancy_st, MonthlyRent)";
            query_Flats += " values('" + this.vacancySt + "', " + rent_tf.getText() + ")";
            
            System.out.println("add new flat ::" + query_Flats);
            t1 = dbcon.insertDataToDB(query_Flats);
            
            //get FlatID
            ResultSet lastID = (dbcon.queryToDB("select @@identity"));
            lastID.next();
            String FlatID = lastID.getString(1);
            
            System.out.println("flatid new inserted: " + FlatID);
            
            String query_FullAddress = "insert into FullAddress (FlatID, FlatNo, HouseNo, Road, Block, Thana, Zilla, Division) ";
            query_FullAddress += "values (" + FlatID + ", '" + flatNo_tf.getText() + "', '" + houseNo_tf.getText() + "', '";
            query_FullAddress += road_tf.getText() + "', '" + block_tf.getText() + "', '" + thana_tf.getText() + "', '";
            query_FullAddress += zilla_tf.getText() + "', '" + division_tf.getText() + "')";
            
            System.out.println("query full address: " + query_FullAddress);
            
            t2 = dbcon.insertDataToDB(query_FullAddress);
            
            
            String query_flatServices = "insert into FlatServices(FlatID, Gas, Electricity, lift, Generator) ";
            query_flatServices += "values (" + FlatID + ", '"  + this.gas + "', '" + this.elec + "', '" + this.lift + "', '" + this.gen + "')";
            
            System.out.println("query flatServices:: " + query_flatServices);
            
            t3 = dbcon.insertDataToDB(query_flatServices);
            
            String query_flatDetails = "insert into FlatDetails (FlatID, Bed, Area, Bath, Balcony) ";
            query_flatDetails += "values (" + FlatID + ", " + bed_tf.getText() + ", " + area_tf.getText() + ", " + bath_tf.getText() + ", " + balcony_tf.getText() + ")";
            System.out.println("flat details qry: :" + query_flatDetails);
            
            t4 = dbcon.insertDataToDB(query_flatDetails);
            
            if(t1 && t2 && t3 && t4) {
                //if all query success
               //((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
                
            }
            
            
            
        } catch (Exception e) {
            System.out.println("couldn't add new flat : " + e);
        }
    }

}
