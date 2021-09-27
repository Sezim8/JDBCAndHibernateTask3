package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;
//import sun.tools.jstat.Jstat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import static jdk.vm.ci.hotspot.HotSpotCallingConventionType.VALUES;
import static peaksoft.util.Util.connect;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE users " +
                "( id serial primary key, " +
                "name VARCHAR NOT NULL, " +
                "lastName VARCHAR not null, " +
                "age INTEGER NOT NULL); ";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


        public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table deleted in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

        public void saveUser(String name, String lastName, byte age) {
        String SQL = "INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)";
        try (Connection conn = Util.connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, name);
            stmt.setString(2, lastName);
            stmt.setByte(3, age);
            stmt.executeUpdate();
            System.out.println(name + " successfully added!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void removeUserById(long id) {
        String sql = "delete from users where id = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, (int) id);
            stmt.executeUpdate();
            System.out.println("sdads");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = Util.connect();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from users")){
            while (resultSet.next()){
                users.add(new User(
                        (long) resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getByte(4)));
            }
            System.out.println("Базада бар баардык данныйлар");

        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return users;
    }
    public void cleanUsersTable() {
        String sql = " truncate table users";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
