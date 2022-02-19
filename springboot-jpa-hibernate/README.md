![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)

## Deploy :

[Link Deploy on Heroku / users](https://order-springboot-all-an.herokuapp.com/users)

[Link Deploy on Heroku / a order](https://order-springboot-all-an.herokuapp.com/orders/1)

> Open on Postman or use Jsonformatter on Chrome Browser

### Sample User Post:

```json
{ 
        "name": "Allan Pereira Abrahão", 
        "email": "allan8tech@gmail.com", 
        "phone": "49991548711", 
        "password": "1234" 
} 

```

Sample endpoints:

```bash
/users
/orders
/products
```


Requirements: 
- Java 11
- Spring Boot
- PostgreSQL 12
- H2 Database

## Spring Boot / JPA / Hibernate - (Studies)
### Project: Orders, Products, Payments and Users API

Goals: 
- Implement domain model
- Logical Layers Structure : resource, service, repository 
- Configure test database (H2)
- Configure PostgreSQL Database 
- Populate the database
- CRUD - Create, Retrieve, Update, Delete 
- Exception handling
- Deploy on Heroku

<p align="center">
        <a href="https://www.linkedin.com/in/all-an/">
        <img align="center" width="613" height="323"  src="/img/title1.png" />
</a>
</p>

<p align="center">
        <a href="https://www.linkedin.com/in/all-an/">
        <img align="center" width="741" height="433"  src="/img/title2.png" />
</a>
</p>

```json
// Sample GET request
//http://localhost:8080/orders/1

{
    "id": 1,
    "moment": "2019-06-20T19:53:07Z",
    "orderStatus": "PAID",
    "client": {
        "id": 1,
        "name": "Maria Brown",
        "email": "maria@gmail.com",
        "phone": "988888888",
        "password": "123456"
    },
    "items": [
        {
            "quantity": 2,
            "price": 90.5,
            "subTotal": 181.0,
            "product": {
                "id": 1,
                "name": "The Lord of the Rings",
                "description": "Lorem ipsum dolor sit amet, consectetur.",
                "price": 90.5,
                "imgUrl": "",
                "categories": [
                    {
                        "id": 2,
                        "name": "Books"
                    }
                ]
            }
        },
        {
            "quantity": 1,
            "price": 2190.0,
            "subTotal": 2190.0,
            "product": {
                "id": 3,
                "name": "Macbook Pro",
                "description": "Nam eleifend maximus tortor, at mollis.",
                "price": 1250.0,
                "imgUrl": "",
                "categories": [
                    {
                        "id": 3,
                        "name": "Computers"
                    }
                ]
            }
        }
    ],
    "payment": {
        "id": 1,
        "moment": "2019-06-20T21:53:07Z"
    },
    "total": 2371.0
}
```

<a href="https://www.linkedin.com/in/allan-pereira-abrahao" rel="nofollow"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin Badge" data-canonical-src="https://img.shields.io/badge/-Allan-blue?style=flat-square&amp;logo=Linkedin&amp;logoColor=white&amp;link=https://www.linkedin.com/in/allan-pereira-abrahao/%C3%A3o-7b72b5202/" style="max-width: 100%;"></a>



