package com.bankingsystem.ironhackproject.model.accounts;

import com.bankingsystem.ironhackproject.model.users.AccountHolder;
import com.bankingsystem.ironhackproject.model.utils.Money;
import com.bankingsystem.ironhackproject.model.utils.Status;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class StudentChecking extends Checking{
    public StudentChecking(){super();
    }

    // Constructors
    public StudentChecking(int accountId, Money balance, AccountHolder accountHolder, BigDecimal penaltyFee, Integer secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee, LocalDate creationDate, Status status) {
        super(accountId, balance, accountHolder, secretKey, minimumBalance, monthlyMaintenanceFee, creationDate, status);
    }

    public StudentChecking(AccountHolder accountHolder) {
        super(accountHolder);
    }

    // Getters & Setters
    @Override
    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = BigDecimal.ZERO;
    }

    @Override
    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = BigDecimal.ZERO;
    }

}
