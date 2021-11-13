FROM adoptopenjdk/openjdk11:latest
COPY target/*.jar book-mgmt-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "book-mgmt-service.jar"]