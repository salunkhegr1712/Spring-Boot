package com.banking.Application.Repository;

import com.banking.Application.Model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {
    //    this function will help us modify mobile number

    @Query(value = "select * from customer where customer_id=:customer_id", nativeQuery = true)
    Customer getDataByCustomerId(@Param(value = "customer_id") Integer customer_id);

    @Query(value = "SELECT * FROM customer;", nativeQuery = true)
    List<Customer> findAllUsers();

    @Transactional
    @Modifying
    @Query(value = "delete from customer where customer.customer_id = :customer_id", nativeQuery = true)
    public void deleteRowFromTable(@Param(value = "customer_id") int customer_id);

    @Query(value = "select name from customer where customer_id=:customer_id", nativeQuery = true)
    Customer getNameFromCustomerId(@Param(value = "customer_id") Integer customer_id);

    @Transactional
    @Modifying
    @Query(value = "update customer  set mobileno = :mobileno where customer_id = :customer_id", nativeQuery = true)
    void updateNumber(@Param(value = "customer_id") int customer_id, @Param(value = "mobileno") String mobileno);

    @Transactional
    @Modifying
    @Query(value = "update customer  set email = :email where customer_id = :customer_id", nativeQuery = true)
    void updateEmail(@Param(value = "customer_id") int customer_id, @Param(value = "email") String email);

    @Transactional
    @Modifying
    @Query(value = "update customer  set address = :address,city=:city,pincode=:pincode where customer_id = :customer_id", nativeQuery = true)
    void updateAddress(@Param(value = "customer_id") int customer_id,
                       @Param(value = "address") String address,
                       @Param(value = "pincode") int pincode,
                       @Param(value = "city") String city);

}
