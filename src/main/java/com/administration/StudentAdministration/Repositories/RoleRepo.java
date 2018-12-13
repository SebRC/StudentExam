package com.administration.StudentAdministration.Repositories;

import com.administration.StudentAdministration.Models.RoleModels.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleModel, Integer>
{
    //RoleModel findByRole_name(String role_name);

    //RoleModel findRoleByRole_name(String roleName);

}
