package ti2cc.dao;

import java.sql.*;
import java.security.*;
import java.math.*;

public class DAO {
    //connection
    protected Connection conexao;

    //empty constructor
    public DAO() {
        conexao = null;
    }

    //start connection using postgres 'ti2cc' user infos
    public boolean conectar() {
        //data
        String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "postgres";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;

        //trying to connect and dealing with exception
        try {
            Class.forName(driverName);
            conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
    }

    //close connection and return status
    public boolean close() {
        //data
        boolean status = false;

        try{
            conexao.close();
            status = true;
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        return status;
    }

    public static String toMD5(String senha) throws Exception {
		MessageDigest m=MessageDigest.getInstance("MD5");
		m.update(senha.getBytes(),0, senha.length());
		return new BigInteger(1,m.digest()).toString(16);
	}
}
