package uk.co.digitialpayment.repository.impl.dao;

final class AccountSQL {

    static final String SELECT_BY_ID =
            "SELECT * FROM account WHERE id = :id AND enabled IS TRUE";

    static final String INSERT =
            "INSERT INTO account (" +
                    "account_role_type, " +
                    "created, " +
                    "updated, " +
                    "enabled, " +
                    "email_address, " +
                    "locale" +
                ") VALUES (" +
                    ":role, " +
                    "NOW(), " +
                    "NOW(), " +
                    ":enabled, " +
                    ":emailAddress, " +
                    ":locale" +
                ")";


}
