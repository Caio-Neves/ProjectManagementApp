package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

public class TaskController {
    
    private String name;
    private String description;
    private String notes;
    private int idproject;
    private int id;
    private Date createdat;
    private Date updatedat;
    private Date deadline;
    private boolean completed;
    
    public void insert(Task task) {//funcionando
        
        String sql = "INSERT INTO tasks (name, description, notes, createdat, updatedat, deadline, idproject, completed)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = ConnectionFactory.getConnetion();
            stm = con.prepareStatement(sql);

            stm.setString(1, task.getName());
            stm.setString(2, task.getDescription());
            stm.setString(3, task.getNotes());
            stm.setDate(4, new Date(task.getCreatedat().getTime()));
            stm.setDate(5, new Date(task.getUpdatedat().getTime()));
            stm.setDate(6, new Date(task.getDeadline().getTime()));
            stm.setInt(7, task.getIdproject());
            stm.setBoolean(8, task.isCompleted());
            
            stm.execute();
            
        }catch (SQLException ex) {
            throw new RuntimeException("Erro ao criar tarefa." + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    }
    
    public void update(Task task) {
        
        String sql = "UPDATE tasks SET idproject = ?, name = ?, description = ?, notes = ?, "
                + "createdat = ?, updatedat = ?, deadline = ?, completed = ? WHERE id = ?";
        
        Connection con = null;
        PreparedStatement stm = null;
        
        try{
            con = ConnectionFactory.getConnetion();
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, task.getIdproject());
            stm.setString(2, task.getName());
            stm.setString(3, task.getDescription());
            stm.setString(4, task.getNotes());
            stm.setDate(5, new Date(task.getCreatedat().getTime()));
            stm.setDate(6, new Date(task.getUpdatedat().getTime()));
            stm.setDate(7, new Date(task.getDeadline().getTime()));
            stm.setBoolean(8, task.isCompleted());
            stm.setInt(9, task.getId());
            
            stm.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro ao atualizar tarefa" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    }
    
    public void delete(int id){ ///funcionando
        
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        Connection con = null;
        PreparedStatement stm = null;
        
        try{
            con = ConnectionFactory.getConnetion();
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, id);
            stm.execute();
            
        }catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar tarefa." + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    }
    
    public List<Task> getAll(){ ///funcionandu
        
        String sql = "SELECT * FROM tasks";
        
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        List<Task> tasks = new ArrayList<>();
 
        try {
            con = ConnectionFactory.getConnetion();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            
            while (rs.next()){
                Task task = new Task();
                
                task.setName(rs.getString("name"));
                task.setDescription(rs.getString("description"));
                task.setNotes(rs.getString("notes"));
                task.setCreatedat(rs.getDate("createdat"));
                task.setUpdatedat(rs.getDate("updatedat"));
                task.setDeadline(rs.getDate("deadline"));
                task.setIdproject(rs.getInt("idproject"));
                
                tasks.add(task);
            }
                        
        }catch (SQLException ex){
            throw new RuntimeException("Erro ao carregar lista de tarefas." + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
        }  
        
    return tasks;}
    
    public List<Task> getByProjectId(int id){
        String sql = "SELECT * FROM tasks WHERE idproject = ?";
        
        List<Task> tasks = new ArrayList<>();
        
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try{
            con = ConnectionFactory.getConnetion();
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, id);
            
            rs = stm.executeQuery();

            while(rs.next()){
                Task task = new Task();
                
                task.setId(rs.getInt("id"));
                task.setIdproject(rs.getInt("idproject"));
                task.setName(rs.getString("name"));
                task.setDescription(rs.getString("description"));
                task.setNotes(rs.getString("notes"));
                task.setCompleted(rs.getBoolean("completed"));
                task.setCreatedat(rs.getDate("createdat"));
                task.setUpdatedat(rs.getDate("updatedat"));
                task.setDeadline(rs.getDate("deadline"));
                
                tasks.add(task);
            }
        }catch (Exception ex){
            throw new RuntimeException("Erro ao carregar tarefas do projeto" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
        }
    return tasks;}
}
