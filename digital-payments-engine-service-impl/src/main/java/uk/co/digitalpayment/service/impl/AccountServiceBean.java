package uk.co.digitalpayment.service.impl;

import uk.co.digitalpayment.domain.Account;
import uk.co.digitalpayment.domain.Role;
import uk.co.digitalpayment.repository.AccountRepository;
import uk.co.digitalpayment.service.AccountService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Locale;

@ApplicationScoped
public class AccountServiceBean implements AccountService {

    @Inject
    AccountRepository accountRepository;

    @Override
    public Account create() {
        final Long accountId = accountRepository.save(
                Account.builder()
                        .emailAddress("bruce.lee@jeetkune.do")
                        .locale(Locale.UK)
                        .role(new Role("CLIENT", true))
                        .enabled(true)
                        .build());
        return accountRepository.findById(accountId)
                .orElseThrow(RuntimeException::new);
    }

}
