package com.administration.StudentAdministration.Services.RoleServices;

import com.administration.StudentAdministration.Models.RoleModels.RoleModel;

//interface of service used for database interaction having to do with courses
public interface RoleService
{
    RoleModel findOne(int id);

}
