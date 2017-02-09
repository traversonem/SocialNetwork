/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author utente
 */
public class UserDAO {

    User findById(long id) throws SQLException, Exception {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String db_user = "root";
        String db_user_password = "root";

        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/socialnetwork",
                db_user, db_user_password);

        try {

            stmt = conn.createStatement();

            rs = stmt.executeQuery(String.format("SELECT id,name,password FROM user "));
            if (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");

                User user = new User(id, name, password);
                return user;
            }
            else
                throw new Exception("Attenzione utente non trovato");
        } catch(SQLException e) {
            System.out.println("Errore in findById:: " + e);
            throw e;
        } finally {
            if (rs != null) { try {rs.close();} catch(SQLException e) {}}
            if (stmt != null) { try {rs.close();} catch(SQLException e) {}}
            if (conn != null) { try {conn.close();} catch (SQLException e) {}}
            }
            
        }
        
    ArrayList<User> findAll() throws SQLException, Exception {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<User> utenti = new ArrayList();

        String db_user = "root";
        String db_user_password = "root";

        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/socialnetwork",
                db_user, db_user_password);

        try {

            stmt = conn.createStatement();

            rs = stmt.executeQuery(String.format("SELECT id,name,password FROM user "));
            int i = 0;
            while (rs.next()) {
                long id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                
                User user = new User(id, name, password);
                utenti.add(user);
                i++;
            }
            if(utenti.size()>0){
                return utenti;
            }else {
                throw new Exception("Nessun utente trovato");
            }    
            
        
        }catch(SQLException e) {
            System.out.println("Errore in findAll: " + e);
            throw e;
        } finally {
            if (rs != null) { try {rs.close();} catch(SQLException e) {}}
            if (stmt != null) { try {rs.close();} catch(SQLException e) {}}
            if (conn != null) { try {conn.close();} catch (SQLException e) {}}
            }
        }
    
    
    void save (User user) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
    try{
        String db_user = "root";
        String db_user_password = "root";

        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/socialnetwork",
                db_user, db_user_password);

        stmt = conn.createStatement();
        
        String sql = String.format("INSERT INTO users(id,name,password) VALUES (%d,'%s','%s')" +
                "on duplicate key " + 
                "update name='%s', password='%s' ",
                user.id,user.name,user.password,user.name,user.password);
        
        int rows = stmt.executeUpdate(sql);
    }
    catch (Exception e) {
        
    }
    }
}