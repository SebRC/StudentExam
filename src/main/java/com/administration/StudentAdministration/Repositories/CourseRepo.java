package com.administration.StudentAdministration.Repositories;

import com.administration.StudentAdministration.Models.CourseModels.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Uses JPA library to get courses
@Repository
public interface CourseRepo extends JpaRepository<CourseModel, Integer>
{
}
