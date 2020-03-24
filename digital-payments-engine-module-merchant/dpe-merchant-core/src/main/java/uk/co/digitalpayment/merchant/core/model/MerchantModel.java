package uk.co.digitalpayment.merchant.core.model;

import lombok.Data;

import java.util.Collection;

@Data
public class MerchantModel {

    private Long id;
    private String name;
    private String apiKey;
    private String supportEmail;
    private Collection<MerchantCredentialModel> merchantCredentialModels;

}
