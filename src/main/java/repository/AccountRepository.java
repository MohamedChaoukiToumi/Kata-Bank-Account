package repository;


import service.StatementPrinter;

import java.math.BigDecimal;

public class AccountRepository {


    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;

    public AccountRepository(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(BigDecimal amount) {
        transactionRepository.addDeposit(amount);
    }

    public void withdraw(BigDecimal amount) {
        transactionRepository.addWithdrawal(amount);
    }

    public void printStatement() {
        statementPrinter.print(transactionRepository.allTransactions());
    }


}
