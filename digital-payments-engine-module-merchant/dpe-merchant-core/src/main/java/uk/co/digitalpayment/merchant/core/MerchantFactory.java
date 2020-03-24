package uk.co.digitalpayment.merchant.core;

import lombok.NoArgsConstructor;
import uk.co.digitalpayment.merchant.core.domain.Merchant;
import uk.co.digitalpayment.merchant.core.model.MerchantModel;
import uk.co.digitalpayment.merchant.core.port.CanFindMerchant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@NoArgsConstructor
@ApplicationScoped
public class MerchantFactory {

    private CanFindMerchant canFindMerchant;

    @Inject
    public MerchantFactory(final CanFindMerchant canFindMerchant) {
        this.canFindMerchant = canFindMerchant;
    }

    public Merchant instanceFor(final MerchantModel merchantModel) {
        final Optional<Merchant> optionalMerchant = merchantModel.getMerchantCredentialModels()
                .stream()
                .flatMap(model -> canFindMerchant.findByEmailAddress(model.getEmailAddress()).stream())
                .findFirst();
        return optionalMerchant.orElse(new Merchant(merchantModel));
    }

}
