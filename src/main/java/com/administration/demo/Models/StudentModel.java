package com.administration.demo.Models;

import javax.persistence.*;

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
}
