package uk.co.digitalpayment.app.api.resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.digitalpayment.app.api.model.AccountModel;
import uk.co.digitalpayment.domain.Account;
import uk.co.digitalpayment.service.AccountService;

import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountResourceTest {

    @Mock
    AccountService mockAccountService;

    @InjectMocks
    AccountResource underTest;

    @Test
    void shouldCreateAccount() {
        final Account account = Account.builder()
                .emailAddress("bruce.lee@jeetkune.do")
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .enabled(true)
                .locale(Locale.US)
                .build();

        when(mockAccountService.create()).thenReturn(account);

        final Response response = underTest.create();
        AccountModel model = (AccountModel) response.getEntity();
        assertEquals("bruce.lee@jeetkune.do", model.getEmailAddress());
        assertEquals("en-US", model.getLocale());

        verify(mockAccountService).create();
    }

}

