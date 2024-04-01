FROM openjdk:17-jdk
LABEL authors="Praneeth"
COPY target/book-store.jar /app/book-store.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "book-store.jar"]