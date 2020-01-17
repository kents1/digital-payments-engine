CREATE TABLE inventory (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    uuid VARCHAR(36) NOT NULL,
    secret_key VARCHAR (255) NULL,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    enabled BIT DEFAULT 1,
    name VARCHAR(40) NOT NULL,
    initial_tokens INTEGER DEFAULT 0,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE account_role (
    type VARCHAR(15) NOT NULL,
    enabled BIT DEFAULT 1,
    PRIMARY KEY (type)
) ENGINE = InnoDB;

CREATE TABLE account (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    account_role_type VARCHAR(15) NOT NULL,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    enabled BIT DEFAULT 1,
    email_address VARCHAR(255) NOT NULL,
    locale VARCHAR(5),
    PRIMARY KEY (id),
    FOREIGN KEY (account_role_type) REFERENCES account_role (type)
) ENGINE = InnoDB;

CREATE TABLE account_inventory (
    inventory_id BIGINT UNSIGNED NOT NULL,
    account_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (inventory_id, account_id),
    FOREIGN KEY (inventory_id) REFERENCES inventory (id) ON DELETE CASCADE,
    FOREIGN KEY (account_id) REFERENCES account (id)
) ENGINE = InnoDB;

INSERT INTO account_role (type, enabled) VALUES ('ADMINISTRATOR', 1);
INSERT INTO account_role (type, enabled) VALUES ('CLIENT', 1);
INSERT INTO account_role (type, enabled) VALUES ('GUEST', 1);
