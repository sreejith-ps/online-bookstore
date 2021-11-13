FROM adoptopenjdk/openjdk11:latest
COPY target/*.jar service-registry.jar
EXPOSE 8762
ENTRYPOINT ["java", "-jar", "service-registry.jar"]