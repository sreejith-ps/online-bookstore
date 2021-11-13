FROM adoptopenjdk/openjdk11:latest
COPY target/*.jar gateway-service.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]