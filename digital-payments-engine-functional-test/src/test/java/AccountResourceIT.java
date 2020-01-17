import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@QuarkusTest
class AccountResourceIT {

    private String accessToken;

    @BeforeEach
    void createAccessToken() {

    }

    @Test
    void shouldCreateAccount() {
//        RestAssured.given()
//                .header("Authorization", String.format("Bearer: %s", accessToken))
//                .when().post("/api/accounts")
//                .then()
//                .statusCode(201);
    }

}
