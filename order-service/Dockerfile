FROM maven:3.8.3-openjdk-17 as build
WORKDIR /app
COPY . /app/
RUN mvn clean package

FROM openjdk:17-jdk
COPY --from=build /app/target/order-service-0.0.1-SNAPSHOT.jar /app/order-service.jar
CMD java -jar /app/order-service.jar