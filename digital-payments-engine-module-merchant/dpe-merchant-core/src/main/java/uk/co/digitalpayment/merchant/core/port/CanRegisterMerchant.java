package uk.co.digitalpayment.merchant.core.port;

public interface CanRegisterMerchant {

    Long registerMerchant(String name, String apiKey, String supportEmail);

}
