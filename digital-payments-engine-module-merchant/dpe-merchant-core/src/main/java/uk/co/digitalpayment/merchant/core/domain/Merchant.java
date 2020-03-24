package uk.co.digitalpayment.merchant.core.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import uk.co.digitalpayment.merchant.core.exception.MerchantAlreadyRegisteredException;
import uk.co.digitalpayment.merchant.core.model.MerchantModel;
import uk.co.digitalpayment.merchant.core.port.CanRegisterMerchant;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class Merchant {

    private Long id;
    private String name;
    private String apiKey;
    private String supportEmail;

    public Merchant(final MerchantModel merchantModel) {
        this.id = merchantModel.getId();
        this.name = merchantModel.getName();
        this.apiKey = merchantModel.getApiKey();
        this.supportEmail = merchantModel.getSupportEmail();
    }

    public Long registerUsing(final CanRegisterMerchant canRegisterMerchant) throws MerchantAlreadyRegisteredException {
        if (Objects.nonNull(this.id))
            throw new MerchantAlreadyRegisteredException();
        this.id = canRegisterMerchant.registerMerchant(this.name, this.apiKey, this.supportEmail);
        return this.id;
    }

}
