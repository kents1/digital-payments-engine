package uk.co.digitialpayment.repository.impl;

import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.digitalpayment.domain.Account;
import uk.co.digitialpayment.repository.impl.command.AccountCreate;
import uk.co.digitialpayment.repository.impl.command.AccountFindById;

import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountRepositoryBeanTest {

    @Mock
    Jdbi mockJdbi;

    @InjectMocks
    AccountRepositoryBean underTest;

    @Test
    void shouldFindAccountById() {
        Long id = 1L;

        when(mockJdbi.withHandle(new AccountFindById(id)))
                .thenReturn(Account.builder().build());

        underTest.findById(id);

        verify(mockJdbi).withHandle(new AccountFindById(1L));
    }

    @Test
    void shouldReturnEmptyOptionalWhenIdIsNull() {
        Optional<Account> accountOpt = underTest.findById(null);
        assertTrue(accountOpt.isEmpty());
    }

    @Test
    void shouldReturnTrueWhenAccountExists() {
        final Long id = 1L;
        when(mockJdbi.withHandle(new AccountFindById(id)))
                .thenReturn(Account.builder().id(id).build());
        assertTrue(underTest.exists(id));
    }

    @Test
    void shouldReturnFalseWhenAccountDoesNotExist() {
        final Long id = 1L;
        when(mockJdbi.withHandle(new AccountFindById(id)))
                .thenReturn(null);
        assertFalse(underTest.exists(id));
    }

    @Test
    void shouldCreateAccountWhenNonExisting() {
        final Account account = Account.builder()
                .emailAddress("bruce.lee@jeetkune.do")
                .enabled(true)
                .locale(Locale.UK).build();
        underTest.save(account);
        verify(mockJdbi).withHandle(new AccountCreate(account));
        verifyNoMoreInteractions(mockJdbi);
    }

}
