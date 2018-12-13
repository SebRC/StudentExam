package com.administration.StudentAdministration.Models.TeacherModels;

import com.administration.StudentAdministration.Models.CourseModels.CourseModel;
import com.administration.StudentAdministration.Models.RoleModels.RoleModel;

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
    @Column(name = "id")
    private int teacherID;
    private String teacherName;
    @Email
    private String teacherEmail;
    @Column(name = "username")
    private String teacherUsername;
    @Column(name = "password")
    private String teacherPassword;
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
    private Set<RoleModel> roles;


    public TeacherModel(){}

    public TeacherModel(String teacherName, @Email String teacherEmail, String teacherUsername, String teacherPassword, int enabled)
    {
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.teacherUsername = teacherUsername;
        this.teacherPassword = teacherPassword;
        this.enabled = enabled;
    }

    public int getEnabled()
    {
        return enabled;
    }

    public void setEnabled(int enabled)
    {
        this.enabled = enabled;
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

    public Set<RoleModel> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles)
    {
        this.roles = roles;
    }

    public int getTeacherID()
    {
        return teacherID;
    }

    public void setTeacherID(int teacherID)
    {
        this.teacherID = teacherID;
    }

    public String getTeacherUsername()
    {
        return teacherUsername;
    }

    public void setTeacherUsername(String teacherUsername)
    {
        this.teacherUsername = teacherUsername;
    }

    public String getTeacherPassword()
    {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword)
    {
        this.teacherPassword = teacherPassword;
    }
}
