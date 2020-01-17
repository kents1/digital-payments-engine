package uk.co.digitialpayment.repository.impl.command;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.HandleCallback;
import org.jdbi.v3.core.JdbiException;
import uk.co.digitalpayment.domain.Account;
import uk.co.digitialpayment.repository.impl.dao.AccountDAO;

@Value
@EqualsAndHashCode
public class AccountFindById implements HandleCallback<Account, JdbiException> {

    private Long id;

    @Override
    public Account withHandle(final Handle handle) throws JdbiException {
        return handle.attach(AccountDAO.class).selectById(id);
    }

}
