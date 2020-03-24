package uk.co.digitalpayment.merchant.infra.db;

import lombok.NoArgsConstructor;
import org.jdbi.v3.core.Jdbi;
import uk.co.digitalpayment.merchant.core.domain.Merchant;
import uk.co.digitalpayment.merchant.core.port.CanFindMerchant;
import uk.co.digitalpayment.merchant.core.port.CanRegisterMerchant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
@NoArgsConstructor
public class MerchantRepository implements CanFindMerchant, CanRegisterMerchant {

    private Jdbi jdbi;

    @Inject
    public MerchantRepository(final Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public Optional<Merchant> findByEmailAddress(final String emailAddress) {
        return Optional.empty();
    }

    @Override
    public Long registerMerchant(String name, String apiKey, String supportEmail) {
        return null;
    }

}
