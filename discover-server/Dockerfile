# Elimde işletim sistemi dahil hiç bir kurulumu olmayan 0 bir makine var
# o makineye bu kodları nasıl çalıştırtırım?

# imagei maven'dan başlat (maven arkada linux ve jdk sahibi)
FROM maven:3.8.3-openjdk-17 as build
WORKDIR /app
COPY . /app/
RUN mvn clean package

FROM openjdk:17-jdk
COPY --from=build /app/target/discover-server-0.0.1-SNAPSHOT.jar /app/discover-server.jar
CMD java -jar /app/discover-server.jar


