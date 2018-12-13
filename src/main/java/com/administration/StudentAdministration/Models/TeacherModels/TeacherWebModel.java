package com.administration.StudentAdministration.Models.TeacherModels;

//  This is our representation of a course from the legacy system (web)
public class TeacherWebModel
{
    private int id;
    private String name;
    private String email;

    //empty constructor for spring and JPA purposes
    public TeacherWebModel(){}

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
