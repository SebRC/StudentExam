package com.administration.StudentAdministration.Models;

import com.administration.StudentAdministration.Models.CourseModels.CourseModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Students")
public class StudentModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentID;
    private String studenNname;
    private String studentEmail;
    private String studentUsername;
    private String studentPassword;
    private int enabled;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "students")

    private Set<CourseModel> courses = new HashSet<>();

    public StudentModel(){}

    public int getStudentID()
    {
        return studentID;
    }

    public void setStudentID(int studentID)
    {
        this.studentID = studentID;
    }

    public String getStudenNname()
    {
        return studenNname;
    }

    public void setStudenNname(String studenNname)
    {
        this.studenNname = studenNname;
    }

    public String getStudentEmail()
    {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail)
    {
        this.studentEmail = studentEmail;
    }

    public String getStudentUsername()
    {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername)
    {
        this.studentUsername = studentUsername;
    }

    public String getStudentPassword()
    {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword)
    {
        this.studentPassword = studentPassword;
    }

    public int getEnabled()
    {
        return enabled;
    }

    public void setEnabled(int enabled)
    {
        this.enabled = enabled;
    }
}
