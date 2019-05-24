  ## OnlineBank
  
#### Purpose 
  Create 'Online Bank' website for storing money and pay utilities.(diploma work)


##### To log into the account the client must have
   - username
   - Password 
   -------
#### Technologies list
 - Technologies
     * [Java SE 8](http://www.oracle.com/technetwork/java/javase/overview/index.html)
     * [Apache Maven](https://maven.apache.org/)
     * [Spring Boot](http://projects.spring.io/spring-boot/)
     * [Spring Security](http://projects.spring.io/spring-security/)
     * [Liquibase](http://www.liquibase.org/index.html)
     * [HIbernate](http://hibernate.org/orm/)
     * [Clickatell](https://www.clickatell.com/)
     * [MySQL 5.7](https://www.mysql.com/downloads/) 
     * MySQL workbench
  - IDE:
     - [Intellij idea Ultimate](https://www.jetbrains.com/idea/download/#section=linux)
  - API Development Environment
    -  [Postman](https://www.getpostman.com/)
-------

#### Environment setup

 * Install Java SE8()
 * [Set Java system variables](http://www.oracle.com/technetwork/java/javase/overview/index.html)
 * [Downloading Apache Maven](Downloading Apache Maven)
 * [Install Maven](https://maven.apache.org/install.html)
 * [Download MySql](https://dev.mysql.com/downloads/mysql/)
 * [Install MySql](https://dev.mysql.com/doc/mysql-installer/en/)

By default in application.properties MySQL connection parametors are username=root  password='empty'
                                                      

#### Structure

```
├── onlinebank
|   ├── bank-test---------# postman test
|   ├── onlinebank-base---------# resources,services and data layers
|   ├── onlinebank-web------------------# web related data and security
|   └── pom.xml------------------# all maven dependencies
```
-------

#### Run application

To run full application, first, run the backend side then frontend and navigate to http://localhost:4200/ 
