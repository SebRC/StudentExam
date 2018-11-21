package com.administration.demo.Models;

import javax.persistence.*;

@Entity
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseID;
    private String courseNameDanish;
    private String courseNameEnglish;
    /*private int courseSemester;
    private String courseStudyProgramme;
    private String courseECTS;
    private String courseLanguage;
    private int courseMinStudents;
    private int courseExpectedStudents;
    private int courseMaxStudents;
    private String coursePrerequisites;
    private String courseLearningOutcome;
    //@Column(name = "courseContent")
    //private String courseContent;
    private String courseLearningActivities;
    //private String courseExamForm;

    //TO DO
    private int courseMandatory;

    */

    public Course(){}

    public Course(String courseNameDanish)
    {
        this.courseNameDanish = courseNameDanish;
    }

    public int getCourseID()
    {
        return courseID;
    }

    public void setCourseID(int courseID)
    {
        this.courseID = courseID;
    }

    public String getCourseNameDanish()
    {
        return courseNameDanish;
    }

    public void setCourseNameDanish(String courseNameDanish)
    {
        this.courseNameDanish = courseNameDanish;
    }

    /*
    public String getCourseNameEnglish()
    {
        return courseNameEnglish;
    }

    public void setCourseNameEnglish(String courseNameEnglish)
    {
        this.courseNameEnglish = courseNameEnglish;
    }

    public int getCourseSemester()
    {
        return courseSemester;
    }

    public void setCourseSemester(int courseSemester)
    {
        this.courseSemester = courseSemester;
    }

    public String getCourseStudyProgramme()
    {
        return courseStudyProgramme;
    }

    public void setCourseStudyProgramme(String courseStudyProgramme)
    {
        this.courseStudyProgramme = courseStudyProgramme;
    }

    public String getCourseECTS()
    {
        return courseECTS;
    }

    public void setCourseECTS(String courseECTS)
    {
        this.courseECTS = courseECTS;
    }

    public String getCourseLanguage()
    {
        return courseLanguage;
    }

    public void setCourseLanguage(String courseLanguage)
    {
        this.courseLanguage = courseLanguage;
    }

    public int getCourseMinStudents()
    {
        return courseMinStudents;
    }

    public void setCourseMinStudents(int courseMinStudents)
    {
        this.courseMinStudents = courseMinStudents;
    }

    public int getCourseExpectedStudents()
    {
        return courseExpectedStudents;
    }

    public void setCourseExpectedStudents(int courseExpectedStudents)
    {
        this.courseExpectedStudents = courseExpectedStudents;
    }

    public int getCourseMaxStudents()
    {
        return courseMaxStudents;
    }

    public void setCourseMaxStudents(int courseMaxStudents)
    {
        this.courseMaxStudents = courseMaxStudents;
    }

    public String getCoursePrerequisites()
    {
        return coursePrerequisites;
    }

    public void setCoursePrerequisites(String coursePrerequisites)
    {
        this.coursePrerequisites = coursePrerequisites;
    }

    public String getCourseLearningOutcome()
    {
        return courseLearningOutcome;
    }

    public void setCourseLearningOutcome(String courseLearningOutcome)
    {
        this.courseLearningOutcome = courseLearningOutcome;
    }

    public String getCourseContent()
    {
        return courseContent;
    }

    public void setCourseContent(String courseContent)
    {
        this.courseContent = courseContent;
    }

    public String getCourseLearningActivities()
    {
        return courseLearningActivities;
    }

    public void setCourseLearningActivities(String courseLearningActivities)
    {
        this.courseLearningActivities = courseLearningActivities;
    }


    public String getCourseExamForm()
    {
        return courseExamForm;
    }

    public void setCourseExamForm(String courseExamForm)
    {
        this.courseExamForm = courseExamForm;
    }


    public int getCourseMandatory()
    {
        return courseMandatory;
    }

    public void setCourseMandatory(int courseMandatory)
    {
        this.courseMandatory = courseMandatory;
    }
    */
}
