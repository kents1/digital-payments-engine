package uk.co.digitalpayment.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Inventory {

    private Long id;
    private UUID uuid;
    private String secretKey;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Boolean enabled;
    private String name;
    private Integer initialTokens;

}
