# Build stage
FROM maven:3.5-jdk-8 AS build
WORKDIR /usr/src/app
COPY src ./src  
COPY pom.xml .
RUN mvn -f pom.xml clean package

# Package stage
FROM openjdk:8
COPY --from=build /usr/src/app/target/swagger-jaxrs-server-1.0.0.jar /usr/app/swagger-jaxrs-server-1.0.0.jar
EXPOSE 8080  
ENTRYPOINT ["java","-jar","/usr/app/swagger-jaxrs-server-1.0.0.jar"]