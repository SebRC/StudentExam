package com.administration.demo.Repositories;

import com.administration.demo.Models.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Uses JPA library to get courses
@Repository
public interface CourseRepo extends JpaRepository<CourseModel, Integer>
{
}
