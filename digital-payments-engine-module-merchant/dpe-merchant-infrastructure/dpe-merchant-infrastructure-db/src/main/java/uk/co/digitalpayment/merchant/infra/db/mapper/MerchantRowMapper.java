package uk.co.digitalpayment.merchant.infra.db.mapper;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import uk.co.digitalpayment.merchant.core.domain.Merchant;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MerchantRowMapper implements RowMapper<Merchant> {

    @Override
    public Merchant map(ResultSet rs, StatementContext ctx) throws SQLException {
        return null;
    }

}
