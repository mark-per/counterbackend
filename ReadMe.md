# Counter Application

The **Counter** application is a Java-based backend that requires a MySQL database for operation. This README provides
step-by-step instructions on how to set up the database and run the application using Docker containers.

## Prerequisites

Before getting started, make sure you have the following prerequisites installed on your system:

- Docker: [Install Docker](https://docs.docker.com/get-docker/)
- Java Development Kit (JDK) 17 or later: [Install JDK](https://adoptium.net/?variant=openjdk17)

## Getting Started

1. **Pull the MySQL Docker Image:**

   Pull the official MySQL Docker image from Docker Hub:

   ```shell
   docker pull mysql
2. **Create a Docker Network:**

   Create a Docker network that allows the Counter application container to communicate with the MySQL database container:

   ```shell
   docker network create p-nut-counter

3. **Run the MySQL Database Container:**

   Start a MySQL database container named my-mysqldb within the p-nut-counter network. Replace root and counter with your preferred MySQL root password and database name:
   ````shell
   docker run --name my-mysqldb --network p-nut-counter -p 3306:3306 -e MYSQL_DATABASE=counter -e MYSQL_ROOT_PASSWORD=root -d mysql

4. **Access MySQL Shell:**
   Access the MySQL database container's shell to set up the database schema and tables. Replace containerid with the actual container ID
   ````shell
   docker exec -it containerid bash
   
5. **Inside the container, log in to MySQL as the root user:**

   You'll be prompted to enter the MySQL root password (in this case, root).
   
   Once you're in the MySQL shell, you can create the necessary database tables and schema for your application.
   
   ````shell
   mysql -u root -p
   
6. **Build the Counter Application Image:**
   Build a Docker image for the Counter application. Ensure that you are in the directory containing the application files and Dockerfile. Replace counter with your preferred image name:
   ````shell
   docker build -t counter

7. **Running the Application:**
   With the MySQL database container and the Counter application image set up, you can now run the application:
   The Counter application should now be running, and you can access it via http://localhost:8080 in your web browser or by making API requests to the exposed endpoint.

   Please refer to the application's documentation or source code for more information on how to use and interact with the Counter application.
   ````shell
   docker run -d -p 8080:8080 --name counter-app --network p-nut-counter counter
