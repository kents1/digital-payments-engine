package uk.co.digitalpayment.merchant.infra.db.cmd;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.HandleCallback;
import org.jdbi.v3.core.JdbiException;
import uk.co.digitalpayment.merchant.core.domain.Merchant;

@Value
@EqualsAndHashCode
public class FindByEmailAddress implements HandleCallback<Merchant, JdbiException> {

    private String emailAddress;

    @Override
    public Merchant withHandle(final Handle handle) throws JdbiException {
        return null;
    }

}
