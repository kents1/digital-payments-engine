package uk.co.digitialpayment.repository.impl.command;

import org.jdbi.v3.core.Handle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.digitialpayment.repository.impl.dao.AccountDAO;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountFindByIdTest {

    @Mock
    Handle mockHandle;

    @Mock
    AccountDAO mockAccountDAO;

    @Test
    void shouldFindById() {
        AccountFindById underTest = new AccountFindById(1L);
        when(mockHandle.attach(AccountDAO.class)).thenReturn(mockAccountDAO);
        underTest.withHandle(mockHandle);
        verify(mockAccountDAO).selectById(1L);
    }

}
