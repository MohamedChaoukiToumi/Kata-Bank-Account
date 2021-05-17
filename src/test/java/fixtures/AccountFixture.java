package fixtures;


import model.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

public class AccountFixture {

    public static Account getAccount(){
        return Account.builder().id(UUID.randomUUID().toString()).balance(BigDecimal.ZERO).
                transactions(new ArrayList<>()).build();
    }
}
