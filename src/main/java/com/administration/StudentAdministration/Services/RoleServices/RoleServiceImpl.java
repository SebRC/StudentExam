package com.administration.StudentAdministration.Services.RoleServices;

import com.administration.StudentAdministration.Models.RoleModels.RoleModel;
import com.administration.StudentAdministration.Repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//service implementation used for database interaction having to do with roles
@Service
public class RoleServiceImpl implements RoleService
{
    //repo for interaction with database
    @Autowired
    private RoleRepo roleRepo;

    //method for retrieving one role based on id
    @Override
    public RoleModel findOne(int id)
    {
        return roleRepo.getOne(id);
    }

    public RoleModel getActiveUserRole(String username)
    {
        return roleRepo.getRoleModelByUsername(username);
    }
}
