#FROM eclipse-temurin:17-jdk-focal
FROM openjdk:17

# it create folder with name myapp in container
WORKDIR /myapp

COPY target/docker-demo-project.jar /myapp/docker-demo-project.jar

EXPOSE 8081

# Set environment variable for database connect from docker container to local database
#ENV DB_HOST=host.docker.internal
# Set the database container's IP address as an environment variable  for connection project docker container to database container
#ENV DB_HOST=172.17.0.3

# Set the database container's name as an environment variable for connecting the project container to the database container on the same network
ENV DB_HOST=mysqldb

ENTRYPOINT ["java", "-jar", "/myapp/docker-demo-project.jar"]
