package com.administration.StudentAdministration.Repositories;

import com.administration.StudentAdministration.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>
{
    //Role findByRole_name(String role_name);

    //Role findRoleByRole_name(String roleName);

}
