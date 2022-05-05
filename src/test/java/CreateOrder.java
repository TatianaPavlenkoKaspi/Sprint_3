import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.apache.http.HttpStatus.*;

@RunWith(Parameterized.class)
public class CreateOrder {
    String[] color;
    OrderClient orderClient;
    Order order;
    int trackNumber;

    public CreateOrder(String[] color) {
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] getColorData() {
        return new Object[][]{
                {new String[]{"Black"}},
                {new String[]{"Grey"}},
                {new String[]{"Black", "Grey"}},
                {new String[]{"", ""}},
        };
    }

    @Before
    public void setUp() {
        order = Order.getDefault();
        orderClient = new OrderClient();
    }

    @After
    public void tearDown(){
        orderClient.deleteCourier(trackNumber);
    }

    @Test
    @DisplayName("Делаем заказ с разными наборами цветов")
    public void orderCanBeCreated(){
        order.setColor(color);
        ValidatableResponse createResponse = orderClient.createCourier(order);
        int statusCode = createResponse.extract().statusCode();
        int trackNumber = createResponse.extract().path("track");

        assertThat("Can't create order", statusCode, equalTo(SC_CREATED));
        assertThat("Empty number of order", trackNumber, notNullValue());
    }
}