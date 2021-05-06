FROM maven:3.5-jdk-8 AS build
WORKDIR /usr/src/app
COPY src ./src  
COPY pom.xml .
COPY .env .
# RUN mvn -f pom.xml clean package

ENTRYPOINT ["mvn", "clean", "package", "jetty:run"]
 
