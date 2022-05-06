import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class CourierClient extends ScooterBaseURL{
    public static final String COURIER_PATH = "api/v1/courier/";
    public ValidatableResponse loginCourier(CourierLogin credentials) {
        return given()
                .spec(getBaseSpec())
                .body(credentials)
                .when()
                .post(COURIER_PATH + "login")
                .then();
    }

    public ValidatableResponse createCourier(Courier credentials) {
        return given()
                .spec(getBaseSpec())
                .body(credentials)
                .when()
                .post(COURIER_PATH)
                .then();
    }

    public ValidatableResponse deleteCourier(int courierId) {
        return given()
                .spec(getBaseSpec())
                .body(courierId)
                .when()
                .delete(COURIER_PATH + ":" + courierId)
                .then();
    }
}
