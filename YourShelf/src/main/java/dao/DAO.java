package dao;

import java.sql.*;
import java.security.*;
import java.math.*;

public class DAO {
    //Data
    protected static Connection connection;

    /**
     * Default constructor.
     */
    public DAO() {
        connection = null;
    }

    /**
     *
     * Starts connection using default postgres project user.
     *
     * @return if connection was successful.
     */
    public boolean connect() {
        //data
        String driverName = "org.postgresql.Driver";
        String serverName = "localhost";
        String database = "yourShelf";
        int port = 5432;
        String url = "jdbc:postgresql://" + serverName + ":" + port +"/" + database;
        String username = "ti2cc";
        String password = "ti@cc";
        boolean status = false;

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
            status = (connection == null);
            System.out.println("Conexão efetuada com o postgres!");
        } catch (ClassNotFoundException e) {
            System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
        }

        return status;
    }

    /**
     *
     * ends connection started.
     *
     * @return if connection was closed successful.
     */
    public boolean close() {
        //data
        boolean status = false;

        try {
            connection.close();
            status = false;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return status;
    }

    /**
     * calculates the MD5 hash of a password.         *
     *
     * @param user_password  password to be converted into an MD5 hash.
     * @return A hexadecimal representation of the MD5 hash of the password.
     * @throws Exception If an error occurs while calculating the MD5 hash.
     */
    public static String toMD5(String user_password) throws Exception {
        //data: instance
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(user_password.getBytes(), 0, user_password.length());
        return new BigInteger(1, m.digest()).toString(16);
    }
}



