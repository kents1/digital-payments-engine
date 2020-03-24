package uk.co.digitalpayment.merchant.infra.db.dao;

final class MerchantSQL {

    static final String SELECT_BY_EMAIL_ADDRESS = "SELECT * FROM merchant WHERE email_address = :emailAddress";

}
