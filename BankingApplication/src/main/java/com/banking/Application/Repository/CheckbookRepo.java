package com.banking.Application.Repository;

import com.banking.Application.Model.CheckbookAllotment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckbookRepo extends CrudRepository<CheckbookAllotment, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update checkbooks u set u.status =:status where u.account_no=:account_no", nativeQuery = true)
    void updateCheckbookStatus(@Param(value = "account_no") int account_no, @Param(value = "status") String status);

    @Transactional
    @Modifying
    @Query(value = "delete from checkbooks where checkbooks.account_no = :account_no", nativeQuery = true)
    public void deleteRowFromTable(@Param(value = "account_no") int account_no);

    @Query(value = "select * from checkbooks where account_no=:account_no", nativeQuery = true)
    public CheckbookAllotment getDetailsFromAccountNO(@Param(value = "account_no") int account_no);

    @Query(value = "select * from checkbooks where status=\"requested\"", nativeQuery = true)
    public List<CheckbookAllotment> getRequested();

    @Transactional
    @Modifying
    @Query(value = "insert into checkbooks (account_no,status) values(:account_no,\"requested\");", nativeQuery = true)
    public void addCheckBookEntry(@Param(value = "account_no") int account_no);

    @Transactional
    @Modifying
    @Query(value = "update checkbooks set status=\"active\" where account_no=:account_no ", nativeQuery = true)
    public void makeAccountActive(@Param(value = "account_no") int account_no);
}
