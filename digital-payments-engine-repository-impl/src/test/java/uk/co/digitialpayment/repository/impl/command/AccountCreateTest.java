package uk.co.digitialpayment.repository.impl.command;

import org.jdbi.v3.core.Handle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.digitalpayment.domain.Account;
import uk.co.digitialpayment.repository.impl.dao.AccountDAO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountCreateTest {

    @Mock
    Handle mockHandle;

    @Mock
    AccountDAO mockAccountDAO;

    @Test
    void shouldFindById() {
        final Account account = Account.builder().emailAddress("bruce.lee@jeetkune.do").build();
        AccountCreate underTest = new AccountCreate(account);
        when(mockHandle.attach(AccountDAO.class)).thenReturn(mockAccountDAO);
        underTest.withHandle(mockHandle);
        verify(mockAccountDAO).insert(account);
    }

}
