package uk.co.digitialpayment.repository.impl.mapper;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import uk.co.digitalpayment.domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Locale;

import static java.util.Optional.ofNullable;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Account(
                rs.getLong("id"),
                null,
                ofNullable(rs.getTimestamp("created")).map(Timestamp::toLocalDateTime).orElse(null),
                ofNullable(rs.getTimestamp("updated")).map(Timestamp::toLocalDateTime).orElse(null),
                rs.getBoolean("enabled"),
                rs.getString("email_address"),
                Locale.forLanguageTag(rs.getString("locale"))
        );
    }

}
