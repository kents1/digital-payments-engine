package integration.uk.digitalpayment.repository.impl.config;

import io.quarkus.test.junit.QuarkusTest;
import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
class JdbiFactoryIT {

    @Inject
    Jdbi jdbi;

    @Test
    void shouldConfigureJdbiCorrectly() {
        Assertions.assertNotNull(jdbi);
    }

}
