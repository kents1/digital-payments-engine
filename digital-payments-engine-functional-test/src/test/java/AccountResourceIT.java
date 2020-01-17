import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.AccessToken;

@QuarkusTest
class AccountResourceIT {

    private String accessToken;

    @BeforeEach
    void createAccessToken() {
        this.accessToken = AccessToken.fetch();
    }

    @Test
    void shouldCreateAccount() {
        RestAssured.given()
                .header("Authorization", String.format("Bearer: %s", accessToken))
                .when().post("/api/accounts")
                .then()
                .statusCode(201);
    }

}
