package com.administration.demo.Repositories;

import com.administration.demo.Models.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<TeacherModel, Integer>
{
}
