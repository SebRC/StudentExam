package com.administration.StudentAdministration.Services.AdminServices;

import com.administration.StudentAdministration.Models.AdminModels.AdminModel;
import com.administration.StudentAdministration.Repositories.AdminRepo;
import com.administration.StudentAdministration.Repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void createAdmin()
    {
        AdminModel adminModel = new AdminModel("test",
                bCryptPasswordEncoder.encode("1234"), 1);

        adminModel.setRoles(new HashSet<>());

        adminModel.getRoles().add(roleRepo.getOne(2));

        adminRepo.save(adminModel);
    }

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
