package com.administration.StudentAdministration.Models.StudentModels;

import com.administration.StudentAdministration.Models.CourseModels.CourseModel;
import com.administration.StudentAdministration.Models.RoleModels.RoleModel;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//model representing a student in both the webservice and our database
@Entity
@Table(name = "Students")
public class StudentModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private int enabled;

    //relation between students and courses
    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                    },
            mappedBy = "students")
    private Set<CourseModel> courses = new HashSet<>();

    //junction table representing relation between students and roles
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "students_roles", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleModel> roles;

    //empty constructor for spring and JPA purposes
    public StudentModel(){}

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

    public int getEnabled()
    {
        return enabled;
    }

    public void setEnabled(int enabled)
    {
        this.enabled = enabled;
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
}
