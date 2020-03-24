package uk.co.digitalpayment.merchant.core.port;

import uk.co.digitalpayment.merchant.core.domain.Merchant;

import java.util.Optional;

public interface CanFindMerchant {

    Optional<Merchant> findByEmailAddress(String emailAddress);

}
