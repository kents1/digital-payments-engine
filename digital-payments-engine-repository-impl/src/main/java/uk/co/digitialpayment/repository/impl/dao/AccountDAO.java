package uk.co.digitialpayment.repository.impl.dao;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import uk.co.digitalpayment.domain.Account;
import uk.co.digitialpayment.repository.impl.mapper.AccountRowMapper;

public interface AccountDAO {

    @SqlQuery(AccountSQL.SELECT_BY_ID)
    @RegisterRowMapper(AccountRowMapper.class)
    Account selectById(@Bind("id") Long id);

    @SqlUpdate(AccountSQL.INSERT)
    @GetGeneratedKeys
    Long insert(@BindBean Account account);

}
