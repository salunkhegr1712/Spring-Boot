package com.banking.Application.Service.implementation;

import com.banking.Application.Controllers.RequiredClasses.*;
import com.banking.Application.Controllers.grabPass;
import com.banking.Application.Model.*;
import com.banking.Application.Repository.*;
import com.banking.Application.Service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class serviceImplementation implements service {


    //    first importing all repos here
    @Autowired
    AccountRepo accountRepo;

    @Autowired
    LoginRepo lgRepo;

    @Autowired
    CustomerRepo custRepo;

    @Autowired
    CheckbookRepo chRepo;

    @Autowired
    AdminDbRepo adrepo;

    @Autowired
    TransactionRepository trRepo;
    private int trId;

    @Override
    public List<Account> getAccountData() {
        return (List<Account>) accountRepo.findAll();
    }

    @Override
    public Account getMyAccountData(int mydata) {
        return accountRepo.getAccountDetails(mydata);
    }

    @Override
    public void saveInAccountRepo(Account cust) {
        accountRepo.save(cust);
    }

    @Override
    public List<Transactions> getSpecific(int idd) {
        List<Transactions> a = accountRepo.getAccountDetails(idd).getTransactions();

        if (a.size() == 0) {
            return new ArrayList<>();
        }
        return a;
    }

    @Override
    public void newRegistration(RegisterClass rc) {
        accountRepo.save(rc.account);
        LoginDatabase s = new LoginDatabase();
        s.setAccount_no(rc.account);
        s.setPassword(rc.password);
        s.setUsername(rc.username);
        s.setRole(rc.role);
        lgRepo.save(s);
    }

    @Override
    public boolean deleteAccount(int acc_no) {
        accountRepo.func1();
        custRepo.deleteRowFromTable(accountRepo.getCustomerIdFromAccount(acc_no));
        lgRepo.deleteRowFromTable(acc_no);
//        chr.deleteRowFromTable(acc_no);
        accountRepo.deleteRowFromTable(acc_no);
        accountRepo.func2();
        return true;
    }

    @Override
    public List<Account> getAllPendingAccounts(String requested) {
        return accountRepo.getAccountsByStatus(requested);
    }

    @Override
    public Customer getCustomerFromAccountNo(int acc) {
        return custRepo.getDataByCustomerId(accountRepo.getCustomerIdFromAccount(acc));
    }

    @Override
    public boolean searchusername(int user) {
        try {
            Account a = accountRepo.searchByUsername(user).get(0);
            return false;
        } catch (Exception a) {
            return true;
        }
    }

    @Override
    public void MakeAccountActive(int account_no) {
        accountRepo.updateAccountStatus(account_no, "active");
    }

    @Override
    public void saveInCustomerRepo(Customer cust) {
        custRepo.save(cust);
    }

    @Override
    public void saveInCheckbookRepo(CheckbookAllotment chk) {
        chRepo.save(chk);
    }

    @Override
    public void saveInLoginRepo(LoginDatabase ld) {
        lgRepo.save(ld);
    }

    @Override
    public void saveInTransactionRepo(Transactions a) {
        trRepo.save(a);
    }

    @Override
    public void saveInAdminDB(AdminDatabase a) {
        adrepo.save(a);
    }

    @Override
    public List<AdminDatabase> getData() {
        return (List<AdminDatabase>) adrepo.findAll();
    }

    public AdminDatabase getRole(String username) {
        return adrepo.getRoleFromUsername(username);
    }

    @Override
    public boolean searchusernameAdminDB(String user) {
        try {
            AdminDatabase a = adrepo.searchByUsername(user).get(0);
            return false;
        } catch (Exception a) {
            return true;
        }
    }

    @Override
    public void deleteEntryAdminDB(int id) {
        adrepo.DeleteStaff(id);
    }

    @Override
    public List<CheckbookAllotment> getAllChequeData() {
        return (List<CheckbookAllotment>) chRepo.findAll();
    }

    @Override
    public boolean checkbookAddition(int acc) {
        chRepo.addCheckBookEntry(acc);
        return true;
    }

    @Override
    public void updateCheckbookStatus(GrabCheckbookStatus a) {
        chRepo.updateCheckbookStatus(a.account_no, a.status);
    }

    @Override
    public CheckbookAllotment getCheckbookData(int acc) {
        return chRepo.getDetailsFromAccountNO(acc);
    }

    @Override
    public List<CheckbookAllotment> getRequested() {
        return chRepo.getRequested();
    }

    @Override
    public boolean makecheckbookactive(int acc) {
        chRepo.makeAccountActive(acc);
        return true;
    }

    @Override
    public List<Customer> CustomerData() {
        return (List<Customer>) custRepo.findAll();
    }

    @Override
    public boolean UpdateNumber(Data a) {
        try {
            custRepo.updateNumber(a.id, a.b);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Customer getBlah(CustData d) {
        return custRepo.getDataByCustomerId((d.customer_id));
    }

    @Override
    public boolean updateaddress(GrabAddress a) {
        try {
            custRepo.updateAddress(a.customer_id, a.address, a.pincode, a.city);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateEmail(GrabEmail a) {
        try {
            custRepo.updateEmail(a.customer_id, a.email);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<LoginDatabase> getLogins() {
        return (List<LoginDatabase>) lgRepo.findAll();
    }

    @Override
    public String changePassword(OBJ a) {
        List<LoginDatabase> c = lgRepo.searchUsername(a.username);
        if (c.size() == 0) {
            return "data not found";
        }
        lgRepo.updatePassword(c.get(0).getAccount_no(), a.newpass);
        return "data found and updated successfulley";
    }

    @Override
    public boolean searchByusername(String user) {
        try {
            LoginDatabase a = lgRepo.searchByUsername(user).get(0);
            return false;
        } catch (Exception a) {
            return true;
        }
    }

    @Override
    public LoginDatabase getPassword(String username) {
        try {
            return lgRepo.getPasswordFromUsername(username);
        } catch (Exception e) {
            return new LoginDatabase();
        }
    }

    @Override
    public LoginDatabase getRoleLoginDB(String username) {
        return lgRepo.getRoleFromUsername(username);
    }

    @Override
    public boolean updatePass(grabPass m) {
        lgRepo.changePassword(m.username, m.password);
        return true;
    }

    @Override
    public List<Transactions> getTransactionData() {
        return (List<Transactions>) trRepo.findAll();
    }

    @Override
    public String newTransaction(GrabTransaction a) {
        trId = (int) Math.floor(Math.random() * (2147483647 - 10000000 + 1) + 10000000);
        trRepo.setTransactionValues(trId, a.source_account_no, a.amount, a.target_account_no, a.type, a.date);

        accountRepo.updateAccountBalanceUsingAccountNO(accountRepo.getAccountDetails(a.source_account_no).getAccount_balance() - a.amount, a.source_account_no);

        trId = (int) Math.floor(Math.random() * (2147483647 - 10000000 + 1) + 10000000);
        trRepo.setTransactionValues(trId, a.target_account_no, a.amount, a.source_account_no, "deposit", a.date);
        accountRepo.updateAccountBalanceUsingAccountNO(accountRepo.getAccountDetails(a.target_account_no).getAccount_balance() + a.amount, a.target_account_no);
        return "transaction take placed successfulley";
    }

    @Override
    public Transactions getTransactionFromId(int trId) {
        return trRepo.getTransactionById(trId);
    }
}
