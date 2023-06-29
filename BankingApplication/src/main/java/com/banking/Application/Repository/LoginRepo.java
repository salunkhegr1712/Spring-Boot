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
public interface LoginRepo extends CrudRepository<LoginDatabase,Integer> {

    @Query(value = "select * from logindb where username=:username",nativeQuery = true)
    public List<LoginDatabase> searchUsername(@Param(value = "username") String username);
    @Transactional
    @Modifying
    @Query(value = "update logindb set password=:password where account_no=:account_no",nativeQuery = true)
    public void updatePassword(@Param(value = "account_no") int account_no,
                                @Param(value="password") String password);


}
