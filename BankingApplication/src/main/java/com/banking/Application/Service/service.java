package com.banking.Application.Service;

import com.banking.Application.Controllers.RequiredClasses.*;
import com.banking.Application.Controllers.grabPass;
import com.banking.Application.Model.*;

import java.util.List;

public interface service {

    public List<Account> getAccountData();

    Account getMyAccountData(int mydata);

    public void saveInAccountRepo(Account cust);

    public void saveInCustomerRepo(Customer cust);

    public void saveInCheckbookRepo(CheckbookAllotment chk);

    public void saveInLoginRepo(LoginDatabase ld);

    public void saveInTransactionRepo(Transactions a);

    public void saveInAdminDB(AdminDatabase a);

    public List<Transactions> getSpecific(int idd);

    public void newRegistration(RegisterClass rc);

    public boolean deleteAccount(int acc_no);

    public List<Account> getAllPendingAccounts(String requested);

    public Customer getCustomerFromAccountNo(int acc);

    public boolean searchusername(int user);

    public void MakeAccountActive(int account_no);

    public List<AdminDatabase> getData();

    public AdminDatabase getRole(String username);

    public boolean searchusernameAdminDB(String user);

    public void deleteEntryAdminDB(int id);

    public List<CheckbookAllotment> getAllChequeData();

    public boolean checkbookAddition(int acc);

    public void updateCheckbookStatus(GrabCheckbookStatus a);

    public CheckbookAllotment getCheckbookData(int acc);

    public List<CheckbookAllotment> getRequested();

    public boolean makecheckbookactive(int acc);

    public List<Customer> CustomerData();

    public boolean UpdateNumber(Data a);

    public Customer getBlah(CustData d);

    public boolean updateaddress(GrabAddress a);

    public boolean updateEmail(GrabEmail a);

    public List<LoginDatabase> getLogins();

    public String changePassword(OBJ a);

    public boolean searchByusername(String user);

    public LoginDatabase getPassword(String username);

    public LoginDatabase getRoleLoginDB(String username);

    public boolean updatePass(grabPass m);

    public List<Transactions> getTransactionData();

    public String newTransaction(GrabTransaction a);

    public Transactions getTransactionFromId(int trId);
}
