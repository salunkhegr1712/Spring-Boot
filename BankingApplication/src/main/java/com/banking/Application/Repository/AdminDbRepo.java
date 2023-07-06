package com.banking.Application.Repository;

import com.banking.Application.Model.AdminDatabase;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDbRepo extends CrudRepository<AdminDatabase, Integer> {

    @Query(value = "select * from admindb where admindb.username=:username", nativeQuery = true)
    public List<AdminDatabase> searchByUsername(@Param(value = "username") String username);

    @Query(value = "select password from admindb where admindb.username=:username", nativeQuery = true)
    public AdminDatabase getPasswordFromUsername(@Param(value = "username") String username);

    @Query(value = "select * from admindb where admindb.username=:username", nativeQuery = true)
    public AdminDatabase getRoleFromUsername(@Param(value = "username") String username);

    @Transactional
    @Modifying
    @Query(value = "delete from admindb where admin_id=:admin_id", nativeQuery = true)
    public void DeleteStaff(@Param(value = "admin_id") int admin_id);
}
