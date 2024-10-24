FROM maven:3.8.3-openjdk-17 as build
WORKDIR /app
COPY . /app/
RUN mvn clean package

FROM openjdk:17-jdk
COPY --from=build /app/target/identity-service-0.0.1-SNAPSHOT.jar /app/identity-service.jar
CMD java -jar /appidentity-service.jar