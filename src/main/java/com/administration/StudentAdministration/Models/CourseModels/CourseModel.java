package com.administration.StudentAdministration.Models.CourseModels;

import com.administration.StudentAdministration.Models.StudentModels.StudentModel;
import com.administration.StudentAdministration.Models.TeacherModels.TeacherModel;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//  This is our representation of a course in our local database
@Entity
@Table(name="Courses")
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
    @Transient
    private String stringOfTeachers;

    //junction table representing relation between courses and teachers
    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                    })
    @JoinTable(name = "courses_teachers",
            joinColumns =
                    {
                            @JoinColumn(name = "courseid")
                    },
            inverseJoinColumns =
                    {
                            @JoinColumn(name = "teacherid")
                    })
    private Set<TeacherModel> teachers = new HashSet<>();

    //junction table representing relation between courses and students
    //TODO: implement functionality of student signing up for a course
    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                    })
    @JoinTable(name = "courses_students",
            joinColumns =
                    {
                            @JoinColumn(name = "courseid")
                    },
            inverseJoinColumns =
                    {
                            @JoinColumn(name = "studentid")
                    })
    private Set<StudentModel> students = new HashSet<>();




    //  Empty constructor for Spring and JPA purposes
    public CourseModel(){}

    //  Actual constructor used for saving to database
    public CourseModel(int courseID, String courseNameDanish, String courseNameEnglish,
                       int courseSemester, String courseStudyProgramme,
                       String courseECTS, String courseLanguage,
                       String courseLearningOutcome, boolean isMandatory)
    {
        this.courseID = courseID;
        this.courseNameDanish = courseNameDanish;
        this.courseNameEnglish = courseNameEnglish;
        this.courseSemester = courseSemester;

        this.courseStudyProgramme = courseStudyProgramme;
        this.courseECTS = courseECTS;
        this.courseLanguage = courseLanguage;

        this.courseLearningOutcome = courseLearningOutcome;

        this.stringOfTeachers = teachersToString();


        //converts a boolean to an int to store in database, aka Mandatory true or false
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

    public Set<TeacherModel> getTeachers()
    {
        return teachers;
    }

    public void setTeachers(Set<TeacherModel> teachers)
    {
        this.teachers = teachers;
    }

    public String getStringOfTeachers()
    {
        setStringOfTeachers();

        return this.stringOfTeachers;
    }

    public void setStringOfTeachers()
    {
        this.stringOfTeachers = teachersToString();
    }

    String teachersToString()
    {
        String stringOfTeachers = "";

        if(this.teachers.isEmpty())
        {
            return stringOfTeachers;
        }

        for(TeacherModel teacherModel : this.teachers)
        {
            stringOfTeachers += teacherModel.getTeacherName() + ".\n";
        }

        return stringOfTeachers;
    }
}
