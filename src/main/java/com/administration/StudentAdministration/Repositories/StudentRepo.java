package com.administration.StudentAdministration.Repositories;

import com.administration.StudentAdministration.Models.StudentModels.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//repo used for database interactions having to do with students
@Repository
public interface StudentRepo extends JpaRepository<StudentModel, Integer>
{
}
