package uk.co.digitalpayment.domain;

import lombok.Value;

@Value
public class Role {

    private String type;
    private Boolean enabled;

}
