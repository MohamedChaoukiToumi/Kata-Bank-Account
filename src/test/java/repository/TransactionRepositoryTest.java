package repository;



import fixtures.AccountFixture;
import fixtures.TransactionFixture;
import model.Account;
import model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.ClockService;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TransactionRepositoryTest {

    public static final String TODAY = "17/05/2021";
    private TransactionRepository transactionRepository;
    @Mock
    ClockService clockService;

    @BeforeEach
    public void init() {
        Account account = AccountFixture.getAccount();
        transactionRepository = new TransactionRepository(account, clockService);
    }

    @Test
    public void test_create_deposit_transaction() {
        given(clockService.now()).willReturn(TODAY);
        transactionRepository.addDeposit(BigDecimal.valueOf(500));
        List<Transaction> transactions = transactionRepository.allTransactions();
        assertEquals(1, transactions.size());
        assertEquals(TransactionFixture.getDepositTransaction(), transactions.get(0));
    }

    @Test
    public void test_create_withdraw_transaction() {
        given(clockService.now()).willReturn(TODAY);
        transactionRepository.addWithdrawal(BigDecimal.valueOf(500));
        List<Transaction> transactions = transactionRepository.allTransactions();
        assertEquals(1, transactions.size());
        assertEquals(TransactionFixture.getWithDrawTransaction(), transactions.get(0));
    }

}
