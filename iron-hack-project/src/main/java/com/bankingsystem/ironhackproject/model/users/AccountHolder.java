package com.bankingsystem.ironhackproject.model.users;

import com.bankingsystem.ironhackproject.ConfigSecurity.model.User;
import com.bankingsystem.ironhackproject.model.accounts.Account;
import com.bankingsystem.ironhackproject.model.utils.Address;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;

@Entity
@Table(name="account_holder")
public class AccountHolder extends User {
    private String name;
    private Date dateOfBirth;
    @Nullable
    private String mailingAddress;
    @Embedded
    private Address primaryAddress;
    @OneToOne
    private Account account;

    public AccountHolder(){}

    public AccountHolder(String name){
        setName(name);
    }

    public AccountHolder(String name, Date dateOfBirth, @Nullable String mailingAddress, Address primaryAddress, Account account) {
        this.dateOfBirth = dateOfBirth;
        setName(name);
        setPrimaryAddress(primaryAddress);
        setDateOfBirth(dateOfBirth);
        setMailingAddress(mailingAddress);
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address address) {
        this.primaryAddress = primaryAddress;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Nullable
    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(@Nullable String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}