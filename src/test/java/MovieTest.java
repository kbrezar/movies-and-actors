import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MovieTest {

    @Test
    public void getMovie() {
        given().when()
                .get("/api/movies/0111161")
                .then().statusCode(200).body(is("{\"title\":\"The Shawshank Redemption\",\"screenedYear\":1994,\"description\":\"Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion.\",\"id\":111161}"));
    }


}
