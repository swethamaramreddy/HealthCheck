FROM openjdk:1.8
ADD target/HealthCheck-0.0.1-SNAPSHOT.jar HealthCheck-prod.jar
ENTRYPOINT ["java","-jar","HealthCheck-prod.jar"]
