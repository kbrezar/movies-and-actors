import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class ActorTest {

    @Test
    public void getActor() {
        given().when()
                .get("/api/actors/0000209")
                .then().statusCode(200).body(is("{\"firstName\":\"Tim\",\"lastName\":\"Robbins\",\"bornDate\":\"1958-10-16\",\"id\":209}"));
    }


}
