package com.administration.demo.Models;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "Teachers")
public class TeacherModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Email
    private String email;

    public TeacherModel(){}

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
