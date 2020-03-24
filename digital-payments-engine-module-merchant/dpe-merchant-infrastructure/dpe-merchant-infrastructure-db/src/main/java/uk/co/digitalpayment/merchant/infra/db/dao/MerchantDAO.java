package uk.co.digitalpayment.merchant.infra.db.dao;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import uk.co.digitalpayment.merchant.core.domain.Merchant;
import uk.co.digitalpayment.merchant.infra.db.mapper.MerchantRowMapper;

import java.util.Optional;

public interface MerchantDAO {

    @SqlQuery(MerchantSQL.SELECT_BY_EMAIL_ADDRESS)
    @RegisterRowMapper(MerchantRowMapper.class)
    Optional<Merchant> selectByEmailAddress(final String emailAddress);

}
