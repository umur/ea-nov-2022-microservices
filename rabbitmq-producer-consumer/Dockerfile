FROM adoptopenjdk/openjdk11
WORKDIR /home/app
COPY /rabbitmq-producer-consumer/target/rabbitmq-producer-consumer-0.0.1-SNAPSHOT.jar /home/app/app.jar
ENTRYPOINT ["java", "-jar", "/home/app/app.jar"]