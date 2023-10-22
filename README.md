# Spring Boot, MySQL, REST API, CRUD

A simple Java Spring REST CRUD API for Formula 1 Drivers

## Steps to Setup

**1. Clone the application**
```bash
git clone https://github.com/hikolu/crudrestapi.git
```

**2. Create MySQL database**
```bash
create database formulaapi
```
- run `src\main\resources\formulaapi`

**3. Change mysql username and password as per your installation**

+ open `src\main\resources\application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your installation

**4. Run the application using maven**

```bash
mvn spring-boot:run
```
The application will start running on <http://localhost:8080>

## Explore Drivers REST API

The app exposes following CRUD endpoints

### Drivers

| Method | Url | Desctioption | Sample Request Body |
| ------ | --- | ------------ | ------------------- |
| GET | /api/drivers | Get all drivers | |
| GET | /api/drivers/{driverId} | Get driver by id | |
| POST | /api/drivers | Create new driver | [JSON](#drivercreate) |
| PUT | /api/drivers | Update an existing driver | [JSON](#driverupdate) |
| DELETE | /api/drivers/{driverId} | Delete a driver based on id | |

Test them using for example Postman or any other rest client

## Sample Valid JSON Request Bodys

##### <a id="drivercreate">Create a new driver -> /api/drivers</a>
```json
{
	"firstName" : "Liam",
	"lastName" : "Lawson",
	"team" : "AlphaTauri"
}
```

##### <a id="driverupdate">Update an existing driver -> /api/drivers</a>
```json
{
  "id" : 2,
  "firstName" : "Sergio",
  "lastName" : "Perez",
  "team" : "Mercedes"
}
```
