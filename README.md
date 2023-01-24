This is a pet bakery that specializes in custom designed cakes. We can register as a client, manage orders on website(delete one order), add a cake, see all categories, add new category, update one category. See all orders history and delete one order from history. From what we see, right now the admin functionality is build. In the future we want to extend the logic to fully serve as an online cake shop for our furry friends, so we want a client to login and order one cake from our site 😊. 

My DB Diagram: 
![image](https://user-images.githubusercontent.com/94255705/214360891-09b607c5-9abd-461d-9a2c-c61c7e996c6e.png)


Entities: CakeCategory - this table contains informations about the cakes (how they are named and some useful things about them).

Cake- this table containts information about the cake (PortraitCakes, BirthdayCakes). It contains many to one relationship with CakeCategory table and a many to many relationship with Order table.

Order – table which gestionates orders. Here we have information regard total price. It has many to one relationship with Client table and many to many with Cake table.

Client - table that gestionate client that register/log in my aplication. It has one to one relationship with DeliveryAddress table and one to many with Order table. DeliveryAddress - table that gestionate deliveries. It has a boolean value if the order is already payed or not. It has a one to one relationship with Client table and one to one relationship with History.

History - table that show history of deliveries to our clients. It contains information regard the status of order(delivered, delivery in progress) and the date of the order. It has one to one relathionship with DeliveryAddress table.

Servicies:

DeliveryAddressService - retrieve all deliveries.

OrderService - retrieve all orders, add a new order, delete one order by its id.

ClientService - create new client(register), retrieve all clients.

CakeService - add a cake and retrieve all cakes.

CakeCategoryService- retrieve all categories, add new category and update one category by its id.

HistoryService - retrieve all histories, delete one history by id, save new history.
