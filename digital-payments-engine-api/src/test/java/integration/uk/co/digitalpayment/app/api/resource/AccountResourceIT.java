package integration.uk.co.digitalpayment.app.api.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import uk.co.digitalpayment.app.api.resource.AccountResource;

import javax.inject.Inject;

@QuarkusTest
class AccountResourceIT {

    @Inject
    AccountResource accountResource;

    @Test
    void shouldCreateAccount() {
        accountResource.create();
    }

}
