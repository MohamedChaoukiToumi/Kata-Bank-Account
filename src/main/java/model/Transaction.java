package model;



import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Builder
@Getter
@Setter
public class Transaction {
    private String date;
    private BigDecimal amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction tr = (Transaction) o;
        return Objects.equals(date, tr.date) &&
                Objects.equals(amount, tr.amount);
    }


}

