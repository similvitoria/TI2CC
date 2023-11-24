package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO extends DAO{
    /**
     * Default constructor: Initializes a connection to the database.
     */
    public UserDAO() {
        super();
        connect();
    }

    /**
     * Finalizes the database connection when collected by the Garbage Collector.
     */
    protected void finalize() {
        close();
    }

    /**
     * Inserts a new user into the database.
     *
     * @param user object to be inserted.
     * @return True if the insertion is successful, false otherwise.
     */
    public boolean insert(User user) {
        //data
        boolean status = false;
        try {
            Statement st = connection.createStatement();
            String query = "INSERT INTO usuarios (UserID, Email, Password, FirstName, SecondName) "
                    + "VALUES ('"+user.getUserID()+ "', '" + user.getEmail() + "', '"
                    + user.getPassword() + "', '" + user.getFirstName() + "', '" + user.getSecondName() + "');";
            st.executeUpdate(query);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

    /**
     * Retrieves a user by their ID from the database.
     *
     * @param UserID ID of the user to retrieve.
     * @return A User object if found, or null if not found.
     */
    public User get(String UserID) {
        //data
        User user = null;
        try {
            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT * FROM usuarios WHERE UserID=" + UserID;
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                user = new User(rs.getString("UserID"), rs.getString("Email"), rs.getString("Password"), rs.getString("FirstName"), rs.getString("SecondName"));            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return user;
    }

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT * FROM usuarios";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                User u = new User(rs.getString("UserID"), rs.getString("Email"), rs.getString("Password"), rs.getString("FirstName"), rs.getString("SecondName"));
                users.add(u);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return users;
    }


    /**
     * updates a user by their ID from the database.
     *
     * @param user object to be updated.
     * @return True if the update was successful, false otherwise.
     */
    public boolean update(User user) {
        //data
        boolean status = false;
        try {
            Statement st = connection.createStatement();
            String query = "UPDATE usuarios SET Email = '" + user.getEmail() + "', Password = '"
                    + user.getPassword() + "', FirstName = '" + user.getFirstName() + "', SecondName = '" + user.getSecondName()+ "'"
                    + " WHERE UserID = " + user.getUserID();
            st.executeUpdate(query);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

    /**
     * deletes a user by their ID from the database.
     *
     * @param UserID object to be updated.
     * @return True if the exclusion was successful, false otherwise.
     */
    public boolean delete(int UserID) {
        //data
        boolean status = false;
        try {
            Statement st = connection.createStatement();
            String query = "DELETE FROM usuarios WHERE UserID = " + UserID;
            st.executeUpdate(query);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

    /**
     * updates a user by their ID from the database.
     *
     * @param Email user's email.
     * @param Password users'password.
     * @return True if user exists, false otherwise.
     */
    public User authenticate(String Email, String Password) {
        //data
        boolean userExists = false;
        User user = null;

        try {
            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT * FROM usuarios WHERE Email LIKE '" + Email + "' AND Password LIKE '" + Password + "'";
            ResultSet rs = st.executeQuery(query);
            userExists = rs.next();
            if (userExists) {
                user = new User(rs.getString("UserID"), rs.getString("Email"), rs.getString("Password"), rs.getString("FirstName"), rs.getString("SecondName"));
            }
            st.close();
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return user;
    }
}

