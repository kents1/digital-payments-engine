package uk.co.digitialpayment.repository.impl;

import lombok.NonNull;
import org.jdbi.v3.core.Jdbi;
import uk.co.digitalpayment.domain.Account;
import uk.co.digitalpayment.repository.AccountRepository;
import uk.co.digitialpayment.repository.impl.command.AccountCreate;
import uk.co.digitialpayment.repository.impl.command.AccountFindById;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Optional;

@ApplicationScoped
public class AccountRepositoryBean implements AccountRepository {

    @Inject
    private Jdbi jdbi;

    @Override
    public Collection<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(final Long id) {
        if (id == null)
            return Optional.empty();
        return Optional.ofNullable(jdbi.withHandle(new AccountFindById(id)));
    }

    @Override
    public boolean exists(final Long id) {
        return findById(id).isPresent();
    }

    @Override
    public Long save(final Account account) {
        if (account.getId() != null && exists(account.getId())) {
            update(account);
            return account.getId();
        }
        else {
            return create(account);
        }
    }

    @Override
    public void delete(Long id) {
    }

    private void update(final Account account) {

    }

    private Long create(@NonNull final Account account) {
        return jdbi.withHandle(new AccountCreate(account));
    }

}
