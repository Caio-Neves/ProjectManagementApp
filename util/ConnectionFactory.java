package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConnectionFactory {
    
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/listapp"; 
    public static final String USER = "root"; 
    public static final String PASS = ""; 

    public static Connection getConnetion() {
        try {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException ("Erro ao fazer conexão com banco de dados." + ex);
        }
    }
    
    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException ("Erro ao fechar conexão com banco de dados." + ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stm) {
        try {
            if (con != null) {
                con.close();
            }
            if (stm != null) {
                stm.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException ("Erro ao fechar conexão com banco de dados e statement.");
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stm, ResultSet rs) {
        try {
            if (con != null){
                con.close();
            }
            if (stm != null){
                stm.close();
            }
            if (rs != null){
                rs.close();
            }
        } catch (Exception ex){
            throw new RuntimeException("Erro ao fechar conexão com banco de dados, statement e resultset");
        }
    }
}
