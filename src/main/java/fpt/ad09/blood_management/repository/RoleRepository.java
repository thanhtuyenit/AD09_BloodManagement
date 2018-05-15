package fpt.ad09.blood_management.repository;

import fpt.ad09.blood_management.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    @Query(value = "select a.name_role from role a, user b where b.username=?1 and a.id_role = b.id_role", nativeQuery = true)
    public List<String> findRoleByUsername(String username);

}