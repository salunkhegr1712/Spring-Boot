package com.banking.Application.Repository;

import com.banking.Application.Model.CheckbookAllotment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckbookRepo extends CrudRepository<CheckbookAllotment, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update checkbooks u set u.status =:status where u.account_no=:account_no", nativeQuery = true)
    void updateCheckbookStatus(@Param(value = "account_no") int account_no, @Param(value = "status") String status);

}
