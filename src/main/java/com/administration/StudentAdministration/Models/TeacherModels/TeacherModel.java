package com.administration.StudentAdministration.Models.TeacherModels;

import com.administration.StudentAdministration.Models.CourseModels.CourseModel;
import com.administration.StudentAdministration.Models.Role;

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
    private int id;
    private String teacherName;
    @Email
    private String teacherEmail;
    private String username;
    private String password;
    private int enabled;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "teachers")

    private Set<CourseModel> courses = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "teachers_roles", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public TeacherModel(){}

    public TeacherModel(String teacherName, String teacherEmail, String userName, String password)
    {
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.username = userName;
        this.password = password;
    }

    public int getId()
    {
        return id;
    }

    public int getEnabled()
    {
        return enabled;
    }

    public void setEnabled(int enabled)
    {
        this.enabled = enabled;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }
}
