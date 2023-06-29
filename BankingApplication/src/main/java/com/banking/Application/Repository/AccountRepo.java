package com.banking.Application.Repository;

import com.banking.Application.Model.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends CrudRepository<Account, Integer> {

    @Query(value = "select * from account where account_no =:account_no", nativeQuery = true)
    public Account getAccountDetails(@Param(value = "account_no") int account_no);

    @Transactional
    @Modifying
    @Query(value = "update account a set a.account_balance=:account_balance where a.customer_id=:customer_id", nativeQuery = true)
    public void updateAccountBalanceUsingCustomerId(@Param(value = "account_balance") double account_balance, @Param(value = "customer_id") int customer_id);

    @Transactional
    @Modifying
    @Query(value = "update account a set a.account_balance=:account_balance where a.account_no=:account_no", nativeQuery = true)
    public void updateAccountBalanceUsingAccountNO(@Param(value = "account_balance") double account_balance, @Param(value = "account_no") int account_no);

}
