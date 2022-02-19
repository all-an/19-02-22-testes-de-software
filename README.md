## 19-02-22-testes-de-software

## Minha api utilizada:

- https://github.com/all-an/springboot-jpa-hibernate

## Dependências Necessárias:

```xml
<!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>4.3.3</version>
    <scope>test</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.7.0</version>
    <scope>test</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.12.1</version>
</dependency>

```

## Primeira classe de teste:

```java
package com.springboot.test;

import org.junit.Test;
import static io.restassured.RestAssured.given;
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
```

## API do Julio de Lima e do Antonio Montanha utilizada para os Testes sob autorização de:

- https://github.com/AntonioMontanha
- https://github.com/juliointest

- https://github.com/AntonioMontanha/gerenciador-viagens