package uk.co.digitalpayment.app.api.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountModel {

    private String emailAddress;
    private String locale;

}
