package com.administration.StudentAdministration.Repositories;

import com.administration.StudentAdministration.Models.AdminModels.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<AdminModel, Integer>
{
}
