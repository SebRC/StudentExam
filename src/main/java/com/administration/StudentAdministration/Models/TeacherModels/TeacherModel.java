package com.administration.StudentAdministration.Models.TeacherModels;

import com.administration.StudentAdministration.Models.CourseModels.CourseModel;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "teachers")

    private Set<CourseModel> courses = new HashSet<>();


    public TeacherModel(){}

    public TeacherModel(String teacherName, String teacherEmail)
    {
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
    }

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

    public Set<CourseModel> getCourses()
    {
        return courses;
    }

    public void setCourses(Set<CourseModel> courses)
    {
        this.courses = courses;
    }
}
