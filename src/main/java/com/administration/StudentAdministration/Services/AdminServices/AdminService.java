package com.administration.StudentAdministration.Services.AdminServices;

import com.administration.StudentAdministration.Models.AdminModels.AdminModel;

//interface for service used for retrieving details about admins from database
public interface AdminService
{
    AdminModel findOne(int id);

    void save(AdminModel adminModel);

    void deleteFromDatabase(int id);
}
