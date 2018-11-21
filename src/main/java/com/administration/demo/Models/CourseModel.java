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

    //TO DO
    private int courseMandatory;



    public CourseModel(){}

    public CourseModel(int courseID, String courseNameDanish, String courseNameEnglish, int courseSemester,
                       String courseClassCode, String courseStudyProgramme, String courseECTS, String courseLanguage,
                       int courseMinStudents, int courseExpectedStudents, int courseMaxStudents,
                       String coursePrerequisites, String courseLearningOutcome, String courseContent,
                       String courseLearningActivities, String courseExamForm, boolean isMandatory)
    {
        this.courseID = courseID;
        this.courseNameDanish = courseNameDanish;
        this.courseNameEnglish = courseNameEnglish;
        this.courseSemester = courseSemester;
        this.courseClassCode = courseClassCode;
        this.courseStudyProgramme = courseStudyProgramme;
        this.courseECTS = courseECTS;
        this.courseLanguage = courseLanguage;
        this.courseMinStudents = courseMinStudents;
        this.courseExpectedStudents = courseExpectedStudents;
        this.courseMaxStudents = courseMaxStudents;
        this.coursePrerequisites = coursePrerequisites;
        this.courseLearningOutcome = courseLearningOutcome;
        this.courseContent = courseContent;
        this.courseLearningActivities = courseLearningActivities;
        this.courseExamForm = courseExamForm;

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
