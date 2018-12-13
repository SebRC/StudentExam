package com.administration.StudentAdministration.Services.AdminServices;

import com.administration.StudentAdministration.Models.AdminModels.AdminModel;
import com.administration.StudentAdministration.Repositories.AdminRepo;
import com.administration.StudentAdministration.Services.RoleServices.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

//service implementation used for retrieving details about admins from database
@Service
public class AdminServiceImpl implements AdminService
{
    //repositories and password encoder needed to perform functionality
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //test method for creating an admin in database
    public void createAdmin()
    {
        AdminModel adminModel = new AdminModel("test",
                bCryptPasswordEncoder.encode("1234"), 1);

        adminModel.setRoles(new HashSet<>());

        adminModel.getRoles().add(roleService.findOne(2));

        adminRepo.save(adminModel);
    }

    //methods for retreiving, saving and deleting an admin from database
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
