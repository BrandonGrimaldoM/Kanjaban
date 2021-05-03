/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;



import MAIN.App;
import com.mysql.cj.x.protobuf.MysqlxPrepare;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    
    public void insertTask(String name,String desc,int priority,int stage,int project){
        try {
            stmt.executeUpdate("insert into task (name_task,description,priority,id_stage,id_project,create_date) "
                             + "values ("+'"'+name+'"'+ ","+'"'+desc+'"'+","+ priority + ","+  stage+","+ project + ",sysdate())");
            JOptionPane.showMessageDialog(null, "Agregaste una nueva tarea","",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Ya existe una tarea con este nombre");
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
    
  public void UpdateTask(int num ,String name){
      try{
      stmt.executeUpdate("update task set id_stage =" + num + " where id_task > 0  and name_task =" +'"'+name+'"');
      }catch(Exception e){
          
      }
  }
  
  
  public void UpdateAllProfile(String name,String pass){
      try{
      stmt.executeUpdate("update profile set name =" +'"'+name+'"'+ ",password =" +'"'+pass+'"'+" where id_user > 0  ");
      }catch(Exception e){
          
      }
  }
  public void UpdateNameProfile(String name){
      try{
      stmt.executeUpdate("update profile set name =" +'"'+name+'"'+" where id_user > 0  ");
      }catch(Exception e){
          
      }
  }
  
  public void UpdatePassProfile(String pass){
      try{
      stmt.executeUpdate("update profile set password =" +'"'+pass+'"'+" where id_user > 0  ");
      }catch(Exception e){
          
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
    public void showUser(){
         try{
            data = stmt.executeQuery("select * from profile");
            data.next();
            
            
        } catch (SQLException ex) {
            
           
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
