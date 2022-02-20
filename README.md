## 19-02-22-testes-de-software

## Requisitos do projeto:

- Java 11
- JUnit 4
- REST Assured 4.3.3
- JUnit Jupiter 5.7
- Spring Boot 2
- H2 Database

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
@Test
public void getUsers() {
    String endpoint = "http://localhost:8080/users/";
    var response = given().when().get(endpoint).then();
    response.log().body();
}

@Test
public void getUser() {
    String endpoint = "http://localhost:8080/users/1";
    var response = given().when().get(endpoint).then();
    response.log().body();
}
```

## assertThat().statusCode(200)

```java
@Test
public void getUserAsserting() {
    String endpoint = "http://localhost:8080/users/1";
    given().when().get(endpoint).then().assertThat().statusCode(200);
}
```

## Logging body response:

```java
@Test
public void getUserAssertingResponseBody() {
    String endpoint = "http://localhost:8080/users/1"; // TODO entender queryParam()
    given().when().get(endpoint).then().log().body();
}
```

### Resposta esperada:

```json
{
    "id": 1,
    "name": "Allan Pereira Abrahão",
    "email": "allan8tech@gmail.com",
    "phone": "988888888",
    "password": "123456"
}
```

### Resposta por campo:

```java
@Test
public void getUserAssertingField() {
    String endpoint = "http://localhost:8080/users/1";
    given().when().get(endpoint).then().
            assertThat().statusCode(200).
            body("id", equalTo(1)).
            body("name", equalTo("Maria Brown")).
            body("email", equalTo("maria@gmail.com")).
            body("phone", equalTo("988888888")).
            body("password", equalTo("123456"));
}
```

## Asserting complex fields:

```java
    @Test
    public void getUserVerifyingComplexBodies() {
        String endpoint = "http://localhost:8080/users/";
        given().when().get(endpoint).then().
                assertThat().statusCode(200).
                body("size()", greaterThan(0));
    }
```

### POST com o nome nulo

```java
@Test
public void getUserVerifyingNotNull() {
    String endpoint = "http://localhost:8080/users/";
    given().when().get(endpoint).then().
            assertThat().statusCode(200).
            body("name", everyItem(notNullValue()));
}
```

```json
{
        "email": "allan@allan.com",
        "phone": "1133322222",
        "password": "11111"
}
```
### resultado:
```bash
java.lang.AssertionError: 1 expectation failed.
JSON path name doesn't match.
Expected: every item is not null
Actual: <[Allan Pereira Abrahão, Alex Green, null]>
```

## POST :

```java
// ERRO POST TEXT / JSON SOLUCIONAR
```

## API do Julio de Lima e do Antonio Montanha utilizada para os Testes sob autorização de:

- https://github.com/AntonioMontanha
- https://github.com/juliointest

- https://github.com/AntonioMontanha/gerenciador-viagens