FROM maven:3.6-openjdk-11

COPY . .

RUN mvn clean package

EXPOSE 3000

ENTRYPOINT java -jar target/*.jar
