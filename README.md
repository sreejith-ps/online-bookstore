# online-bookstore
 Online store to manage and checkout books
 

<hr>

## About this project

- Admin users can add/edit/modify/delete books 
- Customers can checkout book(s) which will give you back the total price after discount based on book category


Tech Stack:
-----------

- Java 11
- Springboot 2.5.6
- H2 DB
- Apache Maven 3.6.3
- Spring cloud microservices to make the application distributed. 

<hr>

## Architecture
All the Microservices are developed using spring boot and are registered with eureka discovery server.

Spring cloud gateway is used to route the requests to microservice
based on the url route.  

<hr>

## How to run this project locally

- Use STS or Command Line
	- import the project
	- run the command  `mvn clean install` 
	- run the command  `mvn spring-boot:run` 
	- services will be up in below ports


- Docker (In case of any issues running this due to last minute changes, please refer previous approach)
	
	- Start Docker Engine 
	- run `mvn clean install` at root of project.
	- run `docker-compose up --build` to start all the containers.


```
api-gateway-service     : 8989
service-registry        : 8762
book-mgmt-service       : 8081
order-service           : 8082
checkout-service        : 8083
```
All the operations have to be tested using the postman collection attached as no UI is implemented due to time constraints.

Please ignore data quality in postman collection. 
   
#How to test
-------------------------------------
All the operations have to be tested using the postman collection attached as no UI is implemented due to time constraints.
Type information is fetched from a utility method.

Note: please ignore Order entity which is not being used
<hr>
  
  
  
  
#Current Implementation 
  -----------------------------------
  
Below are the main tasks covered in the code committed so far,

- REST end points implemented to perform CRUD operations for book store
- REST end point to perform checkout operation
- Eureka server implementation
- Eureka client registration
- Interservice communication between order-service and checkout service
- API gateway implementation 
- Test Cases for CRUD operations

<hr>
   
#Services Implemented
  --------------------
- book-mgmt-service  : Admin will be able to perform CRUD operations using book-mgmt-service
- book-order-service : for listing the books for customer to purchase and checkout. here list of books and promo code have to be passed as in postman request which in turn call checkout service and will give the response back
- book-checkout-service : this service will return disounted price total and called from order-service . Ideally the next step should save the orders to order table but not implemented
- book-service-registry : Eureka server
- book-api-gateway-service : API gateway implemented centrally manage the gateway for client requests. Currently it is configured only for order and checkout service
 <hr>
   

##Pending implementations
  -----------------------
  - Docker - in progress
  - Test cases for all the operations. done only for CRUD
  - Add CRUD service to eureka server and access through API gateway
  - Exception Handling
  - change isbn format
  - validations (promocode, etc)
  - Population of valid test data
 <hr>
 
## ROADMAP
  -----------
  - Security implementation
  - Exception Handling
  - Logging
  - Monitoring capabilities
  - Fronend UI for
	- Admin - CRUD operations
	- Customer Facing
		- List books with option to list based on categories, author , popular, etc
		- Search books based on various parameters
		- Add books to Cart
		- Proceed will list down items in the cart with details 
		- Option to provide promo code and proceed to check out
		- Payment Details
		- Complete payment and show the status back with order number 
