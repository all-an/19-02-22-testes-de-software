## Reforçando Conhecimentos em Testes de Software utilizando as bibliotecas e ferramentas de testes:

- [REST Assured](https://rest-assured.io/)
- [Selenium](https://www.selenium.dev/documentation/webdriver/getting_started/)
- [JMeter](https://jmeter.apache.org/usermanual/get-started.html)

## Requisitos do projeto:

- Java 11
- JUnit 4
- REST Assured 4.3.3
- JUnit Jupiter 5.7
- Spring Boot 2
- H2 Database
- Selenium Server 3.11
- Selenium ChromeDriver 3.11
- Spring Boot Test Autoconfigure 2.6.3

## Minha api utilizada:

- https://github.com/all-an/springboot-jpa-hibernate

## Dependências Necessárias:

```xml

<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-server</artifactId>
    <version>3.11.0</version>
</dependency>

<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-chrome-driver</artifactId>
    <version>3.11.0</version>
</dependency>

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

## Comparando atributos de determinado usuário:

```java
@Test
public void getDeserializedBodyFields() {
    String endpoint = "http://localhost:8080/users/1";
    User user = new User(
            1L,
            "Allan Pereira Abrahão",
            "allan8tech@gmail.com",
            "988888888",
            "123456"
    );
    User actualUser = given().when().get(endpoint).as(User.class);
    assertThat(actualUser, samePropertyValuesAs(user));
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

## Verificando Header:

```java
@Test
public void verifyingHeader() {
    String endpoint = "http://localhost:8080/users/";
    given().when().get(endpoint).then().
            assertThat().statusCode(200).
            header("Content-Type", equalTo("application/json"));
}
```

## Deserializando objeto:

```java
@Test
public void getDeserializedBody() {s
    String endpoint = "http://localhost:8080/users/1";
    given().when().get(endpoint).as(User.class);
}
```

## POST :

```java
// ERRO POST TEXT / JSON SOLUCIONAR queryParam()
```

# Selenium:

### Iniciando com o chrome webdriver:

```java
Scanner scanner = new Scanner(System.in);
// Set the property for webdriver.chrome.driver to be the location to your local download of chromedriver
System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
//chromedriver deve ser a mesma versão do navegador chrome

//https://chromedriver.storage.googleapis.com/index.html

// Create new instance of ChromeDriver
WebDriver driver = new ChromeDriver();

// And now use this to visit Google
driver.get("http://www.google.com");

// Find the text input element by its name
WebElement element = driver.findElement(By.name("q"));

// Enter something to search for
element.sendKeys("Queijo!");

// Now submit the form
element.submit();

scanner.nextLine();
//Close the browser
driver.quit();
```

## website utilizado nos testes selenium
### https://formy-project.herokuapp.com/ 


## Opening a browser and interacting with a website.

```java
public class ExecuteJavascript {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/modal");

        WebElement modalButton = driver.findElement(By.id("modal-button"));
        modalButton.click();

        Thread.sleep(5000);

        WebElement closeButton = driver.findElement(By.id("close-button"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", closeButton);

        sc.nextLine();

        driver.quit();
    }
}
```

## Drag and Drop:

```java
WebElement image = driver.findElement(By.id("image"));
WebElement box = driver.findElement(By.id("box"));

Actions action = new Actions(driver);

action.dragAndDrop(image, box).build().perform();
```

## Selenium CSS Selector

<p align="center">
        <a href="https://www.linkedin.com/in/allan-pereira-abrahao/">
        <img align="center" width="930" height="498"  src="/img/selenium-css-selector1.png" />
</a>
</p>

<p align="center">
        <a href="https://www.linkedin.com/in/allan-pereira-abrahao/">
        <img align="center" width="879" height="322"  src="/img/selenium-css-selector2.png" />
</a>
</p>

<p align="center">
        <a href="https://www.linkedin.com/in/allan-pereira-abrahao/">
        <img align="center" width="899" height="426"  src="/img/selenium-css-selector3.png" />
</a>
</p>

## Selenium find by child element and wildcards

<p align="center">
        <a href="https://www.linkedin.com/in/allan-pereira-abrahao/">
        <img align="center" width="900" height="430"  src="/img/selenium-css-selector4.png" />
</a>
</p>

<p align="center">
        <a href="https://www.linkedin.com/in/allan-pereira-abrahao/">
        <img align="center" width="847" height="441"  src="/img/selenium-css-selector5.png" />
</a>
</p>

# Curso QA Julio de Lima 

### API do Julio de Lima e do Antonio Montanha utilizada para os Testes sob autorização de:

- https://github.com/AntonioMontanha
- https://github.com/juliointest

- https://github.com/AntonioMontanha/gerenciador-viagens