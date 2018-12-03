package com.administration.demo.Models;

import java.io.Serializable;

//  This is our representation of a course from the legacy system (web)
public class CourseWebModel implements Serializable
{
    private int id;
    private int semester;
    private String name;
    private String studyprogramme;
    private String namedanish;
    private String ects;
    private String description;
    private boolean mandatory;
    private int numberOfTeachers;
    private String language;

    public CourseWebModel()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getSemester()
    {
        return semester;
    }

    public void setSemester(int semester)
    {
        this.semester = semester;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStudyprogramme()
    {
        return studyprogramme;
    }

    public void setStudyprogramme(String studyprogramme)
    {
        this.studyprogramme = studyprogramme;
    }

    public String getNamedanish()
    {
        return namedanish;
    }

    public void setNamedanish(String namedanish)
    {
        this.namedanish = namedanish;
    }

    public String getEcts()
    {
        return ects;
    }

    public void setEcts(String ects)
    {
        this.ects = ects;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isMandatory()
    {
        return mandatory;
    }

    public void setMandatory(boolean mandatory)
    {
        this.mandatory = mandatory;
    }

    public int getNumberOfTeachers()
    {
        return numberOfTeachers;
    }

    public void setNumberOfTeachers(int numberOfTeachers)
    {
        this.numberOfTeachers = numberOfTeachers;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }
}
