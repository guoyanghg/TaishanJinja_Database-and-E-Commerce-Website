# TaishanJinja_Database-and-E-Commerce-Website

Database design project with front-end E-Commerce-Website 

Please use Eclipse for j2ee to edit the webpage project in STEP5 of this project.

STEP1 and STEP2 are project design concepts, so please skip these.

STEP3
This step contains SQL scripts that are used to create the tables in the database, based on the entity-relationship (ER) diagram. 

STEP4
This contains the SQL scripts for adding test data into the tables. 

STEP5
This contains the Web code.
Copy the project directly to the eclipse workspace and import it using File->import


## Getting Started

### Prerequisites

* Tomcat 6.0: https://tomcat.apache.org/tomcat-6.0-doc/

* Eclipse for j2ee: https://www.eclipse.org/downloads/packages/release/indigo/sr2/eclipse-ide-java-ee-developers

* MySQL: https://dev.mysql.com/downloads/installer/

### Installing

Copy the project directly to the eclipse workspace and import it using File->import

## Authors

Yang Guo, Yude Wang, Zonghao Feng

## Details
We want to implement an online shopping site related to animation.

Features that need to be implemented:
*	Account registration, and user login;
*	Account management, to view and modify the user's personal information;
*	Product discovery; Browse the products according to the product category, and Search for products based on their properties;
*	View the sales rankings of the products in a certain month;
*	View the historical evaluation of a product;
*	Product selection (the user can choose new or second-hand goods) in order to add it to the shopping cart;
*	View and modify the shopping cart;
*	Place an order to purchase the products in the shopping cart and fill in the order information;
*	View the status of an order;
*	Confirm receipt of a product and evaluate it;
*	Add new products to sell by category, and fill in the product information;
*	View the comments on products that are sold;
*	Confirm the delivery of an the order;
*	View the information contained in the database (the brainstorming results are slightly different from the implementation):
*	Account information (account ID, email, last name, first name, address (country, province, city, district, gate), Grade, zip code, telephone, balance, password);
*	Large class (large class ID, large class name);
*	Medium class (middle class ID, medium class name, large class ID);
*	Product (item ID, medium class ID, price, seller ID, new/old, product name, attribute 1, "	attribute 2, attribute 3, attribute 4, inventory quantity);
*	Order details (order ID, buyer ID, seller ID, order time, delivery address (country, province, city, district, house number, zip code), delivery name (last name, first name), billing address (country, province, city, district, house number, zip code), bill name (last name, first name), courier, credit card type, credit card number, order expiration time, item ID, number of items); 
*	Order status (order ID, serial number, time stamp, order status);
*	User comments (item ID, account ID, order ID, star rating, evaluation content);



