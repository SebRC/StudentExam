package com.administration.StudentAdministration.Services.AdminServices;

import com.administration.StudentAdministration.Models.AdminModels.AdminModel;
import com.administration.StudentAdministration.Repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    private AdminRepo adminRepo;

    @Override
    public AdminModel findOne(int id)
    {
        return adminRepo.getOne(id);
    }

    @Override
    public void save(AdminModel adminModel)
    {
        adminRepo.save(adminModel);
    }

    @Override
    public void deleteFromDatabase(int id)
    {
        adminRepo.deleteById(id);
    }
}
