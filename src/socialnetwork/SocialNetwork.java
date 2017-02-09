/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetwork;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author utente
 */
public class SocialNetwork {


    public static void main(String[] args) throws SQLException, Exception {
                
        UserDAO userDAO = new UserDAO();
        
        User user = userDAO.findById(1);
        user.showProfile();
//------------------------------------------------------------------------------
        ArrayList<User> utenti = userDAO.findAll();
        for (int i = 0;i<utenti.size();i++){
            utenti.get(i).showProfile();
        }
//------------------------------------------------------------------------------        
       
    }    
//        Connection conn = null;
//        
//        try {
//            
//            String db_user = "riccobene";
//            String db_user_password = "riccobene9";
//
//            Class.forName("com.mysql.jdbc.Driver");
//            
//            conn = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/socialnetwork", 
//                    db_user, db_user_password);
//            
//            Statement st1 = null;
//            ResultSet rs1 = null;
//            try {
//                st1 = conn.createStatement();
//
//                String sql1 = String.format("select * from user ");
//
//                rs1 = st1.executeQuery(sql1);
//
//                ResultSetMetaData rsmd = rs1.getMetaData();
//                int columnsNumber = rsmd.getColumnCount();
//
//                while( rs1.next() ) {
//                    for(int i = 1; i <= columnsNumber; i++)
//                        System.out.print( rs1.getString(i) + " " );
//                    System.out.println();
//                }
//            }
//            catch(SQLException e) {
//                System.out.println("Errore query 1: " + e);
//            }
//            finally {
//                if (rs1 != null) { try {rs1.close();} catch(SQLException e){}}
//                if (st1 != null) { try {st1.close();} catch(SQLException e){}}
//            }
//            
//            System.out.println("--------------------");
//            
//            Statement st2 = null;
//            ResultSet rs2 = null;
//            
//            try {
//                
//                long circleId = 2;
//
//                st2 = conn.createStatement();
//
//                rs2 = st2.executeQuery("select user.name,circle.name from membership " +
//                                                 "join user on membership.userid = user.id " + 
//                                                 "join circle on membership.circleid = circle.id " +
//                                                 "where circle.id = " + circleId);
//
//                while( rs2.next() ) {
//                    System.out.println( rs2.getString("user.name") + "/" + rs2.getString("circle.name") );
//                }
//            }
//            catch(SQLException e) {
//                System.out.println("Errore query 2: " + e);
//            }
//            finally {
//                if (rs2 != null) { try {rs2.close();} catch(SQLException e){}}
//                if (st2 != null) { try {st2.close();} catch(SQLException e){}}
//            }            
//            
//            // ------------------------------------
//            
//            Statement st3 = null;
//            
//            try {
//                st3 = conn.createStatement();
//
//
//
//                String sql3 = String.format("insert into post " +
//                              "(date,title,body,imageurl,userid,circleid) " +
//                              "values " +
//                              "('%s', '%s', '%s', '%s', %d, %d);",
//                              "2017-02-02", "Riprende il corso", "bla bla bla", "www.chiavari.it", 1, 1);
//
//                int rowCount = st3.executeUpdate(sql3);
//            }
//            catch(SQLException e) {
//                System.out.println("Errore query 3: " + e);
//            }
//            finally {
//                
//                if (st3 != null) { try {st3.close();} catch(SQLException e){}}
//            }            
//            
//            
//            /*
//            User mario = new User("Mario", LocalDate.of(2001,11,4));
//            User antonella = new User("Antonella", LocalDate.of(2001,11,4));
//
//            Circle corsoJava = new Circle("Corso Java");
//            corsoJava.add(mario);
//            corsoJava.add(antonella);
//
//            Post post1 = new Post(mario, "Elezioni USA", "oh noooo, ha vinto Trump!!");
//            Post post2 = new RichPost(antonella, "Corso su Java", "ciao oggi al corso... bleah!!", "http://wwww.corriere.it");
//
//            corsoJava.publish(post1);
//
//            corsoJava.showWall();
//            
//            corsoJava.publish(post2);
//                    
//            corsoJava.showWall();     
//            */
//        }
//        catch(Exception e) {
//            // ...
//            System.out.println(e);
//        }
//        finally {
//                if (conn != null) { try {conn.close();} catch(SQLException e){}}
//                
//            }
//    }
    
}
