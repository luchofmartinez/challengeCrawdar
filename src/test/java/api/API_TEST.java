package api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class API_TEST {


    @BeforeMethod
    public static void setup(){
        RestAssured.baseURI = "https://www.mercadolibre.com.ar/menu/departments";
    }


    @Test
    public void getDepartmentsML() {

        JsonPath resp = given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()  ;
        List catgs = resp.getList("departments[0].categories");

        System.out.println("Cantidad de categorias: " + catgs.size());

        Assert.assertFalse(catgs.isEmpty());
    }

}
