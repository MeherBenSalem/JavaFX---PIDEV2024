package com.example.projectpi;

import com.example.projectpi.Connectors.MySQLConnector;
import com.example.projectpi.Services.UserService;
import com.example.projectpi.entites.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException, ClassNotFoundException {
        MySQLConnector.getInstance().getConnection();
        Date currentDate = new Date(2024-1900,5,10);
        // Create a new User instance with the current date
        User user = new User(1, "john_doe", "john@example.com", "password123", currentDate);
        System.out.println(user);
        UserService service = new UserService();
        service.Create(user);
    }

    public static void main(String[] args) {
        launch();
    }
}