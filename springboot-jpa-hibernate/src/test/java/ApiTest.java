import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApiTest {
	
	@Test
	public void getUsers() {
		// http://localhost:8080/users/
		String endpoint = "http://localhost:8080/users/";
        var response = given().when().get(endpoint).then();
        response.log().body();
	}
	
	@Test
    public void getProduct(){
        String endpoint = "http://localhost:8080/user/";
        var response =
                given().
                    queryParam("id", 4).
                when().
                    get(endpoint).
                then();
        response.log().body();
    }

}
