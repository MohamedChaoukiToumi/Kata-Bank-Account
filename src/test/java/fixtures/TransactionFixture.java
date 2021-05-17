package fixtures;


import model.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionFixture {

    private final static String TODAY = "17/05/2021";

    public static Transaction getDepositTransaction() {
        return Transaction.builder().date(TODAY).amount(BigDecimal.valueOf(500)).build();
    }

    public static Transaction getWithDrawTransaction() {
        return Transaction.builder().date(TODAY).amount(BigDecimal.valueOf(-500)).build();
    }

    public static List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(Transaction.builder().date("17/04/2021").amount(BigDecimal.valueOf(500)).build());
        transactions.add(Transaction.builder().date("23/04/2021").amount(BigDecimal.valueOf(-200)).build());
        transactions.add(Transaction.builder().date("17/05/2021").amount(BigDecimal.valueOf(1000)).build());
        return transactions;
    }
}