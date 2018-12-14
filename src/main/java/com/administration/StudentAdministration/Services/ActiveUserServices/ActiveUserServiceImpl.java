package com.administration.StudentAdministration.Services.ActiveUserServices;

import com.administration.StudentAdministration.Models.RoleModels.RoleModel;
import com.administration.StudentAdministration.Services.RoleServices.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//service implementation used for retrieving details about active user from database
//TODO: implement functionality for retreiving roles from database based on active users username
@Service
public class ActiveUserServiceImpl implements ActiveUserService
{
    @Autowired
    private RoleServiceImpl roleService;

    public RoleModel getActiveUserRole(String username)
    {
        return roleService.getActiveUserRole(username);
    }
}
