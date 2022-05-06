import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.*;

import java.util.ArrayList;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OrderListTest {
    OrderClient orderClient;
    Order order;

    @Before
    public void setUp() {
        order = Order.getDefault();
        orderClient = new OrderClient();
    }

    @Test
    @DisplayName("Список заказов не пустой")
    public void getReturnListOfOrders(){
        ValidatableResponse createResponse = orderClient.orders();
        int statusCode = createResponse.extract().statusCode();
        ArrayList response = createResponse.extract().path("orders");

        assertThat("Can't create order", statusCode, equalTo(SC_OK));
        assertThat("Empty response", response, notNullValue());
    }
}
