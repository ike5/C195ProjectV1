package main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Customer;
import utils.DBCustomers;
import utils.JDBC;
import model.DatabaseState;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ResourceBundle rb = ResourceBundle.getBundle("RBundle", Locale.getDefault());
        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml")); // slash represents the src folder
        stage.setTitle(rb.getString("set_title"));
        stage.setScene(new Scene(root, 400, 300)); // (width, height)
        stage.show();

        //FIXME
        // - Set appropriate width and height for LoginScreen.fxml
    }

    public static void main(String[] args) {
        DatabaseState.useLocalDatabase(true); // Use remote database by setting flag to false
//        Locale.setDefault(new Locale("fr", "CA")); // Test to set default to French


//        Customer customer = new Customer(1, "Daddy Warthog", "1234 Avenue Street", "94114", "415-672-8597", 33);
//        Customer customer1 = DBCustomers.editCustomer(customer);
//        System.out.println(customer1);


        JDBC.openConnection();
        launch(args);
        JDBC.closeConnection();
    }


}



