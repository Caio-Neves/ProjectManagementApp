package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;


public class ProjectController {
    
    public void insert(Project project) { ///funcionando
        
        String sql = "INSERT INTO projects (name, description, createdat, updatedat) VALUES (?, ?, ?, ?)";
        
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = ConnectionFactory.getConnetion();
            stm = con.prepareStatement(sql);
            
            stm.setString(1, project.getName());
            stm.setString(2, project.getDescription());
            stm.setDate(3, new Date (project.getCreatedat().getTime()));
            stm.setDate(4, new Date(project.getUpdatedat().getTime()));
            stm.execute();
            
        }catch (SQLException ex) {
            throw new RuntimeException ("Erro ao criar projeto." + ex);
        } finally{
            ConnectionFactory.closeConnection(con, stm);
        }
    }
    
    public void update(Project project) { ///funcionando
        
        String sql = "UPDATE projects SET name = ?, description = ?, createdat = ?, updatedat = ? WHERE id = ?";
        
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = ConnectionFactory.getConnetion();
            stm = con.prepareStatement(sql);
            
            stm.setString(1, project.getName());
            stm.setString(2, project.getDescription());
            stm.setDate(3, new Date (project.getCreatedat().getTime()));
            stm.setDate(4, new Date(project.getUpdatedat().getTime()));
            stm.setInt(5, project.getId());
            stm.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro ao atualizar projeto.");
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    }

    public void delete(int idproject) { ///funcionando
        
        String sql = "DELETE FROM projects WHERE id = ?";
        
        Connection con = null;
        PreparedStatement stm = null;
        
        try{
            con = ConnectionFactory.getConnetion();
            stm = con.prepareStatement(sql);
            
            stm.setInt(1, idproject);
            stm.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar projeto.");
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    }
    
    public List<Project> getAll() { ///funcionando
        
        String sql = "SELECT * FROM projects";
        
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        List<Project> projects = new ArrayList<>();
        
        try {
            con = ConnectionFactory.getConnetion();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setCreatedat(rs.getDate("createdat"));
                project.setUpdatedat(rs.getDate("updatedat"));
                
                projects.add(project);
            }
            
        }catch (SQLException ex){
            throw new RuntimeException ("Erro ao carregar lista de projetos." + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
        }
        return projects;
    }
}
