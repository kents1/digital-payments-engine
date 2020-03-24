package uk.co.digitalpayment.merchant.core.model;

import lombok.Data;

@Data
public class MerchantCredentialModel {

    private String emailAddress;
    private String password;
    private String localeCode;

}
