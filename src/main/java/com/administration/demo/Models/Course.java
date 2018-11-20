package com.administration.demo.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course
{
    @Id
    private int courseID;
    private String courseNameDanish;
    private String courseNameEnglish;
    private int courseSemester;
    private String courseStudyProgramme;
    private String courseECTS;
    private String courseLanguage;
    private int courseMinStudents;
    private int courseExpectedStudents;
    private int courseMaxStudents;
    private String coursePrerequisites;
    private String courseLearningOutcome;
    private String courseContent;
    private String courseLearningActivities;
    private String courseExamForm;

    //TO DO
    private int courseMandatory;

    public Course(){}
}
