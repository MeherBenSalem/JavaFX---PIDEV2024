package com.example.projectpi.Services;

import com.example.projectpi.Connectors.MySQLConnector;
import com.example.projectpi.entites.User;
import com.example.projectpi.interfaces.IUserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {

    private Connection connection;
    public UserService() {
        try {
            this.connection = MySQLConnector.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int Create(User user) {
        int result = 0;
        String req = "INSERT INTO User (Username, Email, Password, DateJoined)" +
                "VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement statement = this.connection.prepareStatement(req);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setDate(4, user.getDateJoined());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<User> Read() {
        List<User> users = new ArrayList<>();
        String req = "SELECT * FROM User";
        try {
            PreparedStatement statement = this.connection.prepareStatement(req);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userID = resultSet.getInt("UserID");
                String username = resultSet.getString("Username");
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Password");
                java.sql.Date dateJoined = resultSet.getDate("DateJoined");
                users.add(new User(userID, username, email, password, dateJoined));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public int Update(int id, User user) {
        int result = 0;
        String req = "UPDATE User SET Username=?, Email=?, Password=?, DateJoined=? WHERE UserID=?";
        try {
            PreparedStatement statement = this.connection.prepareStatement(req);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setDate(4, new java.sql.Date(user.getDateJoined().getTime()));
            statement.setInt(5, id);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int Delete(int id) {
        int result = 0;
        String req = "DELETE FROM User WHERE UserID=?";
        try {
            PreparedStatement statement = this.connection.prepareStatement(req);
            statement.setInt(1, id);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
