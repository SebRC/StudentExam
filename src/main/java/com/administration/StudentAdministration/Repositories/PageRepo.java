package com.administration.StudentAdministration.Repositories;

import com.administration.StudentAdministration.Models.CourseModels.CourseModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepo extends PagingAndSortingRepository<CourseModel, Integer>
{
}
