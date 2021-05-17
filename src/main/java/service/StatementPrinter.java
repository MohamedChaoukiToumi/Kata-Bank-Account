package service;


import model.Account;
import model.Console;
import model.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {

    public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private Console console;
    private Account account;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printLine(STATEMENT_HEADER);
        printStatementLines(transactions);
    }

    private void printStatementLines(List<Transaction> transactions) {
        AtomicInteger runningBalance = new AtomicInteger(0);
        transactions.stream()
                .map(transaction -> statementLine(transaction, runningBalance))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::printLine);
    }

    private String statementLine(Transaction transaction, AtomicInteger balance) {
        return transaction.getDate()
                + " | "
                + transaction.getAmount() +
                " | "
                + balance.addAndGet(transaction.getAmount().intValue());
    }
}

