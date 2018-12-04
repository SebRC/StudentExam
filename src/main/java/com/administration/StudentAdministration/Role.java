package com.administration.StudentAdministration;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int role_id;
    private String role_name;

    public Role(String role_name)
    {
        this.role_name = role_name;
    }
}