FROM openjdk:11.0
EXPOSE 8080
ADD /target/authorization-service-0.0.1-SNAPSHOT.jar authorization-service.jar
ENTRYPOINT ["java", "-jar", "authorization-service.jar"]