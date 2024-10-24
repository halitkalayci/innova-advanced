# Elimde işletim sistemi dahil hiç bir kurulumu olmayan 0 bir makine var
# o makineye bu kodları nasıl çalıştırtırım?

# imagei maven'dan başlat (maven arkada linux ve jdk sahibi)
FROM maven:3.8.3-openjdk-17 as build
# app isminde bir klasör oluştur
WORKDIR /app
# tüm projeyi bu klasöre kopyala
COPY . /app/
# projeyi derle
# RUN => Eğer imagein oluşma aşamasında ise komut RUN ile çalıştırılır.
RUN mvn clean package

# jdk katmanına dön
FROM openjdk:17-jdk
# çalıştırılacak jar dosyasını farklı bi konuma kopyaladım
COPY --from=build /app/target/discover-server-0.0.1-SNAPSHOT.jar /app/discover-server.jar
# jar dosyasını çalıştırdım
# CMD => Eğer image container haline çevirilirken çalıştırılıcak ise CMD ile çalıştırılır
CMD java -jar /app/discover-server.jar