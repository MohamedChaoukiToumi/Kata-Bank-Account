
import fixtures.AccountFixture;
import model.Account;
import model.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.AccountRepository;
import repository.TransactionRepository;
import service.ClockService;
import service.StatementPrinter;

import java.math.BigDecimal;
import static service.StatementPrinter.STATEMENT_HEADER;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
public class ValidationTest {

    @Mock
    ClockService clockService;
    @Mock
    Console console;

    private AccountRepository accountRepository;
    private Account account;

    @BeforeEach
    public void init() {
        account = AccountFixture.getAccount();
        TransactionRepository transactionRepository = new TransactionRepository(account, clockService);
        StatementPrinter statementPrinter = new StatementPrinter(console);
        accountRepository = new AccountRepository(transactionRepository, statementPrinter);
    }

    @Test
    public void test_print_all_transaction_statement() {
        given(clockService.now()).willReturn("17/04/2021", "23/04/2021", "17/05/2021");
        accountRepository.deposit(BigDecimal.valueOf(500));
        accountRepository.withdraw(BigDecimal.valueOf(200));
        accountRepository.deposit(BigDecimal.valueOf(1000));

        accountRepository.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine(STATEMENT_HEADER);
        inOrder.verify(console).printLine("17/05/2021 | 1000 | 1300");
        inOrder.verify(console).printLine("23/04/2021 | -200 | 300");
        inOrder.verify(console).printLine("17/04/2021 | 500 | 500");
    }
}
