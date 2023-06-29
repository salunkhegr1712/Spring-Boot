package com.banking.Application.Repository;

import com.banking.Application.Model.Transactions;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transactions, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into transactions (transaction_id,source_account_no,transaction_amount,target_account_no,type,date) values (:transaction_id,:account_no,:transaction_amount,:target_account_no,:type,:date);", nativeQuery = true)
    public void setTransactionValues(
            @Param(value = "transaction_id") int transaction_id,
            @Param(value = "account_no") int account_no,
            @Param(value = "transaction_amount") double transaction_amount,
            @Param(value = "target_account_no") int target_account_no,
            @Param(value = "type") String type,
            @Param(value = "date") String date
    );

    @Query(value = "select * from transactions where transaction_id=:transaction_id", nativeQuery = true)
    public Transactions getTransactionById(@Param(value = "transaction_id") int transaction_id);
}
