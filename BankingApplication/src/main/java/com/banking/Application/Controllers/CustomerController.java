package com.banking.Application.Controllers;

import com.banking.Application.Controllers.RequiredClasses.CustData;
import com.banking.Application.Controllers.RequiredClasses.Data;
import com.banking.Application.Controllers.RequiredClasses.GrabAddress;
import com.banking.Application.Controllers.RequiredClasses.GrabEmail;
import com.banking.Application.Model.Customer;
import com.banking.Application.Service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    service serve;

    @GetMapping("/")
    public String HomePage() {
        return "<h1> welcome to customer page</h1>";
    }

    @GetMapping("/data")
    public List<Customer> CustomerData() {

        return serve.CustomerData();
    }

    @PostMapping("/addcustomer")
    public String AddCustomer(@RequestBody Customer cust) {

        serve.saveInCustomerRepo(cust);
        return "New Customer Added";
    }

    //    lets update mobile no
    @PostMapping("/updateno")
    public boolean UpdateNumber(@RequestBody Data a) {
        return serve.UpdateNumber(a);
    }

    @PostMapping("/mydata")
    public Customer getBlah(@RequestBody CustData d) {
        return serve.getBlah(d);
    }

    @PostMapping("/updateaddress")
    public boolean updateaddress(@RequestBody GrabAddress a) {
        return serve.updateaddress(a);
    }

    @PostMapping("/updateemail")
    public boolean updateEmail(@RequestBody GrabEmail a) {
        return serve.updateEmail(a);
    }

}
