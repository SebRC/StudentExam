package com.administration.StudentAdministration.Repositories;

import com.administration.StudentAdministration.Models.RoleModels.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//repo used for database interactions having to do with roles
@Repository
public interface RoleRepo extends JpaRepository<RoleModel, Integer>
{
}
