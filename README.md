# online-bookstore
 Online store to manage and checkout books
 

<hr>

## About this project
This is project, where 
- Admin users can add/edit/modify/delete books 
- Customers can checkout book(s) which will give you back the total price after discount based on book category


Tech Stack:
-----------

Java 11
Springboot 2.5.6
H2 DB
Apache Maven 3.6.3
Spring cloud microservices to make the application distributed. 

<hr>

## Architecture
All the Microservices are developed using spring boot. 
This spring boot applications will be registered with eureka discovery server.

FrontEnd React App makes request's to NGINX server which acts as a reverse proxy.
NGINX server redirects the requests to Zuul API Gateway. 

Spring cloud gateway is used to route the requests to microservice
based on the url route.  

<hr>

## How to run this project locally

- Use STS or Command Line
	- import the project
	- run the command  `mvn clean install` 
	- services will be up in below ports




```
api-gateway-service     : 8089
service-registry        : 8761
book-mgmt-service       : 8081
order-service           : 8082
checkout-service        : 8083
```
All the operations have to be tested using the postman collection attached as no UI is implemented due to time constraints.

- Docker imlementation is in progress

<hr>

## Functionality Description

ORDER SERVICE

1. Create order service
- List books with option to add to cart
  getBooks
  
- addToCart

- proceed (will save item to order DB by calling order service)

- Proceed to checkout (give option to enter promo code) 
	saveOrdersTODB

(ideally cart service should be a seperate service which should be calling the order service to save the orders to order db)

CHECKOUT SERVICE
	
- On checkout, it this service will return disounted price total
   
  
  
##CURRENT IMPLEMENTATION & ASSUMTIONS
  -----------------------------------
  
  
Below are the main tasks covered in the code committed so far,

- REST end points implemented to perform CRUD operations for book store
- REST end point to perform checkout operation
- Eureka server implementation
- Eureka client registration
- Interservice communication between order-service and checkout service
- API gateway implementation 
- Test Cases for CRUD operations
##How to test
All the operations have to be tested using the postman collection attached as no UI is implemented due to time constraints.
Type information is fetched from a utility method.

##Services Implemented
  --------------------
book-mgmt-service  : Admin will be able to perform CRUD operations using book-mgmt-service
book-order-service : for listing the books for customer to purchase and checkout. here list of books and promo code have to be passed as in postman request which in turn call checkout service and will give the response back
book-checkout-service : this service will return disounted price total and called from order-service . Ideally the next step should save the orders to order table but not implemented
book-service-registry : Eureka server
book-api-gateway-service : API gateway implemented centrally manage the gateway for client requests. Currently it is configured only for order and checkout service
 

##Pending implementations
  -----------------------
- Docker deployment configuration
- Test cases to cover all the operations
- Exception handling
- Validations (promocode, etc)
- fallback implementation

  
  
  
   and just to show the inter-communication between services,
  I am calling book-mgmt-service. 
  
  
  
  The order information fetched along with quantity and promo code can be passed as body to the post , which will save orders to order table and in turn call the checkout service
  and return the total price after discount
  
##PENDING
  -------
  Docker - in progress
  Test cases for all the operations. done only for CRUD
  Add CRUD service to eureka server and access through API gateway
  Exception Handling
  change isbn format
  validations (promocode, etc)
  Population of valid test data

## ROADMAP
  -----------
  Security implementation
  Exception Handling
  Logging
  Monitoring capabilities
  Fronend UI for
	- Admin - CRUD operations
	- Customer Facing
		- List books with option to list based on categories, author , popular, etc
		- Search books based on various parameters
		- Add books to Cart
		- Proceed will list down items in the cart with details 
		- Option to provide promo code and proceed to check out
		- Payment Details
		- Complete payment and show the status back with order number 
