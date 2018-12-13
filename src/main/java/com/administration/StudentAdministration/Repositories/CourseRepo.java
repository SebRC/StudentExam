package com.administration.StudentAdministration.Repositories;

import com.administration.StudentAdministration.Models.CourseModels.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

//repo used for database interactions having to do with courses
@Repository
public interface CourseRepo extends JpaRepository<CourseModel, Integer>, JpaSpecificationExecutor<CourseModel>
{

}
