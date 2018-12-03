package com.administration.StudentAdministration.Models.AdminModels;

import javax.persistence.*;

@Entity
@Table(name = "Administrators")
public class AdminModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminID;
    private String adminUsername;
    private String adminPassword;

    public AdminModel(){}

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
}
