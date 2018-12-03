package com.administration.StudentAdministration.Repositories;

import com.administration.StudentAdministration.Models.TeacherModels.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<TeacherModel, Integer>
{
}
