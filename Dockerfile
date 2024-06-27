FROM openjdk:17
ADD /target/demo-0.0.1-SNAPSHOT.jar water_db.jar
ENTRYPOINT ["java", "-jar", "water_db.jar"]