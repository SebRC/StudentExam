package com.administration.StudentAdministration.Repositories;

import com.administration.StudentAdministration.Models.RoleModels.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//repo used for database interactions having to do with roles
@Repository
public interface RoleRepo extends JpaRepository<RoleModel, Integer>
{
    String Q_GET_ALL_USERS = "select r from roles r left join fetch u.role";

    @Query(value="select r.role_name, r.role_id from roles r\n" +
            " left join students_roles sr on(r.role_id=sr.role_id)\n" +
            " left join students s on(s.id=sr.id)\n" +
            " left join teachers_roles tr on(tr.role_id=r.role_id)\n" +
            " left join teachers t on(t.id=tr.id)\n" +
            " left join admins_roles ar on(ar.role_id=r.role_id)\n" +
            " left join admins a on(a.id=ar.id) where s.username= ?1 or a.username= ?1 or t.username= ?1",
    nativeQuery = true)
    public RoleModel getRoleModelByUsername(String username);
}
