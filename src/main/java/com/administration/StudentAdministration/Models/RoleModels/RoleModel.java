package com.administration.StudentAdministration.Models.RoleModels;


import javax.persistence.*;

//model representing a role
@Entity
@Table(name = "roles")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int role_id;
    private String role_name;

    //empty constructor for spring and JPA purposes
    public RoleModel(){}

    public RoleModel(String role_name)
    {
        this.role_name = role_name;
    }

    public int getRole_id()
    {
        return role_id;
    }

    public void setRole_id(int role_id)
    {
        this.role_id = role_id;
    }

    public String getRole_name()
    {
        return role_name;
    }

    public void setRole_name(String role_name)
    {
        this.role_name = role_name;
    }
}