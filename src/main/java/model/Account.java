package model;

import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
    private String id;
    private BigDecimal balance;

    private List<Transaction> transactions;

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        this.balance = transaction.getAmount().add(this.balance);
    }
}
