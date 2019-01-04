package com.administration.StudentAdministration.Models.AdminModels;

import com.administration.StudentAdministration.Models.RoleModels.RoleModel;
import javax.persistence.*;
import java.util.Set;

//model representing our version of an admin

@Entity
@Table(name = "Admins")
public class AdminModel
{
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminID;
    @Column(name = "username")
    private String adminUsername;
    @Column(name = "password")
    private String adminPassword;
    private int enabled;

    //junction table representing relation between admins and roles
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "admins_roles", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleModel> roles;

    //empty constructor used by JPA and used when adding to a model in spring
    public AdminModel(){}

    //constructor used when creating an admin in test code
    public AdminModel(String adminUsername, String adminPassword, int enabled)
    {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.enabled = enabled;
    }

    public int getAdminID()
    {
        return adminID;
    }

    public void setAdminID(int adminID)
    {
        this.adminID = adminID;
    }

    public String getAdminUsername()
    {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername)
    {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword()
    {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword)
    {
        this.adminPassword = adminPassword;
    }

    public int getEnabled()
    {
        return enabled;
    }

    public void setEnabled(int enabled)
    {
        this.enabled = enabled;
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
