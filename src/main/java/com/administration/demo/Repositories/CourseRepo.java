package com.administration.demo.Repositories;

import com.administration.demo.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepo extends JpaRepository<Course, Integer>
{
}
