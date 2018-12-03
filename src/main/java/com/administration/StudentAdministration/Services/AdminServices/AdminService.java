package com.administration.StudentAdministration.Services.AdminServices;

import com.administration.StudentAdministration.Models.AdminModels.AdminModel;

public interface AdminService
{
    AdminModel findOne(int id);

    void save(AdminModel adminModel);

    void deleteFromDatabase(int id);
}
