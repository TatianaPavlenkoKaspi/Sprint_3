import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class OrderClient extends ScooterBaseURL {
    public static final String ORDER_PATH = "api/v1/orders";

    //метод для создания клиента
    @Step("Courier creation")
    public ValidatableResponse createCourier(Order information) {
        return given()
                .spec(getBaseSpec())
                .body(information)
                .when()
                .post(ORDER_PATH)
                .then();
    }

    //метод для удаления клиента
    @Step("Courier deletion")
    public ValidatableResponse deleteCourier(int trackNumber) {
        return given()
                .spec(getBaseSpec())
                .body(trackNumber)
                .when()
                .put(ORDER_PATH + "/cancel")
                .then();
    }

    //метод для создания заказа
    @Step("Order creation")
    public ValidatableResponse orders() {
        return given()
                .spec(getBaseSpec())
                .when()
                .get(ORDER_PATH)
                .then();
    }
}
