/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;



import MAIN.App;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GON
 */
public class Conection {
    String user = "root";
    String password="clave";
    String url = "jdbc:mysql://localhost:3306/kanjaban";
    Connection con;
    Statement stmt;
    public ResultSet data;
    
    
    public Conection(){
       
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertTask(String name){
        try {
            stmt.executeUpdate("insert into task (name_task,description,priority,id_stage,id_project,create_date) "
                             + "values (\"joda\",\"sfsf\",4,1,2,sysdate())");
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public void conClose(){
        if (con != null) {
            try {
                con.close();
                data.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
    
    public void select(){
        try {
            
            
            data = stmt.executeQuery("select * from profile");
            data.next();
            do{
                System.out.print(data.getString("name"));
            }while(data.next());
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public boolean logUser(String user,String password){
        
       
        try{
            data = stmt.executeQuery("select * from profile where name="+'"'+user+'"');
            data.next();
            return user.equals(data.getString("name")) && password.equals(data.getString("password"));
            
        } catch (SQLException ex) {
            
            return false;
        }
  
    }
    
    public void getProyect(){
        
        try{
            data = stmt.executeQuery("SELECT * FROM project");
            data.next();
            
           
            
        } catch (SQLException ex) {
            
            
        }
    }
    
    public void getIdProyect(String id){
        
        try{
            data = stmt.executeQuery("SELECT * FROM project where name_project="+'"'+id+'"');
            data.next();
            
           
            
        } catch (SQLException ex) {
            
            
        }
    }
    
    public void getTask(String project){
        try{
            data = stmt.executeQuery("SELECT a.name_task,a.id_stage,b.name_project FROM task a join project b on (a.id_project = b.id_project) where name_project ="+'"'+project+'"');
            data.next();
            
           
            
        } catch (SQLException ex) {
            
            
        }
    }
    
    
    
    
    
}
