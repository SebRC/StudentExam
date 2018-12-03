package com.administration.demo.Models;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "Teachers")
public class TeacherModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacherID;
    private String teacherName;
    @Email
    private String teacherEmail;

    public TeacherModel(){}

    public int getTeacherID()
    {
        return teacherID;
    }

    public void setTeacherID(int teacherID)
    {
        this.teacherID = teacherID;
    }

    public String getTeacherName()
    {
        return teacherName;
    }

    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail()
    {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail)
    {
        this.teacherEmail = teacherEmail;
    }
}
