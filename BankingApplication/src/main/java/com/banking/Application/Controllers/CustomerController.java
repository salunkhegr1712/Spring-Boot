package com.banking.Application.Controllers;

import com.banking.Application.Controllers.RequiredClasses.CustData;
import com.banking.Application.Controllers.RequiredClasses.Data;
import com.banking.Application.Model.Customer;
import com.banking.Application.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepo custRepo;

    @GetMapping("/")
    public String HomePage() {
        return "<h1> welcome to customer page</h1>";
    }

    @GetMapping("/data")
    public List<Customer> CustomerData() {

        return (List<Customer>) custRepo.findAll();
    }

    @PostMapping("/addcustomer")
    public String AddCustomer(@RequestBody Customer cust) {

        custRepo.save(cust);
        return "New Customer Added";
    }

    //    lets update mobile no
    @PostMapping("/updateno")
    public String UpdateNumber(@RequestBody Data a) {
        custRepo.updateNumber(a.id, a.b);
        return "mobile number updated successfulley";
    }

    @PostMapping("/mydata")
    public Customer getBlah(@RequestBody CustData d) {
        return custRepo.getDataByCustomerId((d.customer_id));
    }


}
