package empty.jar.repro;

import empty.jar.quarkus.fixture.CommonTest;
import empty.jar.repro.javalib.fixtures.ATestThing;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest implements CommonTest {

    @Test
    public void testHelloEndpoint() {
        new ATestThing();
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("howdy! from RESTEasy Reactive"));
    }

}