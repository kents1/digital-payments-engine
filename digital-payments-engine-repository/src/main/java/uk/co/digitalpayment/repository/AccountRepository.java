package uk.co.digitalpayment.repository;

import uk.co.digitalpayment.domain.Account;

public interface AccountRepository extends Readable<Long, Account>, Updateable<Long, Account> {
}
