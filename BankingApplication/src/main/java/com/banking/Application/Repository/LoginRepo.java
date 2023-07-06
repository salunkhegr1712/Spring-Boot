package com.banking.Application.Repository;

import com.banking.Application.Model.LoginDatabase;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepo extends CrudRepository<LoginDatabase, Integer> {

    @Query(value = "select * from logindb where username=:username", nativeQuery = true)
    public List<LoginDatabase> searchUsername(@Param(value = "username") String username);

    @Transactional
    @Modifying
    @Query(value = "update logindb set password=:password where account_no=:account_no", nativeQuery = true)
    public void updatePassword(@Param(value = "account_no") int account_no,
                               @Param(value = "password") String password);


    @Transactional
    @Modifying
    @Query(value = "delete from logindb where logindb.account_no = :account_no", nativeQuery = true)
    public void deleteRowFromTable(@Param(value = "account_no") int account_no);

    @Query(value = "select * from logindb where logindb.username=:username", nativeQuery = true)
    public List<LoginDatabase> searchByUsername(@Param(value = "username") String username);

    @Query(value = "select password from logindb where logindb.username=:username", nativeQuery = true)
    public LoginDatabase getPasswordFromUsername(@Param(value = "username") String username);

    @Query(value = "select * from logindb where logindb.username=:username", nativeQuery = true)
    public LoginDatabase getRoleFromUsername(@Param(value = "username") String username);

    @Transactional
    @Modifying
    @Query(value = "update logindb set password=:password where logindb.username=:username", nativeQuery = true)
    public void changePassword(@Param(value = "username") String username, @Param("password") String password);
}
