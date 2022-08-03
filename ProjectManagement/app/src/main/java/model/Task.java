package model;

import java.util.Date;


public class Task {
    
    private String name;
    private String description;
    private String notes;
    private int id;
    private int idproject;
    private Date createdat;
    private Date updatedat;
    private Date deadline;
    private boolean completed;

    public Task(String name, String description, String notes, int id, int idproject, Date createdat, Date updatedat, Date deadline, boolean completed) {
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.id = id;
        this.idproject = idproject;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.deadline = deadline;
        this.completed = completed;
    }

    public Task() {
        this.createdat = new Date();
        this.updatedat = new Date();
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdproject() {
        return idproject;
    }

    public void setIdproject(int idproject) {
        this.idproject = idproject;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TaskModel{" + "name=" + name + ", description=" + description + ", notes=" + notes + ", id=" + id + ", idproject=" + idproject + ", createdat=" + createdat + ", updatedat=" + updatedat + ", deadline=" + deadline + ", completed=" + completed + '}';
    }

}
