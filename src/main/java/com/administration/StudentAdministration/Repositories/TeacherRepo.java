package com.administration.StudentAdministration.Repositories;

import com.administration.StudentAdministration.Models.TeacherModels.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//repo used for database interactions having to do with teachers
@Repository
public interface TeacherRepo extends JpaRepository<TeacherModel, Integer>
{
}


