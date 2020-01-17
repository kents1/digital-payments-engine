package uk.co.digitalpayment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Locale;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Account {

    private Long id;
    private Role role;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Boolean enabled;
    private String emailAddress;
    private Locale locale;

}
