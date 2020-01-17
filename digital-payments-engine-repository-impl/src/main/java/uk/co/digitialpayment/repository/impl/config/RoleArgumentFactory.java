package uk.co.digitialpayment.repository.impl.config;

import org.jdbi.v3.core.argument.AbstractArgumentFactory;
import org.jdbi.v3.core.argument.Argument;
import org.jdbi.v3.core.config.ConfigRegistry;
import uk.co.digitalpayment.domain.Role;

import java.sql.Types;

public class RoleArgumentFactory extends AbstractArgumentFactory<Role> {

    public RoleArgumentFactory() {
        super(Types.CHAR);
    }

    @Override
    protected Argument build(Role value, ConfigRegistry config) {
        return (position, statement, ctx) -> statement.setString(position, value.getType());
    }

}
