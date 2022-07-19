# QA 22MayEnable2 Software Core - Practical Project Vehicle Service Management System (VSMS)


## Contents:
* [Project Brief](#Project-Brief)  
* [Getting Started](#Getting-Started)
* [Prerequisites](#Prerequisites)  
* [Installing](#Installing)
* [MySQL Database](#MySQL-Database)
* [Project Management](#Project-Management)
* [Tests](#Tests)
* [Deployment](#Deployment)
* [Built With](#Built-With)
* [Versioning](#Versioning)
* [Authors](#Authors)
* [License](#License)
* [Acknowledgments](#Acknowledgments)

# Project Brief
## Vehicle Service Management System (VSMS)

Vehicle Service Management System written in Java. OOP-Based web-application. This codebase was created to demonstrate a full-stack application built with Spring boot + MySQL including CRUD operations.

The aim of this project was to have a CRUD-based web application, with utilisation of supporting tools, methodologies, and technologies, that encapsulates all fundamental and practical modules covered during training with QA.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

Please use this link to clone the app [Github-Link-VSMS](https://github.com/erhnaks/Vehicle-Service-Management-System)

## Prerequisites


You will need the following softwares to build and run this application;

* Java JDK (version 11.0 or higher)
* Apache Maven
* Git (version control
* MySQL (database)
* Eclipse IDE 

## Installing

1. Clone the repository from [Github-Link](https://github.com/erhnaks/Vehicle-Service-Management-System)
2. Run it in the command line with the following code
```
java -jar 1.0-fat.jar
```
3. Open the project on Eclipse

4. Click on index.hmtl (will open a browser with the application running)


## MySQL Database

##### Application ERD

![ERD-Final](https://user-images.githubusercontent.com/97620234/179769923-2ca54991-282d-4eb0-8d6b-ef5c11480357.png)

##### Apllication UML

![VSMS-UML-Diagram](https://user-images.githubusercontent.com/97620234/179770969-0d88def3-7a1f-4cc9-8a3d-21be7af0569c.png)

## Project Management

Jira Kanban board and GitHub was used for project management including GitHub Smart commits.

![Jira](https://user-images.githubusercontent.com/97620234/179771343-0d934754-21ee-45d3-8945-165b507929b8.png)

## Tests

### Test Coverage 

##### 97.8%

![Test-Coverage](https://user-images.githubusercontent.com/97620234/179840696-b04938b7-cb13-4be0-9eb7-24d6b187cfe9.png)

### Running the tests

In order to run the test for the application please clone the repository to your local machine by the link given blow;
```
https://github.com/erhnaks/IMS-22EnableMay2
```
Once clone is finished, open your command line interface in the project folder and run the following code to initiate the test;
```
mvn test
```

### Unit Tests 

These tests are written to test the functions of the application and its methods.

Here is an example of an Integration Test

```
@Test
	void testReadByAll() throws Exception {

		List<Vehicle> readVehicles = new ArrayList<>();
		readVehicles.add(new Vehicle(1, "LT68KUD", 1000, "Serviced", 99.00));
		String createdVehicleAsJSON = this.mapper.writeValueAsString(readVehicles);

		this.mvc.perform(get("/getAll")).andExpect(content().json(createdVehicleAsJSON)).andExpect(status().isOk());

	}

	@Test
	void testReadById() throws Exception {

		Vehicle readVehicle = new Vehicle(1, "LT68KUD", 1000, "Serviced", 99.00);
		String createdVehicleAsJSON = this.mapper.writeValueAsString(readVehicle);

		this.mvc.perform(get("/readById/1")).andExpect(content().json(createdVehicleAsJSON)).andExpect(status().isOk());
```


## Deployment



Maven Deployment Tool has been used to deploy this application.

## Front End Visual
##### Front web page

![VSMS-front-page](https://user-images.githubusercontent.com/97620234/179775472-9e8e5e86-c39e-4f88-b088-66aabfe05c0c.png)

##### Creating new service report for the companies vehicle

![VSMS-Create](https://user-images.githubusercontent.com/97620234/179775740-46d030d3-5a25-43e2-8ede-719a0ea229f5.png)

##### Updating an existing service entry

![VSMS-update](https://user-images.githubusercontent.com/97620234/179775856-9b388348-0c3d-4883-ad02-b5d29f3c81a2.png)

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

GitHub Version Control [Github](http://github.com) for versioning.

## Authors

* **Erhan Aksu** [erhnaks](https://github.com/erhnaks/Vehicle-Service-Management-System)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Special thanks to QA, Jordan Harrison and Jordan Benbelaid.
