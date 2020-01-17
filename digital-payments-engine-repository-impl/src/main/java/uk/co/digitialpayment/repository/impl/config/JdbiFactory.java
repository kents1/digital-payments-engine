package uk.co.digitialpayment.repository.impl.config;

import io.agroal.api.AgroalDataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.h2.H2DatabasePlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class JdbiFactory {

    @Produces
    public Jdbi getJdbiInstance(final AgroalDataSource dataSource) {
        Jdbi jdbi = Jdbi.create(dataSource);

        jdbi.installPlugins();
        jdbi.installPlugin(new H2DatabasePlugin());
        jdbi.installPlugin(new SqlObjectPlugin());

        jdbi.registerArgument(new LocaleArgumentFactory());
        jdbi.registerArgument(new RoleArgumentFactory());

        return jdbi;
    }

}
