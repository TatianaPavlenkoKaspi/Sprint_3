import io.qameta.allure.Step;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color;

    //метод для создания заказа с дефолтным клиентом
    @Step("Create order with default customer")
    public static Order getDefault(){
        String firstName = "Дима";
        String lastName = "Синичкин";
        String address = "Горная, 47";
        String metroStation = "5";
        String phone = "+77779704503";
        int rentTime = 2;
        String deliveryDate = "06.05.22";
        String comment = "Продам гараж";
        String[] color = new String[2];
        return new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }
}
