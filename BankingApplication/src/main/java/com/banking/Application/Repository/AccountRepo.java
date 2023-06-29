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



    @Transactional
    @Modifying
    @Query(value = "SET FOREIGN_KEY_CHECKS=0",nativeQuery = true)
    public void func1();

    @Transactional
    @Modifying
    @Query(value = "SET FOREIGN_KEY_CHECKS=1",nativeQuery = true)
    public void func2();

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

    @Transactional
    @Modifying
    @Query(value = "delete from account where account.account_no = :account_no",nativeQuery = true)
    public void deleteRowFromTable(@Param(value = "account_no") int account_no);

//    delete customer_linked to that
    @Query(value = "select customer_id from account where account.account_no=:account_no ",nativeQuery = true)
    public int getCustomerIdFromAccount(@Param(value = "account_no") int account_no);
}
