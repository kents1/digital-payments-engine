package util;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import javax.ws.rs.client.ClientBuilder;

public class AccessToken {

    public static String fetch() {
        Response response = RestAssured.given()
                .config(RestAssured.config()
                        .encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("x-www-form-urlencoded",
                                ContentType.URLENC)))
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("username", "simonkent@sky.com")
                .formParam("password", "password")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", "digital-payments-engine-app")
                .formParam("client_secret", "40b536cc-10f1-4857-9e83-2685c7d3e238")
                .post("http://localhost:8180/auth/realms/Digital_Payments_Engine/protocol/openid-connect/token");
        return response.jsonPath().get("access_token");
    }

}
