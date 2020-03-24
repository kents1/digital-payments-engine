package uk.co.digitalpayment.sharedkernel.infra.config;

import org.jdbi.v3.core.argument.AbstractArgumentFactory;
import org.jdbi.v3.core.argument.Argument;
import org.jdbi.v3.core.config.ConfigRegistry;

import java.sql.Types;
import java.util.Locale;

public class LocaleArgumentFactory extends AbstractArgumentFactory<Locale> {

    public LocaleArgumentFactory() {
        super(Types.CHAR);
    }

    @Override
    protected Argument build(Locale value, ConfigRegistry config) {
        return (position, statement, ctx) -> statement.setString(position, value.toLanguageTag());
    }

}
