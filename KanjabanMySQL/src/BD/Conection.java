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
    
    
    public void insertProyect(String project){
        try {
            stmt.executeUpdate("insert into project (name_project,id_user) "
                             + "values ("+'"'+project+'"'+",1)");
            JOptionPane.showMessageDialog(null, "Agregaste un nuevo proyecto","",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Ya existe un proyecto con este nombre");
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
    
    public void UpdateAllTask(String name,String desc,String prio,String nametask){
      try{
      stmt.executeUpdate("update task set name_task =" +'"'+name+'"'+ ",description =" +'"'+desc+'"'+",priority ="+prio +" where id_task > 0 and name_task ="+'"'+nametask+'"');
      JOptionPane.showMessageDialog(null, "Cambios realizados","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "ya existe una tarea con ese nombre","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
  }
    
    public void UpdateProject(String newname,String name){
      try{
      stmt.executeUpdate("update project set name_project =" +'"'+newname+'"'+" where id_project > 0 and name_project ="+'"'+name+'"');
      JOptionPane.showMessageDialog(null, "Cambios realizados","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "ya existe un projecto con ese nombre","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
  }
    
    public void showTask(String task){
         try{
            data = stmt.executeQuery("select * from task where name_task="+'"'+task+'"');
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
    
    
    public void DeleteTask(String proyect){
      try{
          getIdProyect(proyect);
          stmt.executeUpdate("delete from task"+" where id_task > 0 and id_project ="+data.getInt("id_project"));
          
          JOptionPane.showMessageDialog(null, "Tareas eliminadas","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "No se pudo eliminar","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
  }
    
    public void DeleteProject(String proyect){
      try{
          getIdProyect(proyect);
          
          stmt.executeUpdate("delete from project"+" where id_project ="+data.getInt("id_project"));
          JOptionPane.showMessageDialog(null, "Proyecto Eliminado","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "No se pudo eliminar","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
  }
    
    public void DeleteTaskSelect(String proyect){
      try{
          
          stmt.executeUpdate("delete from task"+" where id_task > 0 and name_task ="+'"'+proyect+'"');
          
          JOptionPane.showMessageDialog(null, "Tareas eliminadas","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "No se pudo eliminar","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
  }
    
    public void UpdateStartDate(String name){
        try{
      stmt.executeUpdate("update task set start_date = sysdate() where id_task > 0 and name_task ="+'"'+name+'"');
      JOptionPane.showMessageDialog(null, "Tarea Iniciada","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "tarea no iniciada","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
    }
    
    public void UpdateEndDate(String name){
         try{
      stmt.executeUpdate("update task set end_date = sysdate() where id_task > 0 and name_task ="+'"'+name+'"');
      JOptionPane.showMessageDialog(null, "Tarea Finalizada","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "tarea no iniciada","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
    }
    public void UpdateStartDateNull(String name){
        try{
      stmt.executeUpdate("update task set start_date = null where id_task > 0 and name_task ="+'"'+name+'"');
      JOptionPane.showMessageDialog(null, "Tarea cancelada","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "tarea no iniciada","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
    }
    
    public void UpdateEndDateNull(String name){
         try{
      stmt.executeUpdate("update task set end_date = null where id_task > 0 and name_task ="+'"'+name+'"');
      JOptionPane.showMessageDialog(null, "Tarea Reanudada","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "tarea no iniciada","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
    }
    
}
