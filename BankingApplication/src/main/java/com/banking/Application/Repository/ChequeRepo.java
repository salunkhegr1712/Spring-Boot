package com.banking.Application.Repository;

import com.banking.Application.Model.Cheque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChequeRepo extends CrudRepository<Cheque, Integer> {
}
