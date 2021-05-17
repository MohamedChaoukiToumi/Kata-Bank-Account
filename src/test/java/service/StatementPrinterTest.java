package service;



import fixtures.TransactionFixture;
import model.Console;
import model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StatementPrinterTest {

    private static final List<Transaction> NO_TRANSACTIONS = Collections.emptyList();
    public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    @Mock
    Console console;
    StatementPrinter statementPrinter;

    @BeforeEach
    public void init(){
        statementPrinter = new StatementPrinter(console);
    }
    @Test
    public void test_header_printing() {
        statementPrinter.print(NO_TRANSACTIONS);
        verify(console).printLine(STATEMENT_HEADER);
    }

    @Test
    public void test_transactions_printing() {
        statementPrinter.print(TransactionFixture.getTransactions());

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine(STATEMENT_HEADER);
        inOrder.verify(console).printLine("17/05/2021 | 1000 | 1300");
        inOrder.verify(console).printLine("23/04/2021 | -200 | 300");
        inOrder.verify(console).printLine("17/04/2021 | 500 | 500");
    }
}
