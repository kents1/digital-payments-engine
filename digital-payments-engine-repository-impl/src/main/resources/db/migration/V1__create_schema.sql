CREATE TABLE payment_type (
    type VARCHAR(15) NOT NULL,
    enabled BIT DEFAULT 1,
    PRIMARY KEY (type)
);

CREATE TABLE currency_type (
    currency_code VARCHAR(3) NOT NULL,
    payment_type VARCHAR(15) NOT NULL,
    enabled BIT DEFAULT 1,
    name VARCHAR(25) NOT NULL,
    symbol VARCHAR(5) NULL,
    lowest_denom_ratio INTEGER NOT NULL,
    PRIMARY KEY (currency_code),
    FOREIGN KEY (payment_type) REFERENCES payment_type (type)
);

CREATE TABLE inventory (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    uuid VARCHAR(36) NOT NULL,
    secret_key VARCHAR (255) NULL,
    enabled BIT DEFAULT 1,
    name VARCHAR(40) NOT NULL,
    initial_tokens INTEGER DEFAULT 0,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE inventory_item_category (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    parent_id BIGINT UNSIGNED NULL,
    name VARCHAR(40) NOT NULL,
    description VARCHAR (255) NULL,
    display_text VARCHAR (255) NULL,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE inventory_item (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    inventory_id BIGINT UNSIGNED NOT NULL,
    inventory_item_category_id BIGINT UNSIGNED NULL,
    enabled BIT DEFAULT 1,
    name VARCHAR(40) NOT NULL,
    short_description VARCHAR(255) NULL,
    action_type VARCHAR (30) NOT NULL DEFAULT 'DEFAULT',
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (inventory_id) REFERENCES inventory (id) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE inventory_item_price (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    inventory_item_id BIGINT UNSIGNED NOT NULL,
    sku VARCHAR(36) NOT NULL,
    currency_code VARCHAR(3) NOT NULL,
    value INTEGER NOT NULL,
    tokens INTEGER NULL,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (currency_code) REFERENCES currency_type (currency_code),
    FOREIGN KEY (inventory_item_id) REFERENCES inventory_item (id) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE customer (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    uuid VARCHAR(36) NOT NULL,
    secret VARCHAR(60) NOT NULL,
    enabled BIT DEFAULT 1,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE customer_inventory (
    customer_id BIGINT UNSIGNED NOT NULL,
    inventory_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (customer_id, inventory_id),
    FOREIGN KEY (inventory_id) REFERENCES inventory (id) ON DELETE CASCADE,
    FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE customer_credit (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    customer_id BIGINT UNSIGNED NOT NULL,
    tokens INTEGER DEFAULT 0,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE account_role (
    type VARCHAR(15) NOT NULL,
    enabled BIT DEFAULT 1,
    PRIMARY KEY (type)
) ENGINE = InnoDB;

CREATE TABLE account (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL DEFAULT 'DPE Account',
    api_key VARCHAR(36) NOT NULL,
    support_email VARCHAR(255) NULL,
    enabled BIT DEFAULT 1,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE account_credential (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    email_address VARCHAR(255) NOT NULL,
    password VARCHAR(60) NOT NULL,
    account_id BIGINT UNSIGNED NOT NULL,
    verified BIT DEFAULT 0,
    enabled BIT DEFAULT 1,
    locale VARCHAR(5),
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (account_id) REFERENCES account (id)
) ENGINE = InnoDB;

CREATE TABLE account_credential_role_map (
    account_credential_id BIGINT UNSIGNED NOT NULL,
    account_role_type VARCHAR(15) NOT NULL,
    PRIMARY KEY (account_credential_id, account_role_type),
    FOREIGN KEY (account_role_type) REFERENCES account_role (type) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE account_inventory (
    inventory_id BIGINT UNSIGNED NOT NULL,
    account_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (inventory_id, account_id),
    FOREIGN KEY (inventory_id) REFERENCES inventory (id) ON DELETE CASCADE,
    FOREIGN KEY (account_id) REFERENCES account (id)
) ENGINE = InnoDB;

CREATE TABLE account_plan_map (
  account_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (account_id)
) ENGINE = InnoDB;

INSERT INTO account_role (type, enabled) VALUES ('ADMINISTRATOR', 1);
INSERT INTO account_role (type, enabled) VALUES ('SUPER_USER', 1);
INSERT INTO account_role (type, enabled) VALUES ('USER', 1);
INSERT INTO account_role (type, enabled) VALUES ('GUEST', 1);

INSERT INTO payment_type (type, enabled) VALUES ('CURRENCY', 1);
INSERT INTO payment_type (type, enabled) VALUES ('TOKEN', 1);

INSERT INTO currency_type (currency_code, payment_type, name, symbol, lowest_denom_ratio) VALUES ('GBP', 'CURRENCY', 'Pound', '£', 100);
INSERT INTO currency_type (currency_code, payment_type, name, symbol, lowest_denom_ratio) VALUES ('EUR', 'CURRENCY', 'Euro', '€', 100);
INSERT INTO currency_type (currency_code, payment_type, name, lowest_denom_ratio) VALUES ('TOK', 'TOKEN', 'Token', 1);
