import io.qameta.allure.Step;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;

@Data

public class CourierGenerate {
    //генерация курьера с рандомными данными
    @Step("Random credentials generation")
    public static Courier getRandom(){
        String login = RandomStringUtils.randomAlphabetic(10);
        String password = RandomStringUtils.randomAlphabetic(10);
        String firstName = RandomStringUtils.randomAlphabetic(10);
        Courier courier = new Courier(login, password, firstName);
        return courier;
    }
}
