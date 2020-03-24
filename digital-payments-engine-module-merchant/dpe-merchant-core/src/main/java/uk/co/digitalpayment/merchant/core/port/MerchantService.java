package uk.co.digitalpayment.merchant.core.port;

import uk.co.digitalpayment.merchant.core.exception.MerchantAlreadyRegisteredException;
import uk.co.digitalpayment.merchant.core.model.MerchantModel;

public interface MerchantService {

    Long registerMerchant(MerchantModel merchantModel) throws MerchantAlreadyRegisteredException;

}
