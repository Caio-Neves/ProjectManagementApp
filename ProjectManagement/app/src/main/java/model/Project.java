package model;

import java.util.Date;

public class Project {
    
    private String name;
    private String description;
    private int id;
    private Date createdat;
    private Date updatedat;

    public Project(String name, String description, int id, Date createdat, Date updatedat) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.createdat = createdat;
        this.updatedat = updatedat;
    }

    public Project() {
       this.createdat = new Date();
       this.updatedat = new Date();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return name;
    }
    
}
