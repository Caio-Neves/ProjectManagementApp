package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Login;
import util.ConnectionFactory;


public class LoginController {
        
    public void createAccount(Login login){
        String sql = "INSERT INTO accounts (name, pass) VALUES (?, MD5(?))";
        
        Connection con = null;
        PreparedStatement stm = null;
        
        try{
            con = ConnectionFactory.getConnetion();
            stm = con.prepareStatement(sql);
            
            stm.setString(1, login.getName());
            stm.setString(2, login.getPass());
            
            stm.execute();
        }catch (Exception ex){
            throw new RuntimeException("Error creating account" + ex);
        } finally{
            ConnectionFactory.closeConnection(con, stm);
        }
    }
    
    public List<Login> logConfirm(String name, String pass){
        String sql = "SELECT name, pass FROM accounts WHERE name = ? AND pass = MD5(?)";
          
        List<Login> logins = new ArrayList<>();
        Login login = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
          
        try{
            con = ConnectionFactory.getConnetion();
            stm = con.prepareStatement(sql);
            
            stm.setString(1, name);
            stm.setString(2, pass);
            
            rs = stm.executeQuery();
            
            if (rs.next()){
                login = new Login();

                login.setName(rs.getString("name"));
                login.setPass(rs.getString("pass"));
                
                logins.add(login);
            } 
            
        } catch (Exception ex){
            throw new RuntimeException(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    return logins;}
}
