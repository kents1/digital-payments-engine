CREATE TABLE merchant_role
(
    type VARCHAR(15) NOT NULL,
    enabled BIT DEFAULT 1,
    PRIMARY KEY (type)
) ENGINE = InnoDB;

CREATE TABLE merchant
(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL DEFAULT 'DPE Merchant',
    api_key VARCHAR(36) NOT NULL,
    support_email VARCHAR(255) NULL,
    enabled BIT DEFAULT 1,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE merchant_credential
(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    email_address VARCHAR(255) NOT NULL,
    password VARCHAR(60) NOT NULL,
    merchant_id BIGINT UNSIGNED NOT NULL,
    verified BIT DEFAULT 0,
    enabled BIT DEFAULT 1,
    locale VARCHAR(5),
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (merchant_id) REFERENCES merchant (id)
) ENGINE = InnoDB;

CREATE TABLE merchant_credential_role_map
(
    merchant_credential_id BIGINT UNSIGNED NOT NULL,
    merchant_role_type VARCHAR(15) NOT NULL,
    PRIMARY KEY (merchant_credential_id, merchant_role_type),
    FOREIGN KEY (merchant_role_type) REFERENCES merchant_role (type) ON DELETE CASCADE
) ENGINE = InnoDB;
