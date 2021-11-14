FROM adoptopenjdk/openjdk11:latest
COPY target/*.jar gateway-service.jar
EXPOSE 8989
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]