package com.administration.demo.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CourseModel implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseID;
    private String courseNameDanish;
    private String courseNameEnglish;
    private int courseSemester;
    private String courseClassCode;
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
    private int courseMandatory;


    public CourseModel(){}

    public CourseModel(int courseID, String courseNameDanish, String courseNameEnglish, int courseSemester, String courseStudyProgramme, String courseECTS, String courseLanguage,
                       String courseLearningOutcome, boolean isMandatory)
    {
        this.courseID = courseID;
        this.courseNameDanish = courseNameDanish;
        this.courseNameEnglish = courseNameEnglish;
        this.courseSemester = courseSemester;
        //this.courseClassCode = "Default";
        this.courseStudyProgramme = courseStudyProgramme;
        this.courseECTS = courseECTS;
        this.courseLanguage = courseLanguage;
        //this.courseMinStudents = 0;
        //this.courseExpectedStudents = 0;
        //this.courseMaxStudents = 0;
        //this.coursePrerequisites = "Default";
        this.courseLearningOutcome = courseLearningOutcome;
        //this.courseContent = "Default";
        //this.courseLearningActivities = "Default";
        //this.courseExamForm = "Default";

        //converts a boolean to an int to store in database
        this.courseMandatory = 0;
        if(isMandatory)
        {
            this.courseMandatory = 1;
        }
    }

    public CourseModel(String courseNameDanish)
    {
        this.courseNameDanish = courseNameDanish;
    }

    public String getCourseClassCode()
    {
        return courseClassCode;
    }

    public void setCourseClassCode(String courseClassCode)
    {
        this.courseClassCode = courseClassCode;
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

}
