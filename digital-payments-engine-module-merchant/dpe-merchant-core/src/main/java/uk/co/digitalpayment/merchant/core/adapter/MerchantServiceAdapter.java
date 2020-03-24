package uk.co.digitalpayment.merchant.core.adapter;

import uk.co.digitalpayment.merchant.core.exception.MerchantAlreadyRegisteredException;
import uk.co.digitalpayment.merchant.core.model.MerchantModel;
import uk.co.digitalpayment.merchant.core.port.CanRegisterMerchant;
import uk.co.digitalpayment.merchant.core.MerchantFactory;
import uk.co.digitalpayment.merchant.core.port.MerchantService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MerchantServiceAdapter implements MerchantService {

    private MerchantFactory merchantFactory;
    private CanRegisterMerchant canRegisterMerchant;

    @Inject
    public MerchantServiceAdapter(final MerchantFactory merchantFactory,
                                  final CanRegisterMerchant canRegisterMerchant) {
        this.merchantFactory = merchantFactory;
        this.canRegisterMerchant = canRegisterMerchant;
    }

    @Override
    public Long registerMerchant(final MerchantModel merchantModel) throws MerchantAlreadyRegisteredException {
        return merchantFactory.instanceFor(merchantModel).registerUsing(canRegisterMerchant);
    }

}
