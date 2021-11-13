FROM adoptopenjdk/openjdk11:latest
COPY target/*.jar checkout-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "checkout-service.jar"]