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
    String user = "James";
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
            JOptionPane.showMessageDialog(null, "Added task","",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"A task with this name already exists");
        }
    }
    
    
    public void insertProyect(String project){
        try {
            stmt.executeUpdate("insert into project (name_project,id_user) "
                             + "values ("+'"'+project+'"'+",1)");
            JOptionPane.showMessageDialog(null, "Added project","",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"A project with this name already exists");
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
      JOptionPane.showMessageDialog(null, "edited","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "A task with this name already exists","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
  }
    
    public void UpdateProject(String newname,String name){
      try{
      stmt.executeUpdate("update project set name_project =" +'"'+newname+'"'+" where id_project > 0 and name_project ="+'"'+name+'"');
      JOptionPane.showMessageDialog(null, "edited","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "A project with this name already exists","¡Ups!",JOptionPane.WARNING_MESSAGE);
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
            data = stmt.executeQuery("SELECT a.name_task,a.id_stage,a.priority,b.name_project FROM task a join project b on (a.id_project = b.id_project) where name_project ="+'"'+project+'"'+"order by a.priority desc");
            data.next();
            
           
            
        } catch (SQLException ex) {
            
            
        }
    }
    
    
    public void DeleteTask(String proyect){
      try{
          getIdProyect(proyect);
          stmt.executeUpdate("delete from task"+" where id_task > 0 and id_project ="+data.getInt("id_project"));
          
          JOptionPane.showMessageDialog(null, "Task deleted","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "can't deleted","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
  }
    
    public void DeleteProject(String proyect){
      try{
          getIdProyect(proyect);
          
          stmt.executeUpdate("delete from project"+" where id_project ="+data.getInt("id_project"));
          JOptionPane.showMessageDialog(null, "Project deleted","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "can't delete","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
  }
    
    public void DeleteTaskSelect(String proyect){
      try{
          
          stmt.executeUpdate("delete from task"+" where id_task > 0 and name_task ="+'"'+proyect+'"');
          
          JOptionPane.showMessageDialog(null, "Task deleted","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "can't delete","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
  }
    
    public void UpdateStartDate(String name){
        try{
      stmt.executeUpdate("update task set start_date = sysdate() where id_task > 0 and name_task ="+'"'+name+'"');
      JOptionPane.showMessageDialog(null, "Doing Task","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "ups","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
    }
    
    public void UpdateEndDate(String name){
         try{
      stmt.executeUpdate("update task set end_date = sysdate() where id_task > 0 and name_task ="+'"'+name+'"');
      JOptionPane.showMessageDialog(null, "Done task","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "ups","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
    }
    public void UpdateStartDateNull(String name){
        try{
      stmt.executeUpdate("update task set start_date = null where id_task > 0 and name_task ="+'"'+name+'"');
      JOptionPane.showMessageDialog(null, "Task stopped","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "ups","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
    }
    
    public void UpdateEndDateNull(String name){
         try{
      stmt.executeUpdate("update task set end_date = null where id_task > 0 and name_task ="+'"'+name+'"');
      JOptionPane.showMessageDialog(null, "Resuming","",JOptionPane.DEFAULT_OPTION);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "ups","¡Ups!",JOptionPane.WARNING_MESSAGE);
      }
    }
    
}
